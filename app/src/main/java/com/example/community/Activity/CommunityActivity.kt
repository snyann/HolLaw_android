package com.example.community.Activity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Insets.add
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.Insets.add
import com.example.RV.PostInfo
import com.example.community.PostAdapter
import com.example.community.R
import com.example.community.databinding.ActivityCommunityBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase

class CommunityActivity : AppCompatActivity() {

    private lateinit var fbAuth: FirebaseAuth
    lateinit var binding: ActivityCommunityBinding
    private var itemList = arrayListOf<PostList>() //리스트 아이템 배열
    private lateinit var fbdb:DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCommunityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fbAuth = FirebaseAuth.getInstance() //

        binding.ibWriting.setOnClickListener{
            val intent = Intent(this, WritingActivity::class.java)
            intent.putExtra("uid",fbAuth.currentUser?.uid)
            startActivity(intent)
        }
        var postadapter = PostAdapter(itemList) //리사이클러뷰 어댑터
        //itemList.adapter=postadapter

        fbdb = FirebaseDatabase.getInstance().getReference().child("uid")
        //리스트 업데이트
        fbdb.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(dataSnapshot: DatabaseError) {
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
            for(data in dataSnapshot.children){

                val postResult = data.getValue(PostInfo::class.java)
                postResult?: return
            }
                postadapter.notifyDataSetChanged()
            }

        })


    }

}