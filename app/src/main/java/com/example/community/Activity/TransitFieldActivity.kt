package com.example.community.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.adapters.PrecedentAdapter
import com.example.community.R
import com.example.community.databinding.ActivityResultBinding
import com.example.community.databinding.FragmentTransitFieldBinding
import com.example.models.PrecedentList

class TransitFieldActivity: AppCompatActivity() {
    var binding : FragmentTransitFieldBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentTransitFieldBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val adapter = PrecedentAdapter(PrecedentList.precedentlist)
        binding?.recyclerView3?.adapter = adapter

        val btn_backspace = findViewById<ImageButton>(R.id.btn_backspace)
        btn_backspace.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}