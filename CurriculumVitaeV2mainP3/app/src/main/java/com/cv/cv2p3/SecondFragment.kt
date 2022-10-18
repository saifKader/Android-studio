package com.cv.cv2p3

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.cv.cv2p3.databinding.FragmentSecondBinding
class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private val langList = mutableListOf<String>()
    private val hobbiesList = mutableListOf<String>()
    private lateinit var appPreferences: SharedPreferences
    private var gson: Gson = Gson()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        langList.clear()
        hobbiesList.clear()

        binding.submitBtn.setOnClickListener {
            getLanguages()
            getHobbies()
            if (langList.isEmpty() || hobbiesList.isEmpty()) {
                Toast.makeText(context, "please check at least one lang/hobby", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val dataRequest = SecondData(
                    binding.androidBar.progress,
                    binding.iosBar.progress,
                    binding.flutterBar.progress,
                    langList.contains("Arabic"),
                    langList.contains("English"),
                    langList.contains("French"),
                    hobbiesList.contains("Music"),
                    hobbiesList.contains("Sports"),
                    hobbiesList.contains("Games"),
                )
                appPreferences.edit().putString("secondData", gson.toJson(dataRequest)).apply()
                findNavController().navigate(R.id.action_secondFragment_to_lastFragment)
            }
        }
    }

    private fun getLanguages() {
        if (binding.arabicCheckBox.isChecked) {
            langList.add(binding.arabicCheckBox.text.toString())

        }
        if (binding.englishCheckBox.isChecked) {
            langList.add(binding.englishCheckBox.text.toString())
        }
        if (binding.frenchCheckBox.isChecked) {
            langList.add(binding.frenchCheckBox.text.toString())
        }
    }

    private fun getHobbies() {
        if (binding.sportsCheckBox.isChecked) {
            hobbiesList.add(binding.sportsCheckBox.text.toString())
        }
        if (binding.musivCheckBox.isChecked) {
            hobbiesList.add(binding.musivCheckBox.text.toString())
        }
        if (binding.gamesCheckBox.isChecked) {
            hobbiesList.add(binding.gamesCheckBox.text.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        appPreferences =
            requireActivity().getSharedPreferences("local_shared_pref", Context.MODE_PRIVATE)
        return binding.root
    }
}