package com.deams.ynovmydiet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_ma_journee_content.*

class MaJourneeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ma_journee)

        val intent = getIntent()
        val moment = intent.getStringExtra("moment")
        System.out.println(moment)

        tv_moment.text = moment
        val database = AppDb.getInstance(this@MaJourneeActivity)

        val foodList = ArrayList<String?>()
        val testsarr = database.foodDao().getAllFoods()
        for (food in testsarr){
            foodList.add(food.name)
        }

        val adapterAuto = ArrayAdapter<String>(
            this,
            android.R.layout.simple_dropdown_item_1line,
            foodList
        )

        auto1.setAdapter(adapterAuto)
        auto2.setAdapter(adapterAuto)
        auto3.setAdapter(adapterAuto)

        btn_click_me.setOnClickListener {
            // make a toast on button click event
            val repas = Meal()
            repas.mealId = 0
            repas.userId = 1

            repas.type = "Default";
            repas.food = auto1.text.toString() + " " + auto2.text.toString()
            database.mealDao().insertMeal(repas)
            Toast.makeText(this, "Votre saisie à bien été enregistrée", Toast.LENGTH_LONG).show()

            val intent1 = Intent(this@MaJourneeActivity, StatsActivity::class.java)
            intent1.putExtra("moment", "Diner")
            startActivity(intent1)
        }

        /*btn2.setOnClickListener {
            // make a toast on button click event
            var meal = database.mealDao().findMealById(0)
            Toast.makeText(this, meal.food, Toast.LENGTH_LONG).show()
        }*/

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
                val intent1 = Intent(this@MaJourneeActivity, HomeActivity::class.java)
                startActivity(intent1)
            }
            R.id.nav_menu_type -> {
                // Handle the camera action
                val intent1 = Intent(this@MaJourneeActivity, MenuTypeActivity::class.java)
                startActivity(intent1)
            }
            R.id.nav_mon_profil -> {
                val intent2 = Intent(this@MaJourneeActivity, ProfilActivity::class.java)
                startActivity(intent2)
            }
            R.id.nav_mes_journees -> {
                val intent2 = Intent(this@MaJourneeActivity, MenuJourneeActivity::class.java)
                startActivity(intent2)
            }
            R.id.nav_mon_suivi -> {
                val intent4 = Intent(this@MaJourneeActivity, StatsActivity::class.java)
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
