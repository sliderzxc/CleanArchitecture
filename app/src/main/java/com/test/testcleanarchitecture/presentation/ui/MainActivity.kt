package com.test.testcleanarchitecture.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.test.testcleanarchitecture.databinding.ActivityMainBinding
import com.test.testcleanarchitecture.presentation.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnGetData.setOnClickListener {
            mainViewModel.getData()
        }

        binding.btnSaveData.setOnClickListener {
            mainViewModel.saveData(textUser = binding.editTextData.text.toString())
        }

        mainViewModel.result.observe(this) {
            binding.textUser.text = it
        }


    }
}