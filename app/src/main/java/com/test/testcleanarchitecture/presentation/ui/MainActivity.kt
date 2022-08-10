package com.test.testcleanarchitecture.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.test.testcleanarchitecture.databinding.ActivityMainBinding
import com.test.testcleanarchitecture.presentation.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val mainViewModel: MainViewModel by viewModels()

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