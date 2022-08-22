package com.example.community

import android.app.Activity
import android.os.Bundle
import android.view.View
import com.example.community.R
import android.widget.ImageButton

class community_content_list : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_community_content_list)
        val ib_back = findViewById<View>(R.id.ib_back) as ImageButton
        ib_back.setOnClickListener { finish() }
    }
}