package com.example.community.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.community.R
import com.example.community.databinding.ActivityCommunityBinding
import com.google.firebase.auth.FirebaseAuth

class CommunityActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    lateinit var binding: ActivityCommunityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCommunityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.ibWriting.setOnClickListener{


        }
    }
}