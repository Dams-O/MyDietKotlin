package com.deams.ynovmydiet

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.deams.ynovmydiet.database.services.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import com.deams.ynovmydiet.database.entities.User
import android.widget.Button
import android.widget.ImageButton


/**
 * A login screen that offers login via email/password.
 */
class MaJournee2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_majournee2)



    }
}