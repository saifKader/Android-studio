package com.cv.cv2p3

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.cv.cv2p3.databinding.FragmentHobbiesBinding

class HobbiesFragment : Fragment() {
    private lateinit var binding: FragmentHobbiesBinding
    private lateinit var appPreferences: SharedPreferences
    private var gson: Gson = Gson()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sData = appPreferences.getString("secondData", null)
        val data = gson.fromJson(sData, SecondData::class.java)
        binding.sportsCheckBox.isEnabled = false
        binding.musivCheckBox.isEnabled = false
        binding.gamesCheckBox.isEnabled = false
        binding.sportsCheckBox.isChecked = data.isSports
        binding.musivCheckBox.isChecked = data.isMusic
        binding.gamesCheckBox.isChecked = data.isGames
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHobbiesBinding.inflate(inflater, container, false)
        appPreferences =
            requireActivity().getSharedPreferences("local_shared_pref", Context.MODE_PRIVATE)
        // Inflate the layout for this fragment
        return binding.root
    }
}