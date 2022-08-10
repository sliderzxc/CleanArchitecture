package com.test.testcleanarchitecture.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.test.testcleanarchitecture.app.App
import com.test.testcleanarchitecture.databinding.ActivityMainBinding
import com.test.testcleanarchitecture.presentation.viewmodels.MainViewModel
import com.test.testcleanarchitecture.presentation.viewmodels.MainViewModuleFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var mainViewModel: MainViewModel
    @Inject
    lateinit var mainViewModuleFactory: MainViewModuleFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        (applicationContext as App).appComponent.inject(this)

        mainViewModel = ViewModelProvider(this, mainViewModuleFactory)[MainViewModel::class.java]

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