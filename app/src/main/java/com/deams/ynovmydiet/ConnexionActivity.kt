package com.deams.ynovmydiet

import android.Manifest.permission.READ_CONTACTS
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.TargetApi
import android.app.LoaderManager
import android.content.CursorLoader
import android.content.Intent
import android.content.Loader
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.text.TextUtils
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_connexion.*
import kotlinx.android.synthetic.main.content_connexion.*


/**
 * A login screen that offers login via email/password.
 */
class ConnexionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connexion)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val database = AppDb.getInstance(this@ConnexionActivity)
        val userNow = database.userDao().findUserById(0)

        btn_connexion.setOnClickListener {
            if(identifiant.text.toString().equals(userNow.username.toString())){
                Toast.makeText(this, identifiant.text.toString() + " s'est connecté avec succès", Toast.LENGTH_LONG).show()
                val intent1 = Intent(this@ConnexionActivity, HomeActivity::class.java)
                intent1.putExtra("id", identifiant.text.toString())
                startActivity(intent1)
            }
        }

    }

}
