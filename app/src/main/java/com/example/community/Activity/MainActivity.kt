package com.example.community.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

import com.example.community.R
import com.example.community.databinding.ActivityLoginBinding
import com.example.community.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val fragmentManager: FragmentManager? = null
    private val btn_mypage: Button? = null
    private val btn_register: Button? = null
    private val et_id: EditText? = null
    private val et_password: EditText? = null
    lateinit var binding: ActivityMainBinding // ActivityLogin 바인딩




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_mypage = findViewById<ImageButton>(R.id.btn_mypage)
        btn_mypage.setOnClickListener {
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }
        val btn_search = findViewById<ImageButton>(R.id.btn_search)
        btn_search.setOnClickListener {
            val intent = Intent(applicationContext, ResultActivity::class.java)
            startActivity(intent)
        }
        val btn_community = findViewById<View>(R.id.btn_community) as Button
        btn_community.setOnClickListener {
            val intent = Intent(applicationContext, CommunityActivity::class.java)
            startActivity(intent)
        }
        val btn_chatbot = findViewById<View>(R.id.btn_chatbot) as ImageButton
        btn_chatbot.setOnClickListener {
            val intent = Intent(applicationContext, ChatbotActivity::class.java)
            startActivity(intent)
        }
        val btn_update = findViewById<View>(R.id.btn_update) as ImageButton
        btn_chatbot.setOnClickListener {
            val intent = Intent(applicationContext, RssActivity::class.java)
            startActivity(intent)
        }
    }
}