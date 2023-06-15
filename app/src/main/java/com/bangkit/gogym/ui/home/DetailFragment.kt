package com.bangkit.gogym.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bangkit.gogym.R
import com.bangkit.gogym.databinding.FragmentDetailBinding
import com.bumptech.glide.Glide
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem

class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    //private lateinit var viewModel: DetailViewModel
    private lateinit var binding: FragmentDetailBinding
    private var player: ExoPlayer? = null
    private var player2: ExoPlayer? = null
    //private val link = "https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/2023-06-08%2016-57-32.mp4"



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val judul = DetailFragmentArgs.fromBundle(arguments as Bundle).judul
        val deskripsi = DetailFragmentArgs.fromBundle(arguments as Bundle).deskripsi
        val gambar = DetailFragmentArgs.fromBundle(arguments as Bundle).gambar
        val url1 = DetailFragmentArgs.fromBundle(arguments as Bundle).url1
        val url2 = DetailFragmentArgs.fromBundle(arguments as Bundle).url2


        binding.tvTitle.text = judul
        binding.tvDesc.text = deskripsi

        Glide.with(binding.ivEquipment)
            .load(gambar)
            .into(binding.ivEquipment)


//        val link = "https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/2023-06-08%2016-57-32.mp4"
//        val player = ExoPlayer.Builder(requireActivity()).build()
//        binding.videoView1.player = player
//
//        val mediaItem = MediaItem.fromUri(link)
//        player.setMediaItem(mediaItem)
//        player.prepare()
        initPlayer(url1, url2)
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