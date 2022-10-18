package com.cv.cv2p3

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.cv.cv2p3.databinding.FragmentLanguageBinding

class LanguageFragment : Fragment() {
    private lateinit var binding: FragmentLanguageBinding
    private lateinit var appPreferences: SharedPreferences
    private var gson: Gson = Gson()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sData = appPreferences.getString("secondData", null)
        val data = gson.fromJson(sData, SecondData::class.java)
        binding.arabicCheckBox.isEnabled = false
        binding.frenchCheckBox.isEnabled = false
        binding.englishCheckBox.isEnabled = false
        binding.arabicCheckBox.isChecked = data.isArabic
        binding.frenchCheckBox.isChecked = data.isFrench
        binding.englishCheckBox.isChecked = data.isEnglish
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLanguageBinding.inflate(inflater, container, false)
        appPreferences =
            requireActivity().getSharedPreferences("local_shared_pref", Context.MODE_PRIVATE)
        // Inflate the layout for this fragment
        return binding.root
    }
}