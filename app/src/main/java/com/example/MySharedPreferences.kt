package com.example

import android.content.Context
import android.content.SharedPreferences

object MySharedPreferences {
    private val MY_AUTHORIZATION: String = "authorization"
    fun setUserId(
        context: Context,
        etId: String,
        etPwd: String)
    {
        val prefs: SharedPreferences =
            context.getSharedPreferences(MY_AUTHORIZATION, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = prefs.edit()
        editor.putString("et_ID", etId)
        editor.putString("et_pwd",etPwd)
        editor.apply()

    }
}