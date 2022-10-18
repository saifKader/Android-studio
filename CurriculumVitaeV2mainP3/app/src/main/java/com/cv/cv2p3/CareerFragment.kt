package com.cv.cv2p3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cv.cv2p3.databinding.FragmentCareerBinding

class CareerFragment : Fragment() {
    private lateinit var binding: FragmentCareerBinding
    private var companies: MutableList<Company> = arrayListOf()
    private var universities: MutableList<University> = arrayListOf()
    private val companyAdapter by lazy {
        CompanyAdapter(
            onItemClicked = {
                //navigate
            }
        )
    }
    private val uniAdapter by lazy {
        UniversityAdapter(
            onItemClicked = {
                //navigate
            }
        )
    }

    private fun setUniversity(): MutableList<University> {
        universities.add(University(R.drawable.ic_logo_esprit, "Esprit", "AAAA", "BBBB", "CCCC"))
        universities.add(University(R.drawable.ic_logo_microsoft,
            "Microsoft",
            "AAAA",
            "BBBB",
            "CCCC"))
        universities.add(University(R.drawable.ic_logo_cambridge,
            "Cambridge",
            "AAAA",
            "BBBB",
            "CCCC"))
        universities.add(University(R.drawable.ic_logo_harvard, "Harvard", "AAAA", "BBBB", "CCCC"))
        return universities
    }

    private fun setCompanies(): MutableList<Company> {
        companies.add(Company(R.drawable.ic_logo_facebook,
            "Facebook",
            "Menlo Park, CA",
            "2019",
            "Present",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod, nunc nec lacinia tincidunt, nunc nisl aliquam nisl, nec lacinia nisl lorem nec nisl."))
        companies.add(Company(R.drawable.ic_logo_linkedin,
            "LinkedIn",
            "Menlo Park, CA",
            "2019",
            "Present",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod, nunc nec lacinia tincidunt, nunc nisl aliquam nisl, nec lacinia nisl lorem nec nisl."))
        companies.add(Company(R.drawable.ic_logo_amazon,
            "Amazon",
            "Menlo Park, CA",
            "2019",
            "Present",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod, nunc nec lacinia tincidunt, nunc nisl aliquam nisl, nec lacinia nisl lorem nec nisl."))
        companies.add(Company(R.drawable.ic_logo_google,
            "Google",
            "Menlo Park, CA",
            "2019",
            "Present",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod, nunc nec lacinia tincidunt, nunc nisl aliquam nisl, nec lacinia nisl lorem nec nisl."))
        return companies
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        //default
        companyAdapter.updateList(setCompanies())
        binding.recyclerView.layoutManager = myLayoutManager
        binding.recyclerView.adapter = companyAdapter

        binding.edu.setOnClickListener {
            uniAdapter.updateList(setUniversity())
            binding.recyclerView.layoutManager = myLayoutManager
            binding.recyclerView.adapter = uniAdapter
        }

        binding.exp.setOnClickListener {
            companyAdapter.updateList(setCompanies())
            binding.recyclerView.layoutManager = myLayoutManager
            binding.recyclerView.adapter = companyAdapter
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCareerBinding.inflate(inflater, container, false)
        return binding.root
    }
}