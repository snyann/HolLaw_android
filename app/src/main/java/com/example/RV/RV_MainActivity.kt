package com.example.RV

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.community.R

class RV_MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val adapter = LawAdapter(LawList.lawList)
        recyclerView.adapter = adapter

    }
}


