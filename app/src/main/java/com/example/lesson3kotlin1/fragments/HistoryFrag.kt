package com.example.lesson3kotlin1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lesson3kotlin1.MainViewModel
import com.example.lesson3kotlin1.databinding.FragmentHistoryBinding

class HistoryFrag : Fragment() {

    private lateinit var binding: FragmentHistoryBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
    }

    private fun initObserver() {
        viewModel.trubaHistoryPlus.observe(viewLifecycleOwner, Observer {
            binding.txtPluses.text = it.toString()
        })

        viewModel.trubaHistoryMinus.observe(viewLifecycleOwner, Observer {
            binding.txtMinuses.text = it.toString()
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }
}
