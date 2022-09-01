package com.example.community.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.community.CommunityAdapter
import com.example.community.CommunityList
import com.example.community.databinding.FragmentCommunityBinding

class CommunityActivity : AppCompatActivity() {

    var binding : FragmentCommunityBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentCommunityBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val adapter = CommunityAdapter(CommunityList.communityList)
        binding?.recyclerView2?.adapter = adapter
    }
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}

