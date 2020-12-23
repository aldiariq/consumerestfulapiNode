package com.aldiariq.restfulconsume.repository

import com.aldiariq.restfulconsume.network.AutentikasiApi
import com.google.gson.JsonObject

class AutentikasiRepository(
        private val api: AutentikasiApi
) : BaseRepository(){

    suspend fun masuk(
            datamasuk: JsonObject
    ) = safeApiCall {
        api.masuk(datamasuk)
    }

}