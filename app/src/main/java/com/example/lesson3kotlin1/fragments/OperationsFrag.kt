package com.example.lesson3kotlin1.fragments

import com.example.lesson3kotlin1.MainViewModel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.lesson3kotlin1.databinding.FragmentOperationsBinding

class OperationsFrag : Fragment() {

    private lateinit var binding: FragmentOperationsBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOperationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAdd.setOnClickListener { viewModel.plus() }
        binding.btnMinus.setOnClickListener { viewModel.minus() }
    }

}