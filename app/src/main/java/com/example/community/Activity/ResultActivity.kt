package com.example.community.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.adapters.LawAdapter
import com.example.adapters.PrecedentAdapter
import com.example.community.R
import com.example.models.LawList
import com.example.community.databinding.ActivityResultBinding
import com.example.models.PrecedentList

class ResultActivity : AppCompatActivity() {

    var binding: ActivityResultBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val adapter = PrecedentAdapter(PrecedentList.precedentlist)
        binding?.recyclerView?.adapter = adapter

        binding?.radioGroup?.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.radioButton ->{
                    val adapter = PrecedentAdapter(PrecedentList.precedentlist)
                    binding?.recyclerView?.adapter = adapter
                }
                R.id.radioButton2 -> {
                    val adapter = LawAdapter(LawList.lawList)
                    binding?.recyclerView?.adapter = adapter
                }

            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }


}



