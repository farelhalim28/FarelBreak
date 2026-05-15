package com.example.farel_break.BreakApps.About

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.farel_break.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup Toolbar
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbarAbout)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Tentang Aplikasi"
        }

        // Isi konten deskripsi
        binding.tvAppName.text = "SIMANDES"
        binding.tvTagline.text = "Sistem Informasi Mandiri & Surat Desa"
        binding.tvDescription.text = "SIMANDES adalah platform digital terintegrasi yang dirancang khusus untuk mendukung percepatan program Bina Desa Digital melalui otomatisasi administrasi dan layanan surat-menyurat desa."
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}