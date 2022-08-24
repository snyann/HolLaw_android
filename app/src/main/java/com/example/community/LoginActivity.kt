package com.example.community

import android.app.Activity
import android.os.Bundle
import com.example.community.R
import android.widget.ImageButton
import android.content.Intent
import android.view.View
import com.example.community.community_writing
import com.example.community.community_content_list
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import com.example.community.LoginActivity
import com.example.community.ResultActivity
import com.example.community.CommunityActivity
import com.example.community.JoinActivity
import com.example.community.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private var binding: ActivityLoginBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        binding!!.btnLogin.setOnClickListener(this)
        binding!!.btnRegister.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_register -> {
                val intent = Intent(applicationContext, JoinActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_login -> {
                val et_id = binding!!.editTextId.toString()
                val et_password = binding!!.editTextPassword.toString()
                login(et_id, et_password, this)
            }
        }
    }

    private fun login(et_id: String, et_password: String, loginActivity: LoginActivity) {
        //firebase연결
    }
}