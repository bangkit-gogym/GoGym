package com.bangkit.gogym.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.gogym.EquipmentAdapter
import com.bangkit.gogym.data.response.EquipmentItem
import com.bangkit.gogym.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        val layoutManager = LinearLayoutManager(requireActivity())
        binding.rvEquipment.layoutManager = layoutManager

        viewModel.getListEquipmet()

        viewModel.listEquipment.observe(viewLifecycleOwner) { listEquipment ->
            val adapter = EquipmentAdapter(listEquipment)

            adapter.setOnItemClickCallback(object : EquipmentAdapter.OnItemClickCallback {
                override fun onItemClicked(data: EquipmentItem) {
                    val toDetail = HomeFragmentDirections.actionNavigationHomeToDetailFragment()
                    toDetail.judul = data.name
                    toDetail.deskripsi = data.description
                    toDetail.gambar = data.photoUrl
                    toDetail.url1 = data.ref1Url
                    toDetail.url2 = data.ref2Url
                    findNavController().navigate(toDetail)
                }

            })
            binding.rvEquipment.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}