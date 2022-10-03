package com.example.community.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.RV.PostInfo
import com.example.adapters.CommunityAdapter
import com.example.community.databinding.ActivityCommunityBinding
import com.example.community.databinding.ActivityResultBinding
import com.example.models.CommunityList
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class CommunityActivity : AppCompatActivity() {

    private lateinit var fbAuth: FirebaseAuth
    lateinit var binding: ActivityCommunityBinding
    //private var itemList = arrayListOf<CommunityList>() //리스트 아이템 배열
    private lateinit var fbdb:DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCommunityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //리스트 업데이트
        val adapter = CommunityAdapter(CommunityList.communityList)
        binding?.recyclerView2?.adapter = adapter

        binding.ibWriting.setOnClickListener{
            val intent = Intent(this, WritingActivity::class.java)
            intent.putExtra("uid",fbAuth.currentUser?.uid)
            startActivity(intent)
        }


        fbdb = FirebaseDatabase.getInstance().getReference().child("uid")
        fbAuth = FirebaseAuth.getInstance()


        fbdb.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(dataSnapshot: DatabaseError) {
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
            for(data in dataSnapshot.children){

                val postResult = data.getValue(PostInfo::class.java)
                postResult?: return
            }

            }
        })

        adapter.notifyDataSetChanged()


    }

}