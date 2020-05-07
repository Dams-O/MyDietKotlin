package com.deams.ynovmydiet

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.deams.ynovmydiet.database.entities.User
import com.deams.ynovmydiet.database.services.UserService
import kotlinx.android.synthetic.main.layout_connexion.*
import kotlinx.android.synthetic.main.layout_majournee2.*
import kotlinx.android.synthetic.main.layout_majournee3.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class MaJournee3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_majournee3)

        val prf = getSharedPreferences("user_details", Context.MODE_PRIVATE)
        val id_user = prf.getLong("id_user", 0)

        // On récupère les données de MaJournee2Activity
        val journee: String = getIntent().getStringExtra("journee")
        println(journee)

        val template: ConstraintLayout = findViewById(R.id.template)

        // On choisit le background selon la catégorie choisit dans MaJournee2Activity
        if(journee == "petit_dejeuner"){
            template.setBackgroundResource(R.drawable.fondptitdejajouterrepas)
        }
        if(journee == "dejeuner"){
            template.setBackgroundResource(R.drawable.fonddejajouterrepas)
        }
        if(journee == "dinner"){
            template.setBackgroundResource(R.drawable.fonddinnerajouterrepas)
        }

        btn_valider.setOnClickListener {
            // On récupère les données du body dans les variables mail et password
            val id_user: Long = id_user
            val meal_category = journee
            val id_food = '5'
            val date = "12/12/2012"

            println(id_user)
            println(id_food)

            // On initialise la connexion à la base de donnée grâçe à retrofit
            val retrofit = Retrofit.Builder()
                .baseUrl("http://mydiet-env.eba-ngy5cnjb.eu-west-3.elasticbeanstalk.com/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
            val service = retrofit.create(UserService::class.java)

            // On lance le service loginUser avec l'identifiant 'mail' et le password
            val courseRequest = service.createDataUser(id_user, meal_category, id_food, date)
            courseRequest.enqueue(object : Callback<ResponseBody> {

                // Si on arrive à executer la requête
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    println("OK")
                    }

                // Si on arrive pas à faire la requête on affiche une erreur
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    println("KO")
                }
            })
    }



    }
}
