package com.deams.ynovmydiet

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.deams.ynovmydiet.database.AppDb
import com.deams.ynovmydiet.database.entities.MenuType
import com.google.android.material.navigation.NavigationView


class ModifierMenuTypeActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_modifier_menu_type)



        val btn_retour: ImageButton = findViewById(R.id.btn_retour)
        btn_retour.setOnClickListener {
            val intent = Intent(this@ModifierMenuTypeActivity, MenuTypeActivity::class.java)
            startActivity(intent)
        }
        var button_background : Int = 1
        val checkbox: ImageButton = findViewById(R.id.checkbox)
        checkbox.setOnClickListener {
            if(button_background==2){
                checkbox.setBackgroundResource(R.drawable.iconeon)
                button_background=1
            } else if(button_background==1){
                checkbox.setBackgroundResource(R.drawable.iconeoff)
                button_background=2
            }
        }
        var button_background2 : Int = 1
        val checkbox2: ImageButton = findViewById(R.id.checkbox2)
        checkbox2.setOnClickListener {
            if(button_background2==2){
                checkbox2.setBackgroundResource(R.drawable.iconeon)
                button_background2=1
            } else if(button_background2==1){
                checkbox2.setBackgroundResource(R.drawable.iconeoff)
                button_background2=2
            }
        }
        var button_background3 : Int = 1
        val checkbox3: ImageButton = findViewById(R.id.checkbox3)
        checkbox3.setOnClickListener {
            if(button_background3==2){
                checkbox3.setBackgroundResource(R.drawable.iconeon)
                button_background3=1
            } else if(button_background3==1){
                checkbox3.setBackgroundResource(R.drawable.iconeoff)
                button_background3=2
            }
        }
        var button_background4 : Int = 1
        val checkbox4: ImageButton = findViewById(R.id.checkbox4)
        checkbox4.setOnClickListener {
            if(button_background4==2){
                checkbox4.setBackgroundResource(R.drawable.iconeon)
                button_background4=1
            } else if(button_background4==1){
                checkbox4.setBackgroundResource(R.drawable.iconeoff)
                button_background4=2
            }
        }
        var button_background5 : Int = 1
        val checkbox5: ImageButton = findViewById(R.id.checkbox5)
        checkbox5.setOnClickListener {
            if(button_background5==2){
                checkbox5.setBackgroundResource(R.drawable.iconeon)
                button_background5=1
            } else if(button_background5==1){
                checkbox5.setBackgroundResource(R.drawable.iconeoff)
                button_background5=2
            }
        }
        var button_background6 : Int = 1
        val checkbox6: ImageButton = findViewById(R.id.checkbox6)
        checkbox6.setOnClickListener {
            if(button_background6==2){
                checkbox6.setBackgroundResource(R.drawable.iconeon)
                button_background6=1
            } else if(button_background6==1){
                checkbox6.setBackgroundResource(R.drawable.iconeoff)
                button_background6=2
            }
        }


    }

}
