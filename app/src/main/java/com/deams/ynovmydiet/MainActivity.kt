package com.deams.ynovmydiet

import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.content.Intent
import androidx.room.Room
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = AppDb.getInstance(this@MainActivity)
        //Insert TEST
        val user = User()
        user.userId = 0
        user.username = "Titi"
        user.name = "Thiery"
        user.lastname = "Henry"
        user.mail = "titi.henry@gmail.com"
        user.birthday = "17 Août 1977"
        user.city = "Barcelone"
        database.userDao().insertUser(user)

        ajoutAliments()

        button2.setOnClickListener {
            // Handler code here.
            val intent2 = Intent(this@MainActivity, ConnexionActivity::class.java)
            startActivity(intent2)
        }

        button3.setOnClickListener {
            // Handler code here.
            val intent2 = Intent(this@MainActivity, InscriptionActivity::class.java)
            startActivity(intent2)
        }

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)



    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun ajoutAliments(){
        val database = AppDb.getInstance(this@MainActivity)
        val food1 = Food()
        food1.name = "Agneau"
        food1.family = "P"
        val food2 = Food()
        food2.name = "Bœuf"
        food2.family = "P"
        val food3 = Food()
        food3.name = "Boeuf"
        food3.family = "P"
        val food4 = Food()
        food4.name = "Saucisse Porc"
        food4.family = "P"
        val food5 = Food()
        food5.name = "Poisson"
        food5.family = "P"
        val food6 = Food()
        food6.name = "Chèvre frais"
        food6.family = "Ca"
        val food7 = Food()
        food7.name = "Fromage Blanc0%"
        food7.family = "Ca"
        val food8 = Food()
        food8.name = "Fromage Blanc 20%"
        food8.family = "Ca"
        val food9 = Food()
        food9.name = "Lait de vache écrémé"
        food9.family = "Ca"
        val food10 = Food()
        food10.name = "Lait de vache entier"
        food10.family = "Ca"
        val food11 = Food()
        food11.name = "Yaourt"
        food11.family = "Ca"
        val food12 = Food()
        food12.name = "Céréales"
        food12.family = "GL"
        val food13 = Food()
        food13.name = "Pain"
        food13.family = "Gl"
        val food14 = Food()
        food14.name = "Riz"
        food14.family = "GL"
        val food15 = Food()
        food15.name = "Mais"
        food15.family = "GL"
        val food16 = Food()
        food16.name = "Carottes"
        food16.family = "SM"
        val food17 = Food()
        food17.name = "Pomme de terre"
        food17.family = "GL"
        val food18 = Food()
        food18.name = "Poivron"
        food18.family = "SM"
        val food19 = Food()
        food19.name = "Fruits secs"
        food19.family = "L"
        val food20 = Food()
        food20.name = "Cacahuète"
        food20.family = "L"
        val food21 = Food()
        food21.name = "Cacao en poudre"
        food21.family = "Su"
        val food22 = Food()
        food22.name = "Sucre"
        food22.family = "Su"
        val food23 = Food()
        food23.name = "Bière"
        food23.family = "Al"
        val food24 = Food()
        food24.name = "Vin"
        food24.family = "Al"
        val food25 = Food()
        food25.name = "Soda"
        food25.family = "Su"
        val foodArr = arrayOf(food1,food2,food3,food4,food5,food6,food7,food8,food9,food10,food11,food11,food13,food14,food15,food16,food17,food18,food19,food20,food21,food22,food23,food24,food25)
        for(food in foodArr){
            database.foodDao().insertFood(food)
        }
    }
}
