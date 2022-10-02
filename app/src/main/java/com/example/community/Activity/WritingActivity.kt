package com.example.community.Activity


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.RV.PostInfo
import com.example.community.databinding.ActivityWritingBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase



class WritingActivity : AppCompatActivity() {
    private lateinit var fbAuth: FirebaseAuth
    private var uid:String=""
    lateinit var binding: ActivityWritingBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWritingBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // firebaseAuth = FirebaseAuth.getInstance() //로그인 정보 가져와야함
        if(intent.hasExtra("uid")){
            uid = intent.getStringExtra("uid").toString()
        }

        //라디오버튼 선택 어케 넘기는지 확인해보기
        //val image:Boolean = binding.imAddimage.    이미지 첨부 확인
        binding.btnComplete.setOnClickListener{

            val fbdb=FirebaseDatabase.getInstance()
            val ref = fbdb.getReference()

            val postInfo = PostInfo (
                binding.writeTitle.text.toString(),
                binding.writeContent.text.toString(),
                binding.rbRealestate.isChecked
            )

            ref.child(uid).push().setValue(postInfo)

            val intent = Intent(this, CommunityActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "게시물 작성 완료", Toast.LENGTH_SHORT)
                .show()
            }


    }
}
