package com.bangkit.gogym.ui.history

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.gogym.R
import com.bangkit.gogym.databinding.FragmentHistoryBinding
import com.bangkit.gogym.helper.SessionPref

class HistoryFragment : Fragment() {


//    private lateinit var viewModel: HistoryViewModel
    private lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(requireActivity())[HistoryViewModel::class.java]

        val pref = SessionPref(requireContext())
        val token = "Bearer ${pref.getUserData(SessionPref.TOKEN)}"

        val layoutManager = LinearLayoutManager(requireActivity())
        binding.rvHistory.layoutManager = layoutManager

        viewModel.getUserHistory(token)

        viewModel.listHistory.observe(viewLifecycleOwner) { listHistory ->
            val adapter = HistoryAdapter(listHistory)
            binding.rvHistory.adapter = adapter
        }
    }

}