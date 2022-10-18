package com.cv.cv2p3

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.cv.cv2p3.databinding.FragmentLastBinding
class LastFragment : Fragment() {

    private lateinit var binding: FragmentLastBinding
    private lateinit var appPreferences: SharedPreferences
    private var gson: Gson = Gson()

    private fun goToSkillsFragment() {
        childFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView2, SkillsFragment())
            .commit()
    }

    private fun goToLanguageFragment() {
        childFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView2, LanguageFragment())
            .commit()
    }

    private fun goToHobbyFragment() {
        childFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView2, HobbiesFragment())
            .commit()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.hbBtn.setOnClickListener { goToHobbyFragment() }
        binding.langBtn.setOnClickListener { goToLanguageFragment() }
        binding.skillsBtn.setOnClickListener { goToSkillsFragment() }
        val fData = appPreferences.getString("firstData", null)
        val data = gson.fromJson(fData, FirstData::class.java)
        binding.email.text = data.email
        binding.name.text = data.name
        binding.career.setOnClickListener {
            findNavController().navigate(R.id.action_lastFragment_to_careerFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLastBinding.inflate(inflater, container, false)
        appPreferences =
            requireActivity().getSharedPreferences("local_shared_pref", Context.MODE_PRIVATE)
        return binding.root
    }
}