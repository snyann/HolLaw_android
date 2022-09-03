package com.example.community.Activity

import android.app.Activity
import android.os.Bundle
import com.example.RV.PostInfo
import com.example.community.databinding.ActivityWritingBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class WritingActivity : Activity() {
    private lateinit var firebaseAuth: FirebaseAuth
    lateinit var binding: ActivityWritingBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWritingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnComplete.setOnClickListener{
        val title: String = binding.writeTitle.text.toString()
        val content: String = binding.writeContent.text.toString()
        val category: Boolean = binding.rbRealestate.isChecked
        //라디오버튼 선택 어케 넘기는지 확인해보기
        //val image:Boolean = binding.imAddimage.    이미지 첨부 확인

        getPost(title, content, category)
        }
    }

    private fun getPost(
        title: String,
        content: String,
        category: Boolean) {

        val mDatabase = FirebaseDatabase.getInstance().reference

        val PostInfo = PostInfo(
            title,
            content,
            category
        )

        val db: FirebaseDatabase = FirebaseDatabase.getInstance()
        val reference: DatabaseReference = db.getReference("Post Content")
      //   mDatabase.child("UserAccount").child(Firebase.auth.currentUser!!.uid.toString()).child("info").setValue(userInfo)

        // 가입성공시 join액티비티 빠져나와 login액티비티로
        //val intent = Intent(this@SecJoinActivity, LoginActivity::class.java)
        //startActivity(intent)
        //finish()
        //Toast.makeText(this@WriteActivity, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT)
         //  .show()



    }
}
