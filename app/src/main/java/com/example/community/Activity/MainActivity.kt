package com.example.community.Activity

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.example.community.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //액티비티 메인 바인딩
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)


        binding.btnMypage.setOnClickListener(){
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnSearch.setOnClickListener(){
            val intent = Intent(applicationContext, ResultActivity::class.java)
            startActivity(intent)
        }

        binding.btnCommunity.setOnClickListener(){
            val intent = Intent(applicationContext, CommunityActivity::class.java)
            startActivity(intent)
        }

        binding.btnChatbot.setOnClickListener(){
            val intent = Intent(applicationContext, ChatbotActivity::class.java)
            startActivity(intent)
        }

    }



}

