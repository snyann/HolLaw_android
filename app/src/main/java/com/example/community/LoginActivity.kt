package com.example.community

import android.content.ContentValues.TAG
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.MySharedPreferences
import com.example.community.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityLoginBinding // ActivityLogin 바인딩
    private var firebaseAuth = FirebaseAuth.getInstance() // FirebaseAuth 인스턴스 초기화


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

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
                val et_id = binding!!.editTextId.toString()
                val et_password = binding!!.editTextPassword.toString()
                login(et_id, et_password, this)
            }
        }
    }

    private fun login(et_id: String, et_pwd: String, myContext:Context) {
        //firebase연결
        firebaseAuth.signInWithEmailAndPassword(et_id, et_pwd)
            .addOnCompleteListener(
            this@LoginActivity
        ){ task ->
                if(task.isSuccessful){
                    Log.d(TAG, "signInWithEmail:success")

                    MySharedPreferences.setUserId(myContext,et_id, et_pwd)

                    if(myContext == this@LoginActivity) {
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(this@LoginActivity, "로그인성공!", Toast.LENGTH_SHORT)
                            .show()
                    }

                } else { // 로그인 오류 시
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(this@LoginActivity, "오류가 발생했습니다.\n다시 시도해주세요", Toast.LENGTH_SHORT)
                        .show()
                }

                }


            }

    }


