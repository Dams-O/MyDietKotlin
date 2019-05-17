package com.deams.ynovmydiet

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room


class ProfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        val database = AppDb.getInstance(this@ProfilActivity)
        val users = database.userDao().getAllUsers()

        for (m in users){
            Log.i("Nom", m.name)
            Log.i("Prenom", m.lastname)
        }

    }

}
