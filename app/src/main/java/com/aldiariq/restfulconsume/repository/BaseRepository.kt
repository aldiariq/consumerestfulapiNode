package com.aldiariq.restfulconsume.repository

import android.widget.Toast
import com.aldiariq.restfulconsume.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepository {
    suspend fun <T> safeApiCall(
            apiCall: suspend () -> T
    ) : Resource<T> {
        return withContext(Dispatchers.IO){
            try {
                Resource.Berhasil(apiCall.invoke())
            }catch (throwable: Throwable){
                when(throwable){
                    is HttpException -> {
                        Resource.Gagal(false, throwable.code(), throwable.response()?.errorBody())
                    }
                    else -> {
                        Resource.Gagal(true, null, null)
                    }
                }
            }
        }
    }
}