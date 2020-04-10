package com.deams.ynovmydiet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deams.ynovmydiet.database.AppDb
import com.deams.ynovmydiet.database.entities.ResumeMeal
import com.google.android.material.navigation.NavigationView

class StatsActivity : AppCompatActivity() {
/*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)

        val database = AppDb.getInstance(this@StatsActivity)
        val arrFood = database.foodDao().getAllFoods()

        val repas1 = ResumeMeal()
        repas1.repasId = 0
        repas1.date = "Lundi 03 Juin"
        repas1.moment = "Diner"
        repas1.aliment = "Agneau, pomme de terre, Chèvre frais, Vin"
        repas1.score = "En accord à 90%"

        val repas2 = ResumeMeal()
        repas2.repasId = 0
        repas2.date = "Lundi 03 Juin"
        repas2.moment = "Déjeuner"
        repas2.aliment = "Boeuf, Pattes, Pomme"
        repas2.score = "En accord à 80%"

        val repas3 = ResumeMeal()
        repas3.repasId = 0
        repas3.date = "Lundi 03 Juin"
        repas3.moment = "Petit Déjeuner"
        repas3.aliment = "Cacao en poudre, Lait"
        repas3.score = "En accord à 50%"

        val repas4 = ResumeMeal()
        repas4.repasId = 0
        repas4.date = "Dimanche 02 Juin"
        repas4.moment = "Diner"
        repas4.aliment = "Steak haché, Frites"
        repas4.score = "En accord à 20%"

        val repas5 = ResumeMeal()
        repas5.repasId = 0
        repas5.date = "Dimanche 02 Juin"
        repas5.moment = "Déjeuner"
        repas5.aliment = "Jambon, Pattes, Emmental"
        repas5.score = "En accord à 70%"

        val repas6 = ResumeMeal()
        repas6.repasId = 0
        repas6.date = "Mercredi 05 Juin"
        repas6.moment = "Diner"
        repas6.aliment = "Carottes, Pomme de terre, Boeuf"
        repas6.score = "En accord à 80%"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

//        Create an arraylist
        val dataList = ArrayList<ResumeMeal>()
        dataList.add(repas6)
        dataList.add(repas1)
        dataList.add(repas2)
        dataList.add(repas3)
        dataList.add(repas4)
        dataList.add(repas5)
//        pass the values to RvAdapter
        val rvAdapter = RvAdapter(dataList)
//        set the recyclerView to the adapter
        recyclerView.adapter = rvAdapter;




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
                val intent1 = Intent(this@StatsActivity, HomeActivity::class.java)
                startActivity(intent1)
            }
            R.id.nav_menu_type -> {
                // Handle the camera action
                val intent1 = Intent(this@StatsActivity, MenuTypeActivity::class.java)
                startActivity(intent1)
            }
            R.id.nav_mon_profil -> {
                val intent2 = Intent(this@StatsActivity, ProfilActivity::class.java)
                startActivity(intent2)
            }
            R.id.nav_mes_journees -> {
                val intent2 = Intent(this@StatsActivity, MenuJourneeActivity::class.java)
                startActivity(intent2)
            }
            R.id.nav_mon_suivi -> {
                val intent4 = Intent(this@StatsActivity, StatsActivity::class.java)
                startActivity(intent4)
            }
            R.id.nav_message -> {

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
    */
}
