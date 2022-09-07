package com.example.community.Activity

import android.app.Activity
import android.os.Bundle
import com.example.RV.PostInfo
import com.example.community.databinding.ActivityWritingBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserInfo
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class WritingActivity : Activity() {
    private lateinit var firebaseAuth: FirebaseAuth
    var fbFirestore : FirebaseFirestore? = null
    lateinit var binding: ActivityWritingBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWritingBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // firebaseAuth = FirebaseAuth.getInstance() //로그인 정보 가져와야함
        fbFirestore = FirebaseFirestore.getInstance() //게시판 정보 파이어스토어 저장

        //라디오버튼 선택 어케 넘기는지 확인해보기
        //val image:Boolean = binding.imAddimage.    이미지 첨부 확인
        binding.btnComplete.setOnClickListener{
            val postInfo = PostInfo(
                _title = null,
                _content = null,
                _category = true
            )
            postInfo.title = binding.writeTitle.text.toString()
            postInfo.content = binding.writeContent.text.toString()
            postInfo.category = binding.rbRealestate.isChecked

            fbFirestore?.collection(firebaseAuth!!.currentUser!!.uid)?.document()?.set(postInfo)



            }


    }
}
