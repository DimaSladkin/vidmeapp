package com.sladkin.vidmeapp.extensions

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * Created by dima on 09.11.2017.
 */

val USER_KEY = "userKey"


fun Context.getUser() = PreferenceManager.getDefaultSharedPreferences(this).getString(USER_KEY, "")

fun Context.setUser(user: String) {
    PreferenceManager.getDefaultSharedPreferences(this).edit().putString(USER_KEY, user).apply()
}