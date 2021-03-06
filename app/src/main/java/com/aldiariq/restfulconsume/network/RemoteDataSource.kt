package com.aldiariq.restfulconsume.network

import com.aldiariq.restfulconsume.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource {
    companion object{
        private const val BASE_URL = "http://192.168.100.20:3000/api/";
    }

    fun<Api> buildApi(
            api: Class<Api>
    ) : Api {
        return Retrofit.Builder().baseUrl(BASE_URL).client(OkHttpClient.Builder().also {
            client ->
            if (BuildConfig.DEBUG){
                val logging = HttpLoggingInterceptor();
                logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
                client.addInterceptor(logging)
            }
        }.build()).addConverterFactory(GsonConverterFactory.create()).build().create(api);
    }
}