package com.example.community

import android.app.Activity
import android.os.Bundle
import com.example.community.R
import android.widget.ImageButton
import android.content.Intent
import android.view.View
import com.example.community.community_writing
import com.example.community.community_content_list

class community : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_community)
        val ib_writing = findViewById<View>(R.id.ib_writing) as ImageButton
        ib_writing.setOnClickListener {
            val intent = Intent(applicationContext, community_writing::class.java)
            startActivity(intent)
        }
        val ib_community_search = findViewById<View>(R.id.ib_community_search) as ImageButton
        ib_community_search.setOnClickListener {
            val intent = Intent(applicationContext, community_content_list::class.java)
            startActivity(intent)
        }
    }
}