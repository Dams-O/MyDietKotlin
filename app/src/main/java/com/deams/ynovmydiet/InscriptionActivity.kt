package com.deams.ynovmydiet

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_inscription.*
import kotlinx.android.synthetic.main.content_inscription.*
import kotlinx.android.synthetic.main.nav_header_main.view.*


class InscriptionActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inscription)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    /* fun creaCompte(){
        Pseudo.editText;
    } */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_accueil -> {
                // Handle the camera action
                val intent1 = Intent(this@InscriptionActivity, HomeActivity::class.java)
                startActivity(intent1)
            }
            R.id.nav_menu_type -> {
                // Handle the camera action
                val intent1 = Intent(this@InscriptionActivity, MenuTypeActivity::class.java)
                startActivity(intent1)
            }
            R.id.nav_mon_profil -> {
                val intent2 = Intent(this@InscriptionActivity, ProfilActivity::class.java)
                startActivity(intent2)
            }
            R.id.nav_mes_journees -> {
                val intent2 = Intent(this@InscriptionActivity, MaJourneeActivity::class.java)
                startActivity(intent2)
            }
            R.id.nav_mon_suivi -> {
                val intent4 = Intent(this@InscriptionActivity, StatsActivity::class.java)
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
