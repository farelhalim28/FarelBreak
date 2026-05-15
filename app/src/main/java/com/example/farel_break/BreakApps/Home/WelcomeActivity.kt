package com.example.farel_break.BreakApps.Home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.farel_break.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Setup Toolbar agar warna hijau dan judul muncul
        setSupportActionBar(binding.toolbarWelcome)
        supportActionBar?.apply {
            title = "Welcome Page"
            setDisplayHomeAsUpEnabled(true) // Munculin tombol back
        }

        // 2. Ambil data username dari intent
        val username = intent.getStringExtra("USERNAME") ?: "Pengguna"
        binding.tvWelcomeUsername.text = "Halo, $username! 👋"

        // 3. Tombol lanjutkan untuk menutup activity ini
        binding.btnContinue.setOnClickListener {
            finish()
        }
    }

    // 4. Handle tombol back di Toolbar (biar gak error pas dipencet)
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}