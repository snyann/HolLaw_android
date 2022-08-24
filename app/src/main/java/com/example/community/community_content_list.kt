package com.example.community

import android.app.Activity
import android.os.Bundle
import com.example.community.R
import android.widget.ImageButton
import android.content.Intent
import android.view.View
import com.example.community.community_writing
import com.example.community.community_content_list
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import com.example.community.LoginActivity
import com.example.community.ResultActivity
import com.example.community.CommunityActivity
import com.example.community.JoinActivity

class community_content_list : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_community_content_list)
        val ib_back = findViewById<View>(R.id.ib_back) as ImageButton
        ib_back.setOnClickListener { finish() }
    }
}