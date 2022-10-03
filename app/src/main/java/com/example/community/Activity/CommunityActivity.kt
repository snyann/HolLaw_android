package com.example.community.Activity

import android.content.Intent
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.RV.PostInfo
import com.example.adapters.CommunityAdapter
import com.example.community.databinding.ActivityCommunityBinding
import com.example.models.CommunityList
import com.example.models.CommunityList.communityList
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import io.opencensus.tags.unsafe.ContextUtils.getValue

class CommunityActivity : AppCompatActivity() {

    private lateinit var fbAuth: FirebaseAuth
    lateinit var binding: ActivityCommunityBinding
    private var itemList = arrayListOf<PostInfo>()//리스트 아이템 배열
    private lateinit var fbdb:FirebaseDatabase
    private var adapter = CommunityAdapter(itemList)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCommunityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ibWriting.setOnClickListener{
            val intent = Intent(this, WritingActivity::class.java)
            startActivity(intent)
        }
        itemList.clear()
        adapter.notifyDataSetChanged()


        fbdb = FirebaseDatabase.getInstance()
        val ref : DatabaseReference =fbdb.getReference("PostInfo")

        //리스트 업데이트

        ref.addValueEventListener(object : ValueEventListener{

            override fun onCancelled(dataSnapshot: DatabaseError) {
            }

            override fun onDataChange(Snapshot: DataSnapshot) {
                itemList.clear()
                for(shot in Snapshot.children){
                    val data_title = shot.value.toString()
                    val data_content = shot.value.toString()
                    val title = data_title
                    val content = data_content
                    val C = PostInfo(title,content)

                    itemList.add(C)
                }
                adapter.notifyDataSetChanged()
            }
        })

        binding!!.recyclerView2?.adapter = adapter




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