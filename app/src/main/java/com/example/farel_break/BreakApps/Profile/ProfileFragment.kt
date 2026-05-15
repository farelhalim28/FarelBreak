package com.example.farel_break.BreakApps.Profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.farel_break.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Lo bisa isi data lo di sini secara manual atau tarik dari SharedPreferences
        binding.tvNamaLengkap.text = "Farel Abdul Halim" // Ganti nama lo
        binding.tvNim.text = "2457301049"
        binding.tvProdi.text = "Sistem Informasi"
        binding.tvKampus.text = "Politeknik Caltex Riau"
        binding.tvEmail.text = "farel24si@mahasiswa.pcr.ac.id"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}