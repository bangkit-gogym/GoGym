package com.bangkit.gogym.helper

import android.content.Context
import com.bangkit.gogym.data.response.LoginResult

class SessionPref(context: Context) {
    companion object {
        const val PREFS_NAME = "login_pref"
        const val NAME = "name"
        const val IS_LOGIN = "islogin"
        const val TOKEN = "token"
        const val USER_ID = "userId"
        val TAG = "SESSIONPREF"
    }

    private val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)


    fun loginUser(data: LoginResult) {
        val editor = preferences.edit()
        editor.putString(TOKEN, data.token)
        editor.putString(USER_ID, data.id)
        editor.putString(NAME, data.name)
        editor.putBoolean(IS_LOGIN, true)
        editor.apply()
    }

    fun getUserData(key: String): String? {
        return preferences.getString(key, null)
    }


}