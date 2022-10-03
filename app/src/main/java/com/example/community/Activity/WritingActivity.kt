package com.example.community.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.example.RV.PostInfo
import com.example.community.R
import com.example.community.databinding.ActivityWritingBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserInfo
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.Exclude
import com.google.firebase.database.FirebaseDatabase

import com.google.firebase.ktx.Firebase
import java.util.*

class WritingActivity : AppCompatActivity() {
    private lateinit var fbAuth: FirebaseAuth
    private var uid:String=""
    private var category:String=""
    lateinit var binding: ActivityWritingBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWritingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // firebaseAuth = FirebaseAuth.getInstance() //로그인 정보 가져와야함
        if (intent.hasExtra("uid")) {
            uid = intent.getStringExtra("uid").toString()
        }


        //라디오 버튼 값 넘기기
        binding.radioGroup.setOnCheckedChangeListener { group, checkedId
            ->
            when (checkedId) {
                R.id.rb_work -> category = "근로"
                R.id.rb_traffic -> category = "교통"
                R.id.rb_realestate -> category = "부동산"
            }
            /*  fun onRadioButtonClicked(view: View) {
                if (view is RadioButton) {
                    // Is the button now checked?
                    val checked = view.isChecked

                    // Check which radio button was clicked
                    when (view.getId()) {
                        R.id.rb_work ->
                            if (checked) {
                                // Pirates are the best
                            }
                        R.id.rb_traffic ->
                            if (checked) {
                                // Ninjas rule
                            }
                        R.id.rb_realestate ->
                            if (checked) {
                                // Ninjas rule
                            }
                    }
                }
            }*/

            binding.btnComplete.setOnClickListener {
                val title:String = binding.writeTitle.text.toString()
                val content:String = binding.writeContent.text.toString()

                setPost(title,content)

            }

        }


    }

    private fun setPost(
        title: String, content: String
    ) {
        val fbdb=FirebaseDatabase.getInstance()
        val ref : DatabaseReference =fbdb.getReference("PostInfo")
        ref.child(title).setValue(content)

        //라디오버튼 분야 별로 경로 저장
        when(category){
            "근로"-> fbdb.getReference("PostInfo/근로")
            "교통" -> fbdb.getReference("PostInfo/교통")
            "부동산"-> fbdb.getReference("PostInfo/부동산")
        }

        val postInfo = PostInfo(
            title ,
            content
        )

        ref.child(uid.toString()).push().setValue(postInfo)

        val intent = Intent(this, CommunityActivity::class.java)
        startActivity(intent)
        Toast.makeText(this, "게시물 작성 완료", Toast.LENGTH_SHORT)
            .show()
    }

    }


/*
    private fun addPost(writeTitle: String, writeContent: String) {
        setPost(writeTitle,writeContent)

    }
*/
  /*  private fun setPost(writeTitle: String, writeContent: String) {
        val fbdb=FirebaseDatabase.getInstance()
        val ref = fbdb.getReference()

        //라디오버튼 분야 별로 경로 저장
        when(category){
            "근로"-> fbdb.getReference("/커뮤니티/근로")
            "교통" -> fbdb.getReference("/커뮤니티/교통")
            "부동산"-> fbdb.getReference("/커뮤니티/부동산")
        }

       data class Post(
           var uid: String? = "",
           var writeTitle: String? = "",
           var writeContent: String? = "",
       ){
       @Exclude
       fun toMap(): Map<String, Any?>{
           return mapOf(
               "uid" to uid,
                "writeTitle" to writeTitle,
                "writeContent" to writeContent
           )
           }
        val post = Post(writeTitle,writeContent)
        val postValues = post.toMap()

       val childUpdates = Map<String,Any>(

       )
        ref.updateChildren(childUpdates)
       }*/



