package com.deams.ynovmydiet

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.deams.ynovmydiet.database.AppDb
import com.google.android.material.navigation.NavigationView
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.content_profil.*





class ProfilActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var sampleImages = intArrayOf(
        R.drawable.button_plus_background,
        R.drawable.anniv_icon,
        R.drawable.button_su_background
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        //val carouselView = findViewById(R.id.carouselView) as CarouselView;
        //carouselView.setPageCount(sampleImages.size);
        //carouselView.setImageListener(imageListener);


        val database = AppDb.getInstance(this@ProfilActivity)
        System.out.println(getIntent().getStringExtra("id"))
        val users = database.userDao().getAllUsers()
        val user = database.userDao().findUserById(0)
        tv_nom.text = user.pseudo
        tv_prenom.text = user.first_name
        //tv_age.text = user.birthday
        //tv_ville.text = user.city
        //tv_mail.text = user.mail
        for (m in users){
            Log.i("Nom", m.last_name)
            Log.i("Prenom", m.first_name)
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

        // Set a click listener for first button widget
        button1.setOnClickListener {
            // Get the text fragment instance
            val textFragment = TextFragment()

            // Get the support fragment manager instance
            val manager = supportFragmentManager

            // Begin the fragment transition using support fragment manager
            val transaction = manager.beginTransaction()

            // Replace the fragment on container
            transaction.replace(R.id.fragment_container,textFragment)
            transaction.addToBackStack(null)

            // Finishing the transition
            transaction.commit()
        }


        // Set a click listener for second button widget
        button2.setOnClickListener {
            // Get the text fragment instance
            val imageFragment = ImageFragment()

            // Get the support fragment manager instance
            val manager = supportFragmentManager

            // Begin the fragment transition using support fragment manager
            val transaction = manager.beginTransaction()

            // Replace the fragment on container
            transaction.replace(R.id.fragment_container,imageFragment)
            transaction.addToBackStack(null)

            // Finishing the transition
            transaction.commit()
        }
    }

    var imageListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView) {
            // You can use Glide or Picasso here
            imageView.setImageResource(sampleImages[position])
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_accueil -> {
                // Handle the camera action
                val intent1 = Intent(this@ProfilActivity, HomeActivity::class.java)
                startActivity(intent1)
            }
            R.id.nav_menu_type -> {
                val intent2 = Intent(this@ProfilActivity, MenuTypeActivity::class.java)
                startActivity(intent2)
            }
            R.id.nav_mon_suivi -> {
                val intent4 = Intent(this@ProfilActivity, StatsActivity::class.java)
                startActivity(intent4)
            }
            R.id.nav_mon_profil -> {
                val intent2 = Intent(this@ProfilActivity, ProfilActivity::class.java)
                startActivity(intent2)
            }
            R.id.nav_mes_journees -> {
                val intent2 = Intent(this@ProfilActivity, MenuJourneeActivity::class.java)
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
