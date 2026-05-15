package com.example.farel_break.BreakApps

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.farel_break.databinding.ActivityRegisterBinding
import java.util.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Dropdown Agama
        val daftarAgama = arrayOf("Islam", "Kristen", "Katolik", "Hindu", "Budha", "Khonghucu")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, daftarAgama)
        binding.actAgama.setAdapter(adapter)

        // Setup DatePicker
        binding.etTglLahir.setOnClickListener {
            val c = Calendar.getInstance()
            DatePickerDialog(this, { _, y, m, d ->
                binding.etTglLahir.setText("$d/${m + 1}/$y")
            }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show()
        }

        binding.btnRegisterSubmit.setOnClickListener { validateAndSave() }
    }

    private fun validateAndSave() {
        val nama = binding.etNama.text.toString()
        val tgl = binding.etTglLahir.text.toString()
        val agama = binding.actAgama.text.toString()
        val user = binding.etUser.text.toString()
        val pass = binding.etPass.text.toString()
        val conf = binding.etConfirmPass.text.toString()
        val genderId = binding.rgGender.checkedRadioButtonId

        var isValid = true

        // Validasi Soal A2 (Menggunakan setError pada TextInputLayout)
        if (nama.isEmpty()) { binding.tilNama.error = "Nama wajib diisi"; isValid = false } else binding.tilNama.error = null
        if (tgl.isEmpty()) { binding.tilTglLahir.error = "Pilih tanggal lahir"; isValid = false } else binding.tilTglLahir.error = null
        if (agama.isEmpty()) { binding.tilAgama.error = "Pilih agama"; isValid = false } else binding.tilAgama.error = null
        if (user.isEmpty()) { binding.tilUser.error = "Username kosong"; isValid = false } else binding.tilUser.error = null

        if (pass.length < 6) {
            binding.tilPass.error = "Minimal 6 karakter"; isValid = false
        } else binding.tilPass.error = null

        if (pass != conf) {
            binding.tilConfirmPass.error = "Password tidak cocok!"; isValid = false
        } else binding.tilConfirmPass.error = null

        if (isValid) {
            // Soal A3: Simpan ke SharedPreference
            val sp = getSharedPreferences("user_pref", Context.MODE_PRIVATE)
            sp.edit().apply {
                putString("reg_user", user)
                putString("reg_pass", pass)
                putString("reg_nama", nama)
                apply()
            }
            finish() // Tutup halaman registrasi balik ke login
        }
    }
}