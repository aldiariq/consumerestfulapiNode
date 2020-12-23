package com.aldiariq.restfulconsume.ui.autentikasi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aldiariq.restfulconsume.network.Resource
import com.aldiariq.restfulconsume.repository.AutentikasiRepository
import com.aldiariq.restfulconsume.response.MasukResponse
import com.google.gson.JsonObject
import kotlinx.coroutines.launch

class AutentikasiViewModel(
    private val repository: AutentikasiRepository
) : ViewModel() {

    private val _masukResponse : MutableLiveData<Resource<MasukResponse>> = MutableLiveData()
    val masukResponse: LiveData<Resource<MasukResponse>>
    get() = _masukResponse

    fun masuk(
        datamasuk: JsonObject
    ) = viewModelScope.launch {
        _masukResponse.value = repository.masuk(datamasuk)
    }

}