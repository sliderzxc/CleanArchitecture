package com.test.testcleanachitecture.data.storage.sharedprefs

import android.content.Context
import com.test.testcleanachitecture.data.storage.UserStorage
import com.test.testcleanachitecture.data.storage.models.User

private const val SHARED_PREFS_NAME = "SHARED_PREFS_NAME"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"

class SharedPrefUserStorage(context: Context) : UserStorage {
    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveName(user: User) : Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, user.lastName).apply()
        return true
    }

    override fun getName() : User {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "Vadim") ?: "Vadim"
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, "Hrynyk") ?: "Hrynyk"
        return User(firstName = firstName, lastName = lastName)
    }
}