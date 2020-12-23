package com.aldiariq.restfulconsume.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aldiariq.restfulconsume.repository.AutentikasiRepository
import com.aldiariq.restfulconsume.repository.BaseRepository
import com.aldiariq.restfulconsume.ui.autentikasi.AutentikasiViewModel

class ViewModelFactory (
    private val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(AutentikasiViewModel::class.java) -> AutentikasiViewModel(repository as AutentikasiRepository) as T
            else -> throw IllegalArgumentException("ViewModelClass Tidak Ditemukan")
        }
    }
}