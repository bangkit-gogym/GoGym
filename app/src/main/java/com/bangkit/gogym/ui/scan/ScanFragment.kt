package com.bangkit.gogym.ui.scan

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bangkit.gogym.databinding.FragmentScanBinding
import com.bangkit.gogym.helper.SessionPref
import com.bangkit.gogym.helper.createCustomTempFile
import com.bangkit.gogym.helper.reduceFileImage
import com.bangkit.gogym.helper.uriToFile
//import com.bangkit.gogym.ml.GymModel
//import com.bangkit.gogym.ml.GymModelFix
import com.bangkit.gogym.ml.GymModelRev
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.io.File
import java.nio.ByteBuffer
import java.nio.ByteOrder

class ScanFragment : Fragment() {

    companion object {
        private val REQUIRED_PERMISSIONS = arrayOf(android.Manifest.permission.CAMERA)
        private const val REQUEST_CODE_PERMISSIONS = 10
    }

    val inputSize = 224
    val batchSize = 1
    val numChannels = 3
    val dataTypeSize = 4 // FLOAT32 is 4 bytes in size
    val requiredSize = batchSize * inputSize * inputSize * numChannels * dataTypeSize
    // This property is only valid between onCreateView and
    // onDestroyView.
    private lateinit var binding: FragmentScanBinding
    private lateinit var viewModel: ScanViewModel
    private var getFile: File? = null

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (!allPermissionsGranted()) {
                Toast.makeText(
                    requireContext(),
                    "Tidak mendapatkan permission.",
                    Toast.LENGTH_SHORT
                ).show()
                requireActivity().finish()
            }
        }
    }
    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(requireContext(), it) == PackageManager.PERMISSION_GRANTED
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!allPermissionsGranted()) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                REQUIRED_PERMISSIONS,
                REQUEST_CODE_PERMISSIONS
            )
        }

        viewModel = ViewModelProvider(requireActivity())[ScanViewModel::class.java]

        val pref = SessionPref(requireContext())
        val token = "Bearer ${pref.getUserData(SessionPref.TOKEN)}"

        binding.btnGallery.setOnClickListener {
            startGallery()
        }

        binding.btnCamera.setOnClickListener {
            startCamera()
        }

        lateinit var predictedname: String
        binding.btnProcess.setOnClickListener {
            if (getFile != null) {
                val fileUpload = reduceFileImage(getFile as File)
                val file = getFile
                val requestImageFile = file!!.asRequestBody("image/jpeg".toMediaType())

                val imageMultipart: MultipartBody.Part = MultipartBody.Part.createFormData(
                    "photo",
                    fileUpload.name,
                    requestImageFile
                )

                predictedname = predictImage(file)//.toRequestBody("text/plain".toMediaType())
                Log.d("SCANFRAG", "onViewCreated: $predictedname")
                viewModel.scanPhoto(token, imageMultipart, predictedname)


            } else {
                Toast.makeText(requireContext(), "Tidak ada gambar", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.scanPhoto.observe(viewLifecycleOwner) {
            if (it?.error == false) {
                Toast.makeText(requireContext(), "Berhasil Prediksi", Toast.LENGTH_SHORT).show()
//                binding.tvResult.visibility = View.VISIBLE
//                binding.btnTutorila.visibility = View.VISIBLE
            }
        }


        binding.btnTutorila.setOnClickListener {
            getTutorial(predictedname)
        }



    }


    private fun startGallery() {
        val intent = Intent()
        intent.action = Intent.ACTION_GET_CONTENT
        intent.type = "image/*"
        val chooser = Intent.createChooser(intent, "Choose a Picture")
        launcherIntentGallery.launch(chooser)
    }

    private val launcherIntentGallery = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == AppCompatActivity.RESULT_OK) {
            val selectedImg = result.data?.data as Uri
            selectedImg.let { uri ->
                val myFile = uriToFile(uri, requireActivity())
                getFile = myFile
                binding.ivPreview.setImageURI(uri)
            }
        }
    }

    private fun startCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.resolveActivity(requireActivity().packageManager)
        createCustomTempFile(requireContext()).also {
            val photoURI: Uri = FileProvider.getUriForFile(
                requireActivity(),
                "com.bangkit.gogym",
                it
            )
            currentPhotoPath = it.absolutePath
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
            launcherIntentCamera.launch(intent)
        }
    }

    private lateinit var currentPhotoPath: String

    private val launcherIntentCamera = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if(it.resultCode == AppCompatActivity.RESULT_OK) {
            val myFile = File(currentPhotoPath)
            getFile = myFile
            myFile.let { file ->
                binding.ivPreview.setImageBitmap(BitmapFactory.decodeFile(file.path))
            }
        }
    }

    private fun predictImage(imageFile: File): String {
        val model = GymModelRev.newInstance(requireContext())

        val bitmap = BitmapFactory.decodeFile(imageFile.absolutePath)
        //val byteBuffer = convertBitmapToByteBuffer(bitmap)

        var resized = Bitmap.createScaledBitmap(bitmap, 224, 224, true)

        // Creates inputs for reference.
        val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.FLOAT32)
        val tensorImage = TensorImage(DataType.FLOAT32)
        tensorImage.load(resized)
        //var tbuffer = TensorImage.fromBitmap(resized)
        var byteBuffer = tensorImage.buffer//tbuffer.buffer

        inputFeature0.loadBuffer(byteBuffer)

        // Runs model inference and gets result.
        val outputs = model.process(inputFeature0)
        val outputFeature0 = outputs.outputFeature0AsTensorBuffer
        val scores = outputFeature0.floatArray

        // get the highest score
        var maxScoreIndex = 0
        var maxScore = scores[0]
        for (i in 1 until scores.size) {
            if (scores[i] > maxScore) {
                maxScore = scores[i]
                maxScoreIndex = i
            }
        }

        val classLabels = arrayOf(
                "Aerobic Steppers",
                "Barbell/Dumbbell",
                "Bench Press",
                "Cable Machine",
                "Barbell/Dumbbell",
                "Elliptical",
                "Leg Press Machine",
                "Rowing Machine",
                "Smith Machine",
                "Stationary Bike",
                "Treadmill")

        val predictedLabel = classLabels[maxScoreIndex]


        for (i in 0..10) {
            Log.d("SCANFRAGMENT", "predictImage: ${outputFeature0.floatArray[i]} is ${classLabels[i]}")
        }
        Log.d("SCANFRGMENT", "PREDICTED RESULT : $predictedLabel with a score of $maxScore")

        binding.tvResult.text = "Hasil Prediksi : $predictedLabel \nScore : $maxScore"
        binding.tvResult.visibility = View.VISIBLE
        binding.btnTutorila.visibility = View.VISIBLE


        // Releases model resources if no longer used.
        model.close()
        return predictedLabel
    }

    private fun convertBitmapToByteBuffer(bitmap: Bitmap): ByteBuffer {
        val byteBuffer = ByteBuffer.allocateDirect(requiredSize) // Assuming RGB image
        byteBuffer.order(ByteOrder.nativeOrder())
        val intValues = IntArray(bitmap.width * bitmap.height)
        bitmap.getPixels(intValues, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)
        var pixel = 0
        for (i in 0 until inputSize) {
            for (j in 0 until inputSize) {
                val value = intValues[pixel++]
                byteBuffer.put((value shr 16 and 0xFF).toByte()) // Red
                byteBuffer.put((value shr 8 and 0xFF).toByte()) // Green
                byteBuffer.put((value and 0xFF).toByte()) // Blue
            }
        }
        return byteBuffer
    }

    private fun getTutorial(equipment: String) {
        val tutorialMap = mapOf(
            "Aerobic Steppers" to 4,
            "Barbell/Dumbbell" to 1,
            "Bench Press" to 2,
            "Cable Machine" to 10,
            "Elliptical" to 3,
            "Leg Press Machine" to 9,
            "Rowing Machine" to 5,
            "Smith Machine" to 8,
            "Stationary Bike" to 7,
            "Treadmill" to 6
        )

        val tutorialId = tutorialMap[equipment]

        val toTutorialFragment = ScanFragmentDirections.actionNavigationScanToTutorialFragment()
        toTutorialFragment.id = tutorialId!!

        findNavController().navigate(toTutorialFragment)


    }


}