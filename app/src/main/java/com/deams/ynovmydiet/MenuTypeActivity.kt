package com.deams.ynovmydiet

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.google.android.material.navigation.NavigationView


class MenuTypeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_type)
        //textView8.text=""
        val menuType = MenuType()
        menuType.userId = 1

        var arrBreakfast = arrayOf(1, 5 ,4 ,8, 7, 2)
        menuType.breakfast = arrBreakfast.toString()

        var arrLunch = arrayOf(2, 4 ,1 , 6, 1, 5)
        menuType.lunch = arrLunch.toString()

        var arrDinner = arrayOf(4, 1 ,2 , 7, 2, 3)
        menuType.dinner = arrDinner.toString()

        var arrComplement = arrayOf(3, 7 , 4, 7, 6, 1)
        menuType.complement = arrComplement.toString()

        menuType.hasComplement = true

        val database = AppDb.getInstance(this@MenuTypeActivity)
        database.menuTypeDao().insertMenuType(menuType)
        var menus = database.menuTypeDao().getAllMenuType()
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
                val intent1 = Intent(this@MenuTypeActivity, MainActivity::class.java)
                startActivity(intent1)
            }
            R.id.nav_menu_type -> {
                val intent2 = Intent(this@MenuTypeActivity, MenuTypeActivity::class.java)
                startActivity(intent2)
            }
            R.id.nav_mon_suivi -> {
                val intent4 = Intent(this@MenuTypeActivity, StatsActivity::class.java)
                startActivity(intent4)
            }
            R.id.nav_mon_profil -> {
                val intent2 = Intent(this@MenuTypeActivity, ProfilActivity::class.java)
                startActivity(intent2)
            }
            R.id.nav_mes_journees -> {
                val intent2 = Intent(this@MenuTypeActivity, MaJourneeActivity::class.java)
                startActivity(intent2)
            }
            R.id.nav_message -> {

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
