package com.example.community.Activity

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.MySharedPreferences
import com.example.community.R
import com.example.community.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityLoginBinding // ActivityLogin 바인딩
    private lateinit var fbAuth: FirebaseAuth// FirebaseAuth 인스턴스 초기화


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        fbAuth = FirebaseAuth.getInstance() // FirebaseAuth 인스턴스 초기화

        //버튼 클릭 이벤트
        binding.btnLogin.setOnClickListener(this)
        binding.btnRegister.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_register -> {
                val intent = Intent(applicationContext, JoinActivity::class.java)
                startActivity(intent)
                finish()
            }

            R.id.btn_login -> {
                val email = binding.loginEditTextTextEmailAddress.toString().trim()
                val pwd1 = binding.loginEditTextPassword.toString().trim()

                login(email, pwd1, this)
            }
        }
    }

    private fun login(email: String, pwd1: String,myContext:Context) {
        //firebase연결
        fbAuth.signInWithEmailAndPassword(email, pwd1).addOnCompleteListener{
                task ->
                if(task.isSuccessful){
                    Log.d(ContentValues.TAG, "signInWithEmail:success")

                   // MySharedPreferences.setEmail(myContext, email, pwd1)
                   // if(myContext == this@LoginActivity) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(this, "로그인성공!", Toast.LENGTH_SHORT)
                            .show()
                  //  }
                    }

                else { // 로그인 오류 시
                    Log.d(ContentValues.TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(this@LoginActivity, "로그인 정보 오류.\n다시 시도해주세요", Toast.LENGTH_SHORT)
                        .show()
                }

                }


            }

    }