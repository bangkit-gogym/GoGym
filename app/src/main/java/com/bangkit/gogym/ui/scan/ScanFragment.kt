package com.bangkit.gogym.ui.scan

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
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
import com.bangkit.gogym.databinding.FragmentScanBinding
import com.bangkit.gogym.helper.createCustomTempFile
import com.bangkit.gogym.helper.uriToFile
import java.io.File

class ScanFragment : Fragment() {

    companion object {
        private val REQUIRED_PERMISSIONS = arrayOf(android.Manifest.permission.CAMERA)
        private const val REQUEST_CODE_PERMISSIONS = 10
    }

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

        binding.btnGallery.setOnClickListener {
            startGallery()
        }

        binding.btnCamera.setOnClickListener {
            startCamera()
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

}