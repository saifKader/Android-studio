package com.cv.cv2p3

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.cv.cv2p3.databinding.FragmentSkillsBinding

class SkillsFragment : Fragment() {
    private lateinit var binding: FragmentSkillsBinding
    private lateinit var appPreferences: SharedPreferences
    private var gson: Gson = Gson()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sData = appPreferences.getString("secondData", null)
        val data = gson.fromJson(sData, SecondData::class.java)
        binding.androidBar.isEnabled = false
        binding.iosBar.isEnabled = false
        binding.flutterBar.isEnabled = false
        binding.androidBar.progress = data.androidValue
        binding.iosBar.progress = data.IosValue
        binding.flutterBar.progress = data.flutterValue
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSkillsBinding.inflate(inflater, container, false)
        appPreferences =
            requireActivity().getSharedPreferences("local_shared_pref", Context.MODE_PRIVATE)
        // Inflate the layout for this fragment
        return binding.root
    }
}