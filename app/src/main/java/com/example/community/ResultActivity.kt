package com.example.community

import android.app.Activity
import android.os.Bundle
import com.example.community.R
import android.widget.ImageButton
import android.content.Intent
import com.example.community.community_writing
import com.example.community.community_content_list
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import com.example.community.LoginActivity
import com.example.community.ResultActivity
import com.example.community.CommunityActivity
import com.example.community.JoinActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
    }
}