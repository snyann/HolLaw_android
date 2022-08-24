package com.example.community

import android.app.Activity
import android.os.Bundle
import com.example.community.R
import android.widget.ImageButton
import android.content.Intent
import android.view.View
import android.widget.Button
import com.example.community.community_writing
import com.example.community.community_content_list
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import androidx.fragment.app.FragmentManager
import com.example.community.LoginActivity
import com.example.community.ResultActivity
import com.example.community.CommunityActivity
import com.example.community.JoinActivity

class MainActivity : AppCompatActivity() {
    private val fragmentManager: FragmentManager? = null
    private val btn_mypage: Button? = null
    private val btn_register: Button? = null
    private val et_id: EditText? = null
    private val et_password: EditText? = null
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
    }
}