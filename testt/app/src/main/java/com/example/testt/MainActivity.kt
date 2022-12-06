package com.example.testt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val list: MutableList<Company> = arrayListOf()

    private val adapter by lazy {
        Adapter()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter.updateList(getlist())
        findViewById<RecyclerView>(R.id.RV).adapter = adapter
        findViewById<RecyclerView>(R.id.RV).layoutManager = layoutManager
    }
    private fun getlist(): MutableList<Company> {
        list.add(Company(R.drawable.ic_logo_esprit,"Esprit","ariana", "10/10/2022","10/09/2022","azeazdfygzufyizefzegfyazgyazfyuazfayfcazyvazyfazuyvazyvcazyfazufayzdgiugxqshcvyzfaziygfyzag"))
        list.add(Company(R.drawable.ic_logo_facebook,"facebitsouk","bradaa","32/13/2022","33/13/2023","ufyizefzegfyazgyazfyuazfayfcazyvazyfazuyvazyvcazyfufyizefzegfyazgyazfyuazfayfcazyvazyfazuyvazyvcazyfufyizefzegfyazgyazfyuazfayfcazyvazyfazuyvazyvcazyfufyizefzegfyazgyazfyuazfayfcazyvazyfazuyvazyvcazyfufyizefzegfyazgyazfyuazfayfcazyvazyfazuyvazyvcazyfufyizefzegfyazgyazfyuazfayfcazyvazyfazuyvazyvcazyf"))
        list.add(Company(R.drawable.ic_logo_linkedin,"linkedin","tataouin","32/13/2022","33/13/2023","ufyizefzegfyazgyazfyuazfayfcazyvazyfazuyvazyvcazyfufyizefzegfyazgyazfyuazfayfcazyvazyfazuyvazyvcazyfufyizefzegfyazgyazfyuazfayfcazyvazyfazuyvazyvcazyfufyizefzegfyazgyazfyuazfayfcazyvazyfazuyvazyvcazyfufyizefzegfyazgyazfyuazfayfcazyvazyfazuyvazyvcazyfufyizefzegfyazgyazfyuazfayfcazyvazyfazuyvazyvcazyf"))
        list.add(Company(R.drawable.ic_logo_google,"googel","tunisia","32/13/2022","33/13/2023","ufyizefzegfyazgyazfyuazfayfcazyvazyfazuyvazyvcazyfufyizefzegfyazgyazfyuazfayfcazyvazyfazuyvazyvcazyfufyizefzegfyazgyazfyuazfayfcazyvazyfazuyvazyvcazyfufyizefzegfyazgyazfyuazfayfcazyvazyfazuyvazyvcazyfufyizefzegfyazgyazfyuazfayfcazyvazyfazuyvazyvcazyfufyizefzegfyazgyazfyuazfayfcazyvazyfazuyvazyvcazyf"))
        
        return list
    }
}