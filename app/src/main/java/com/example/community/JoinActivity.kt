package com.example.community

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.community.R

class JoinActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)
    }

    override fun onClick(view: View) {}
}