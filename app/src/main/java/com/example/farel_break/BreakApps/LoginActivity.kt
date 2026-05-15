package com.example.farel_break.BreakApps

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.farel_break.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupPasswordToggle()
        setupLoginButton()

        // Pindah ke halaman Registrasi (Soal A1)
        binding.tvToRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun setupPasswordToggle() {
        binding.ivTogglePassword.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible) {
                binding.etPassword.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                binding.ivTogglePassword.alpha = 1.0f
            } else {
                binding.etPassword.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                binding.ivTogglePassword.alpha = 0.5f
            }
            binding.etPassword.setSelection(binding.etPassword.text.length)
        }
    }

    private fun setupLoginButton() {
        binding.btnLogin.setOnClickListener {
            val usernameInput = binding.etUsername.text.toString().trim()
            val passwordInput = binding.etPassword.text.toString().trim()

            // Validasi input kosong
            if (usernameInput.isEmpty()) {
                binding.etUsername.error = "Username tidak boleh kosong"
                return@setOnClickListener
            }
            if (passwordInput.isEmpty()) {
                binding.etPassword.error = "Password tidak boleh kosong"
                return@setOnClickListener
            }

            // Ambil data dari SharedPreferences (Data hasil Registrasi Soal A3)
            val sharedPref = getSharedPreferences("user_pref", Context.MODE_PRIVATE)
            val registeredUser = sharedPref.getString("reg_user", "")
            val registeredPass = sharedPref.getString("reg_pass", "")

            // LOGIKA LOGIN (SOAL A3)
            // Rule 1: Username sama dengan Password
            val rule1 = usernameInput == passwordInput

            // Rule 2: Username & Password cocok dengan data Registrasi di SP
            val rule2 = usernameInput == registeredUser && passwordInput == registeredPass

            if (rule1 || rule2) {
                // Simpan status login
                sharedPref.edit().apply {
                    putBoolean("isLogin", true)
                    putString("username", usernameInput)
                    apply()
                }

                Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, BaseActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            } else {
                Toast.makeText(this, "Username atau Password Salah!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}