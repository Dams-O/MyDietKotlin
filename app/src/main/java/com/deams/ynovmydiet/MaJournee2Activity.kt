package com.deams.ynovmydiet

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MaJournee2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_majournee2)

        val btn_ajout_petit_dejeuner: ImageButton = findViewById(R.id.pluspetitdej)
        btn_ajout_petit_dejeuner.setOnClickListener {
            val intent = Intent(this, MaJournee3Activity::class.java)
            intent.putExtra("journee", "petit_dejeuner")
            startActivity(intent)
        }
        val btn_ajout_dejeuner: ImageButton = findViewById(R.id.plusdej)
        btn_ajout_dejeuner.setOnClickListener {
            val intent = Intent(this, MaJournee3Activity::class.java)
            intent.putExtra("journee", "dejeuner")
            startActivity(intent)
        }
        val btn_ajout_dinner: ImageButton = findViewById(R.id.plusdinner)
        btn_ajout_dinner.setOnClickListener {
            val intent = Intent(this, MaJournee3Activity::class.java)
            intent.putExtra("journee", "dinner")
            startActivity(intent)
        }


    }
}