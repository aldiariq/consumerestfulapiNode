package com.aldiariq.restfulconsume.network

import okhttp3.ResponseBody

sealed class Resource<out T> {
    data class Berhasil<out T>(val value: T) : Resource<T>()

    data class Gagal(
            val kesalahanKoneksi: Boolean,
            val kodeError: Int?,
            val errorBody: ResponseBody?
    ) : Resource<Nothing>()
}