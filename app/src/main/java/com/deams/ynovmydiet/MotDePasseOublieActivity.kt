package com.deams.ynovmydiet


import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MotDePasseOublieActivity: AppCompatActivity()  {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.layout_password_forget)

            val retour_croix: ImageButton = findViewById(R.id.retour_croix)
            retour_croix.setOnClickListener {
                val intent = Intent(this@MotDePasseOublieActivity, ConnexionActivity::class.java)
                startActivity(intent)
            }

        }
}