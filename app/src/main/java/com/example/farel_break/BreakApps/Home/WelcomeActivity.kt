package com.example.farel_break.BreakApps.Home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.farel_break.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    // ViewBinding
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi ViewBinding
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil username yang dikirim dari LoginActivity
        val username = intent.getStringExtra("USERNAME") ?: "Pengguna"

        // Tampilkan sapaan dengan nama pengguna
        binding.tvWelcomeUsername.text = "Halo, $username! 👋"

        // Tombol Lanjutkan - kamu bisa arahkan ke activity berikutnya
        binding.btnContinue.setOnClickListener {
            // TODO: Ganti dengan activity tujuan berikutnya
            // Contoh: startActivity(Intent(this, DashboardActivity::class.java))
            finish() // Sementara hanya menutup activity ini
        }
    }
}