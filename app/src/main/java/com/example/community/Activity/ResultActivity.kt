package com.example.community.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.community.LawAdapter
import com.example.community.LawList
import com.example.community.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    var binding: ActivityResultBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val adapter = LawAdapter(LawList.lawList)
        binding?.recyclerView?.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}