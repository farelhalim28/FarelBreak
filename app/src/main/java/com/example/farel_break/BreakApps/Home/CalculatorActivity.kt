package com.example.farel_break.BreakApps.Home

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.farel_break.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Terima data dari Intent (Judul & Deskripsi)
        val title = intent.getStringExtra("EXTRA_TITLE") ?: "Kalkulator"
        val desc = intent.getStringExtra("EXTRA_DESC") ?: "Rumus Bangun"
        binding.tvHeaderInfo.text = "$title\n$desc"

        // 2. Logika Hitung Segitiga
        binding.btnHitungSegitiga.setOnClickListener {
            val alasStr = binding.etAlas.text.toString()
            val tinggiStr = binding.etTinggi.text.toString()

            if (alasStr.isNotEmpty() && tinggiStr.isNotEmpty()) {
                val alas = alasStr.toDouble()
                val tinggi = tinggiStr.toDouble()
                val hasil = 0.5 * alas * tinggi
                binding.tvHasilSegitiga.text = "Hasil Luas: $hasil"
            } else {
                Toast.makeText(this, "Harap isi semua input!", Toast.LENGTH_SHORT).show()
            }
        }

        // 3. Logika Hitung Balok
        binding.btnHitungBalok.setOnClickListener {
            val pStr = binding.etPanjang.text.toString()
            val lStr = binding.etLebar.text.toString()
            val tStr = binding.etTinggiBalok.text.toString()

            if (pStr.isNotEmpty() && lStr.isNotEmpty() && tStr.isNotEmpty()) {
                val p = pStr.toDouble()
                val l = lStr.toDouble()
                val t = tStr.toDouble()
                val hasil = p * l * t
                binding.tvHasilBalok.text = "Hasil Volume: $hasil"
            } else {
                Toast.makeText(this, "Harap isi semua input!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}