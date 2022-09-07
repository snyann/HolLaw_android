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
import com.example.community.databinding.ActivityJoinBinding
import com.example.community.databinding.ActivityWritingBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class JoinActivity : AppCompatActivity() {
    lateinit var binding: ActivityJoinBinding
    private lateinit var fbAuth: FirebaseAuth

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinBinding.inflate(layoutInflater)
        setContentView(binding.root)


        fbAuth = FirebaseAuth.getInstance() //firebaseAuth 인스턴스 초기화

        binding.joinRegister.setOnClickListener {
            val email = binding.editTextTextEmailAddress.text.toString()
            val pwd1 = binding.editTextTextPassword.text.toString()
            val pwd2 = binding.editTextTextPassword2.text.toString()
            var isGoToJoin = true

            if (email.isEmpty()) {
                Toast.makeText(this, "이메일을 입력해주세요.", Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }
            if (pwd1.isEmpty()) {
                Toast.makeText(this, "password1을 입력해주세요.", Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }
            if (pwd2.isEmpty()) {
                Toast.makeText(this, "password1을 입력해주세요.", Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }

            if (pwd1 == pwd2) {
                fbAuth.createUserWithEmailAndPassword(email, pwd1)
                    .addOnCompleteListener(this@JoinActivity) { task ->
                        Toast.makeText(this, "화원가입 성공", Toast.LENGTH_LONG).show()
                    }
            }else{ // 비밀번호란과 비밀번호 확인란이 일치하지 않을 때
                Toast.makeText(this, "회원가입 실패", Toast.LENGTH_LONG).show()
            }
        }
    }
}

