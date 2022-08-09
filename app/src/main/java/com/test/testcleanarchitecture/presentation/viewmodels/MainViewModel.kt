package com.test.testcleanarchitecture.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.testcleanarchitecture.domain.models.SaveUserNameParam
import com.test.testcleanarchitecture.domain.usecase.GetUserNameUseCase
import com.test.testcleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {
    //Private live dates
    private val mutableResult = MutableLiveData<String>()
    //Public live dates
    var result: LiveData<String> = mutableResult

    fun saveData(textUser: String) {
        val text: String = textUser
        val nameParam = SaveUserNameParam(name = text)
        val response = saveUserNameUseCase.execute(param = nameParam)
        mutableResult.value = "Save result = $response"
    }
    fun getData() {
        val user = getUserNameUseCase.execute()
        mutableResult.value = "${user.name} ${user.surname}"
    }
}