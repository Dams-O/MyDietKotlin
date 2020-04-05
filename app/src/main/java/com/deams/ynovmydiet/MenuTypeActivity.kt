package com.deams.ynovmydiet

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity


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
