package com.aldiariq.restfulconsume

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldiariq.restfulconsume.ui.autentikasi.AutentikasiActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        finish()
        startActivity(Intent(this, AutentikasiActivity::class.java))
    }
}