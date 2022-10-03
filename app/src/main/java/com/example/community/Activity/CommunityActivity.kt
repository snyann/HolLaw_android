package com.example.community.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.RV.PostInfo
import com.example.adapters.CommunityAdapter
import com.example.community.databinding.ActivityCommunityBinding
import com.example.models.CommunityList
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class CommunityActivity : AppCompatActivity() {

    private lateinit var fbAuth: FirebaseAuth
    lateinit var binding: ActivityCommunityBinding
    //private var itemList = arrayListOf<CommunityList>() //리스트 아이템 배열
    private lateinit var fbdb:FirebaseDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCommunityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ibWriting.setOnClickListener{
            val intent = Intent(this, WritingActivity::class.java)
            startActivity(intent)
        }


        fbdb = FirebaseDatabase.getInstance()
        val ref : DatabaseReference =fbdb.getReference("PostInfo")

        //리스트 업데이트
        val adapter = CommunityAdapter(CommunityList.communityList)
        binding!!.recyclerView2?.adapter = adapter

        ref.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(dataSnapshot: DatabaseError) {
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for(data in dataSnapshot.children){

                    val postResult = data.getValue(PostInfo::class.java)
                    postResult?: return
                }
                adapter.notifyDataSetChanged()
            }
        })




    }

}
        /*
          ref.child("uid").child("postinfo").get().addOnSuccessListener {
            postinfo = Integer.parseInt(it.value as String)
        }.addOnFailureListener {

        }

          //리스트 업데이트

        .getReference().child("uid")
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



        getPost()

    }

    private fun getPost() {
        fbdb=FirebaseDatabase.getInstance()
       // ref = fbdb.getReference("/uid/postinfo")
        val ref : DatabaseReference =fbdb.getReference("PostInfo")

        ref.addValueEventListener(object:ValueEventListener
        {
            override fun onDataChange(datasnapshot: DataSnapshot) {
                for(data in datasnapshot.children){
                    val postResult = data.getValue(PostInfo::class.java)
                    postResult?: return
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

    }


}*/