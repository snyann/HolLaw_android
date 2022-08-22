package com.example.community

import android.app.Activity
import android.os.Bundle
import android.view.View
import com.example.community.R
import android.widget.ImageButton

class community_writing : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.community_writing)
        val ib_delete = findViewById<View>(R.id.btn_backspace) as ImageButton
        ib_delete.setOnClickListener { finish() }
    }
}