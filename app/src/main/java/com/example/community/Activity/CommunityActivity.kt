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

        itemList.clear() //리스트 초기화
        adapter.notifyDataSetChanged() //변경시 업데이드


        fbdb = FirebaseDatabase.getInstance()
        val ref : DatabaseReference =fbdb.getReference("PostInfo")


        ref.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(dataSnapshot: DatabaseError) {
            }

            override fun onDataChange(Snapshot: DataSnapshot) {
                itemList.clear()
                for(shot in Snapshot.children){
                    val data_title = shot.key.toString()
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
