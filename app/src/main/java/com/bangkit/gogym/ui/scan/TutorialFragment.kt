package com.bangkit.gogym.ui.scan

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bangkit.gogym.R
import com.bangkit.gogym.databinding.FragmentTutorialBinding
import com.bumptech.glide.Glide
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem

class TutorialFragment : Fragment() {

    companion object {
        val TAG = "TUTORIALFRAGMENT"
    }



    private lateinit var viewModel: TutorialViewModel
    private lateinit var binding: FragmentTutorialBinding
    private var player: ExoPlayer? = null
    private var player2: ExoPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTutorialBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[TutorialViewModel::class.java]

        val id = TutorialFragmentArgs.fromBundle(arguments as Bundle).id

        viewModel.getEquipmentDetail(id)

        viewModel.equipmentDetail.observe(viewLifecycleOwner){ response ->
            if(response?.error != true) {
                if (response != null) {
                    Log.d(TAG, "onViewCreated: ${response.equipment.name}")
                    binding.tvTitle.text = response.equipment.name
                    binding.tvDesc.text = response.equipment.description
                    val imgUrl = response.equipment.photoUrl
                    val url1 = response.equipment.ref1Url
                    val url2 = response.equipment.ref2Url
                    Log.d(TAG, "onViewCreated: ${imgUrl}")

                    Glide.with(binding.ivEquipment)
                        .load(imgUrl)
                        .into(binding.ivEquipment)


                    initPlayer(url1, url2)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        releasePlayer()
    }

    private fun initPlayer(url1: String, url2: String) {
        val mediaItem1 = MediaItem.fromUri(url1)
        val mediaItem2 = MediaItem.fromUri(url2)


        player = ExoPlayer.Builder(requireActivity()).build().also { exoPlayer ->
            binding.videoView1.player = exoPlayer
            exoPlayer.setMediaItem(mediaItem1)
            exoPlayer.prepare()
        }

        player2 = ExoPlayer.Builder(requireActivity()).build().also { exoPlayer ->
            binding.videoView2.player = exoPlayer
            exoPlayer.setMediaItem(mediaItem2)
            exoPlayer.prepare()
        }

    }

    private fun releasePlayer() {
        player?.release()
        player = null
        player2?.release()
        player2 = null
    }

}