package com.deams.ynovmydiet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.deams.ynovmydiet.database.AppDb
import com.deams.ynovmydiet.database.entities.Meal
import com.google.android.material.navigation.NavigationView
import androidx.constraintlayout.widget.ConstraintLayout
import com.deams.ynovmydiet.database.entities.User
import com.deams.ynovmydiet.database.services.UserService
import com.squareup.moshi.Json
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import com.google.gson.JsonObject
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import retrofit2.converter.gson.GsonConverterFactory


class MaJourneeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_type)
/*
        val retrofit = Retrofit.Builder()
        .baseUrl("http://backapi-mydietapp.43ki6n3qg7.eu-west-1.elasticbeanstalk.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        val service = retrofit.create(UserService::class.java)

        // On lance le service loginUser avec l'identifiant 'mail' et le password
        val courseRequest = service.createDataUser(jsonObject)
        courseRequest.enqueue(object : Callback<Void> {

        override fun onResponse(call: Call<Void>, response: Response<Void>) {
        println("YES")
        }

        override fun onFailure(call: Call<Void>, t: Throwable) {
        println("PAS YES")
        }

        })
*/




    }
}
