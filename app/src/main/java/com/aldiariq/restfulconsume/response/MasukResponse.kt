package com.aldiariq.restfulconsume.response

data class MasukResponse(
    val authtoken: String,
    val berhasil: Boolean,
    val pengguna: Pengguna,
    val pesan: String
)