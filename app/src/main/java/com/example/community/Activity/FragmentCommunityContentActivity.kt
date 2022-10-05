package com.example.community.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.RV.CommentData
import com.example.adapters.FragmentCommunityContentAdapter
import com.example.community.R
import com.example.community.databinding.FragmentCommunityContentBinding
import com.example.models.CommentList

class FragmentCommunityContentActivity: AppCompatActivity() {
    var binding: FragmentCommunityContentBinding? = null
    private val CommentList = arrayListOf<CommentData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentCommunityContentBinding.inflate(layoutInflater)
        val view = binding?.root
        setContentView(view)
        binding?.recyclerView?.layoutManager = LinearLayoutManager(this)
        binding?.recyclerView?.adapter = FragmentCommunityContentAdapter(CommentList)

        val btn_backspace = findViewById<ImageButton>(R.id.btn_backspace)
        btn_backspace.setOnClickListener {
            val intent = Intent(applicationContext, CommunityActivity::class.java)
            startActivity(intent)
        }

        val imageButton2 = findViewById<ImageButton>(R.id.imageButton2)
        imageButton2.setOnClickListener{
            addComment()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
    fun addComment() {
        val userComment = CommentData(binding?.editTextTextPersonName2?.text.toString())
        CommentList.add(userComment)

        binding?.recyclerView?.adapter?.notifyDataSetChanged()
    }
}