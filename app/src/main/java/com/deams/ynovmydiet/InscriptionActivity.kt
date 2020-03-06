package com.deams.ynovmydiet

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.deams.ynovmydiet.database.entities.User
import com.deams.ynovmydiet.database.services.UserService
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_inscription.*
import kotlinx.android.synthetic.main.content_connexion.*
import kotlinx.android.synthetic.main.content_inscription.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import okhttp3.ResponseBody
import retrofit2.*
import retrofit2.Call
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.Call as Retrofit2Call


class InscriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inscription)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)



        btn_inscription.setOnClickListener {

            // On récupère les données du body dans les variables
            val mail = edt_mail_inscription.text.toString()
            val password = edt_password_inscription.text.toString()
            val confirm_password = edt_password_confirm_inscription.text.toString()
            val pseudo = edt_pseudo_inscription.text.toString()
            val last_name = edt_last_name_inscription.text.toString()
            val first_name = edt_first_name_inscription.text.toString()


            // On initialise la connexion à la base de donnée grâçe à retrofit
            val retrofit = Retrofit.Builder()
                .baseUrl("http://backapi-mydietapp.43ki6n3qg7.eu-west-1.elasticbeanstalk.com/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

            val service = retrofit.create(UserService::class.java)

            println(password)
            println(confirm_password)
            // Si les mots de passe correspondent
            if (password == confirm_password) {
                // On lance le service createUser avec les informations de l'utilisateur
                val courseRequest = service.createUser(last_name, first_name, pseudo, mail, password)
                courseRequest.enqueue(object : Callback<ResponseBody> {
                    // En cas de réussite
                    override fun onResponse(
                        call: Call<ResponseBody>,
                        response: Response<ResponseBody>
                    ) {
                        println("user created")
                        Toast.makeText(
                            this@InscriptionActivity,
                            "Vous êtes inscrit !",
                            Toast.LENGTH_LONG
                        ).show()
                        val valid_inscription = Intent(this@InscriptionActivity, HomeActivity::class.java)
                        startActivity(valid_inscription)
                    }

                    // Si il y a une erreur
                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        println("user not created")
                        Toast.makeText(
                            this@InscriptionActivity,
                            "Erreur lors de l'inscription",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })
            }else{
                Toast.makeText(
                    this@InscriptionActivity,
                    "Les mots de passe ne correspondent pas.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
