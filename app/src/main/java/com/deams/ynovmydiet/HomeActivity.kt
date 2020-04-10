package com.deams.ynovmydiet

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import java.security.AccessController.getContext


class HomeActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_type)
        
        val btn_ajout_repas: ImageButton = findViewById(R.id.btn_plus)
        btn_ajout_repas.setOnClickListener {
            val intent1 = Intent(this, MaJournee2Activity::class.java)
            startActivity(intent1)
        }
        val btn_menu_type: ImageButton = findViewById(R.id.btn_menu_type)
        btn_menu_type.setOnClickListener {
            val intent1 = Intent(this, MenuTypeActivity::class.java)
            startActivity(intent1)
        }
        val btn_accueil: ImageButton = findViewById(R.id.btn_accueil)
        btn_accueil.setOnClickListener {
            val intent1 = Intent(this, HomeActivity::class.java)
            startActivity(intent1)
        }

        // Récupération donnée de session envoyé depuis ConnexionActivity
        /* val prf = getSharedPreferences("user_details", Context.MODE_PRIVATE)
        val result: TextView = findViewById(R.id.monobjectif)
        result.setText(prf.getString("pseudo", null)) */

    }

}
