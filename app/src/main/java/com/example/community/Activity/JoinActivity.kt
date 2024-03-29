package com.example.community.Activity

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.RV.UserInfo
import com.example.community.R
import com.example.community.RV.UserAccount
import com.example.community.databinding.ActivityJoinBinding
import com.example.community.databinding.ActivityWritingBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class JoinActivity : AppCompatActivity() {
    lateinit var binding: ActivityJoinBinding
    private lateinit var fbAuth: FirebaseAuth

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fbAuth = FirebaseAuth.getInstance()

        binding.joinRegister.setOnClickListener {
            val email = binding.editTextTextEmailAddress.text.toString().trim()
            val pwd1 = binding.editTextTextPassword.text.toString().trim()
            val pwd2 = binding.editTextTextPassword2.text.toString().trim()
            var isGoToJoin = true

            if (email.isEmpty()) {
                Toast.makeText(this, "이메일 입력해주세요.", Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }
            if (pwd1.isEmpty()) {
                Toast.makeText(this, "비밀번호 입력해주세요.", Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }
            if (pwd2.isEmpty()) {
                Toast.makeText(this, "비밀번호 확인 해주세요", Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }

            if (pwd1 == pwd2) {
                fbAuth.createUserWithEmailAndPassword(email, pwd1)
                    .addOnCompleteListener(this@JoinActivity) { task ->
                       if(task.isSuccessful){
                           val user:FirebaseUser?=fbAuth.currentUser
                           val email: String?= user?.email
                           val uid: String? = user?.uid


                           val userinfo= UserInfo(
                               uid,
                               email,
                               pwd1
                           )

                           val  db : FirebaseDatabase = FirebaseDatabase.getInstance()
                           val ref : DatabaseReference =db.getReference("UserInfo")
                           ref.child(uid.toString()).push().setValue(userinfo)
                       }
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(this, "화원가입 성공", Toast.LENGTH_LONG).show()
                    }

            }else{ // 비밀번호란과 비밀번호 확인란이 일치하지 않을 때
                Toast.makeText(this, "회원가입 실패", Toast.LENGTH_LONG).show()
            }

        }
    }
}

