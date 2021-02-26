package com.pascal.kisahnabiku.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pascal.kisahnabiku.model.ResponseMain
import com.pascal.kisahnabiku.repo.RepositoryMain

class ViewModelMain: ViewModel() {

    val repository = RepositoryMain()

    var responGetData = MutableLiveData<List<ResponseMain>>()
    var isError = MutableLiveData<Throwable>()
    var isLoading = MutableLiveData<Boolean>()

    fun getDataView() {
        isLoading.value = true

        repository.getData({
            isLoading.value = false
            responGetData.value = it
        }, {
            isLoading.value = false
            isError.value = it
        })
    }
}