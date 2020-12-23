package com.aldiariq.restfulconsume.ui.autentikasi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.aldiariq.restfulconsume.databinding.FragmentMasukBinding
import com.aldiariq.restfulconsume.network.AutentikasiApi
import com.aldiariq.restfulconsume.network.Resource
import com.aldiariq.restfulconsume.repository.AutentikasiRepository
import com.aldiariq.restfulconsume.ui.base.BaseFragment
import com.google.gson.JsonObject
import org.json.JSONObject


class MasukFragment : BaseFragment<AutentikasiViewModel, FragmentMasukBinding, AutentikasiRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.masukResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Berhasil -> {
                    Toast.makeText(context, "Berhasil Masuk", Toast.LENGTH_SHORT).show()
                }
                is Resource.Gagal -> {
                    Toast.makeText(context, "Gagal Masuk", Toast.LENGTH_SHORT).show()
                }
            }
        })

        binding.btnmasukMasuk.setOnClickListener {
            val email = binding.etemailMasuk.text.toString().trim()
            val password = binding.etpasswordMasuk.text.toString().trim()
            val paramObject = JsonObject()
            paramObject.addProperty("email", email)
            paramObject.addProperty("password", password)
            viewModel.masuk(paramObject)
        }
    }

    override fun getViewModel() = AutentikasiViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentMasukBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = AutentikasiRepository(
        remoteDataSource.buildApi(
            AutentikasiApi::class.java
        )
    )

}