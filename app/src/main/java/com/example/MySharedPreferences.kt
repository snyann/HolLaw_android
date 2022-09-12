package com.example

import android.content.Context
import android.content.SharedPreferences

object MySharedPreferences {
    private val MY_AUTHORIZATION: String = "authorization"
    fun setEmail(
        context: Context,
        email: String,
        pwd1: String)
    {
        val prefs: SharedPreferences =
            context.getSharedPreferences(MY_AUTHORIZATION, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = prefs.edit()
        editor.putString("email", email)
        editor.putString("pwd",pwd1)
        editor.apply()

    }


    fun getEmail(context: Context): String {
        val prefs: SharedPreferences =
            context.getSharedPreferences(MY_AUTHORIZATION, Context.MODE_PRIVATE)
        return prefs.getString("email", "").toString()
    }
    fun getPwd(context: Context): String {
        val prefs: SharedPreferences =
            context.getSharedPreferences(MY_AUTHORIZATION, Context.MODE_PRIVATE)
        return prefs.getString("pwd", "").toString()
    }

    fun clearUser(context: Context) {
        val prefs: SharedPreferences =
            context.getSharedPreferences(MY_AUTHORIZATION, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = prefs.edit()
        editor.clear()
        editor.apply()
    }

}