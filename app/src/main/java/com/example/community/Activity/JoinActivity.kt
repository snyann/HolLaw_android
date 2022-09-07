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

class JoinActivity : Activity() {
    lateinit var binding: ActivityJoinBinding
    private lateinit var firebaseAuth: FirebaseAuth

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance() //firebaseAuth 인스턴스 초기화

        binding.joinRegister.setOnClickListener {
            val email = binding.editTextTextEmailAddress.text.toString()
            val pwd1 = binding.editTextTextPassword.text.toString()
            val pwd2 = binding.editTextTextPassword2.text.toString()


            if (pwd1 == pwd2) {
                firebaseAuth.createUserWithEmailAndPassword(email, pwd1)
                    .addOnCompleteListener(this@JoinActivity) { task ->
                        if (task.isSuccessful) {
                            val user: FirebaseUser? = firebaseAuth.currentUser
                            val email: String? = user?.email
                            val uid: String? = user?.uid

                            val userInfo = UserInfo(
                                email,
                                pwd1,
                                uid
                            )

                            val db: FirebaseDatabase = FirebaseDatabase.getInstance() // FirebaseDatabase 인스턴스 초기화
                            val reference: DatabaseReference = db.getReference("UserAccount") // DatabaseReference를 매개체 삼아 읽기/쓰기
                            reference.child(uid.toString()).child("account")
                                .setValue(userInfo) // reference에서 하위 값의 uid를 account에 즉시 값 변경


                            val intent = Intent(this@JoinActivity, MainActivity::class.java)
                            startActivity(intent)
                            Toast.makeText(this, "회원가입 성공!", Toast.LENGTH_SHORT)
                                .show()
                        }
                        else {
                            if (task.exception is FirebaseAuthUserCollisionException) { // 가입 실패시
                                Toast.makeText(
                                    this@JoinActivity,
                                    "이메일이 중복됩니다.", Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
            }else{ // 비밀번호란과 비밀번호 확인란이 일치하지 않을 때
                    Toast.makeText(
                        this@JoinActivity,
                        "비밀번호가 일치하지 않습니다.\n다시 시도해주세요", Toast.LENGTH_SHORT
                    ).show()
            }
        }
    }
}

