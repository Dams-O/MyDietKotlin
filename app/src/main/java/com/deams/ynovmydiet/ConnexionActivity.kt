package com.deams.ynovmydiet

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.deams.ynovmydiet.database.AppDb
import kotlinx.android.synthetic.main.content_connexion.*


/**
 * A login screen that offers login via email/password.
 */
class ConnexionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connexion)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val database = AppDb.getInstance(this@ConnexionActivity)
        val userNow = database.userDao().findUserById(0)

        btn_connexion.setOnClickListener {
            if(identifiant.text.toString().equals(userNow.username.toString())){
                Toast.makeText(this, identifiant.text.toString() + " s'est connecté avec succès", Toast.LENGTH_LONG).show()
                val intent1 = Intent(this@ConnexionActivity, HomeActivity::class.java)
                intent1.putExtra("id", identifiant.text.toString())
                startActivity(intent1)
            }
        }

    }

}
