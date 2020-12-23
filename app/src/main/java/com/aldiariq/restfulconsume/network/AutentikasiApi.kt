package com.aldiariq.restfulconsume.network

import com.aldiariq.restfulconsume.response.MasukResponse
import com.google.gson.JsonObject
import retrofit2.http.*

interface AutentikasiApi {

    @POST("autentikasi/masuk")
    suspend fun masuk(
            @Body datamasuk: JsonObject
    ) : MasukResponse

    @POST("autentikasi/daftar")
    fun daftar(
        @Body body: String
    ) : Any
}