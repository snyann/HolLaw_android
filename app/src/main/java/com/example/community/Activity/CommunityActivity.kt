package com.example.community.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.community.PostAdapter
import com.example.community.PostList
import com.example.community.R
import com.example.community.databinding.ActivityCommunityBinding
import com.google.firebase.auth.FirebaseAuth

class CommunityActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    lateinit var binding: ActivityCommunityBinding
    val itemList = arrayListOf<PostList>() //리스트 아이템 배열
    val adapter = PostAdapter(itemList) //리사이클러뷰 어댑터

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCommunityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance() //

        binding.ibWriting.setOnClickListener{
            val intent = Intent(this, WritingActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


}