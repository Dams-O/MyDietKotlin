package com.deams.ynovmydiet

import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.security.AccessController


class MenuTypeActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_menu_type)

        val btn_modifier: ImageButton = findViewById(R.id.btn_retour)
        btn_modifier.setOnClickListener {
            val intent = Intent(this@MenuTypeActivity, ModifierMenuTypeActivity::class.java)
            startActivity(intent)
        }

    }

}
