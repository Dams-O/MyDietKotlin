package com.deams.ynovmydiet

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room


class ProfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDb::class.java,
            "mydietDb0"
        ).fallbackToDestructiveMigration().build()

        val user = User()
        user.username = "test"
        user.name = "titi"
        user.lastname = "toto"
        db.userDao().insertUser(user)
        var users  = db.userDao().getAllUsers()

        for (m in users){
            Log.i("Nom", m.name)
            Log.i("Prenom", m.lastname)
        }

    }

}
