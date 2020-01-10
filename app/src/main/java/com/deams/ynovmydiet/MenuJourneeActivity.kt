package com.deams.ynovmydiet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.content_menu_journee.*

class MenuJourneeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_journee)
        val id_user = intent.getStringExtra("id_user")
        println(id_user)
        btn_ptidej.setOnClickListener {
            val intent1 = Intent(this@MenuJourneeActivity, MaJourneeActivity::class.java)
            intent1.putExtra("id_user", id_user)
            startActivity(intent1)
        }

        btn_dej.setOnClickListener {
            val intent1 = Intent(this@MenuJourneeActivity, MaJourneeActivity::class.java)
            intent1.putExtra("moment", "Dejeune")
            startActivity(intent1)
        }

        btn_diner.setOnClickListener {
            val intent1 = Intent(this@MenuJourneeActivity, MaJourneeActivity::class.java)
            intent1.putExtra("moment", "Diner")
            startActivity(intent1)
        }

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
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
            // Handle navigation view item clicks here.
            when (item.itemId) {
                R.id.nav_accueil -> {
                    // Handle the camera action
                    val intent1 = Intent(this@MenuJourneeActivity, HomeActivity::class.java)
                    startActivity(intent1)
                }
                R.id.nav_menu_type -> {
                    // Handle the camera action
                    val intent1 = Intent(this@MenuJourneeActivity, MenuTypeActivity::class.java)
                    startActivity(intent1)
                }
                R.id.nav_mon_profil -> {
                    val intent2 = Intent(this@MenuJourneeActivity, ProfilActivity::class.java)
                    startActivity(intent2)
                }
                R.id.nav_mes_journees -> {
                    val intent2 = Intent(this@MenuJourneeActivity, MenuJourneeActivity::class.java)
                    startActivity(intent2)
                }
                R.id.nav_mon_suivi -> {
                    val intent4 = Intent(this@MenuJourneeActivity, StatsActivity::class.java)
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
