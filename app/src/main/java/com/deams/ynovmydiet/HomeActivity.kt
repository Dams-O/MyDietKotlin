package com.deams.ynovmydiet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import android.widget.ImageButton


class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_type)

        val btn_ajout_repas: ImageButton = findViewById(R.id.btn_plus)
        btn_ajout_repas.setOnClickListener {
            val intent1 = Intent(this@HomeActivity, MaJournee2Activity::class.java)
            startActivity(intent1)
        }
        val btn_menu_type: ImageButton = findViewById(R.id.btn_menu_type)
        btn_menu_type.setOnClickListener {
            val intent1 = Intent(this@HomeActivity, MenuTypeActivity::class.java)
            startActivity(intent1)
        }
        val btn_accueil: ImageButton = findViewById(R.id.btn_accueil)
        btn_accueil.setOnClickListener {
            val intent1 = Intent(this@HomeActivity, HomeActivity::class.java)
            startActivity(intent1)
        }

/**
        val id_user = intent.getStringExtra("id_user")
        val pseudo = intent.getStringExtra("pseudo")
        println(id_user)
        tv_nom.text = pseudo

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this) **/
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id_user = intent.getStringExtra("id_user")
        when (item.itemId) {
            R.id.nav_accueil -> {
                // Handle the camera action
                val intent1 = Intent(this@HomeActivity, HomeActivity::class.java)
                startActivity(intent1)
            }
            R.id.nav_menu_type -> {
                // Handle the camera action
                val intent1 = Intent(this@HomeActivity, MenuTypeActivity::class.java)
                startActivity(intent1)
            }
            R.id.nav_mon_profil -> {
                val intent2 = Intent(this@HomeActivity, ProfilActivity::class.java)
                startActivity(intent2)
            }
            R.id.nav_mes_journees -> {
                val intent3 = Intent(this@HomeActivity, MenuJourneeActivity::class.java)
                intent3.putExtra("id_user", id_user)
                startActivity(intent3)
            }
            R.id.nav_mon_suivi -> {
                val intent4 = Intent(this@HomeActivity, UserActivity::class.java)
                startActivity(intent4)
            }
            R.id.nav_message -> {

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
