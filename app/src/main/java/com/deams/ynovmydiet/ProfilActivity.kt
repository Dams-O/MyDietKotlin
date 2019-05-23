package com.deams.ynovmydiet

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_profil.*

class ProfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        val database = AppDb.getInstance(this@ProfilActivity)
        val users = database.userDao().getAllUsers()

        for (m in users){
            Log.i("Nom", m.name)
            textView7.text = m.lastname
            Log.i("Prenom", m.lastname)
        }

    }

}
