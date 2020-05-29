package com.deams.ynovmydiet

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.deams.ynovmydiet.database.entities.Food
import com.deams.ynovmydiet.database.services.UserService
import kotlinx.android.synthetic.main.layout_majournee3.*
import kotlinx.android.synthetic.main.layout_text_fragment.*
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
        val iduser = prf.getLong("id_user", 0)

        // On récupère les données de MaJournee2Activity
        val journee: String = getIntent().getStringExtra("journee")
        println(journee)

        val template: ConstraintLayout = findViewById(R.id.template)

        // On choisit le background selon la catégorie choisit dans MaJournee2Activity
        if (journee == "petit_dejeuner") {
            template.setBackgroundResource(R.drawable.fondptitdejajouterrepas)
        }
        if (journee == "dejeuner") {
            template.setBackgroundResource(R.drawable.fonddejajouterrepas)
        }
        if (journee == "dinner") {
            template.setBackgroundResource(R.drawable.fonddinnerajouterrepas)
        }

        val foods: ArrayList<String?> = ArrayList()

        // On initialise la connexion à la base de donnée grâçe à retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("http://mydiet-env.eba-ngy5cnjb.eu-west-3.elasticbeanstalk.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        val service = retrofit.create(UserService::class.java)

        val courseRequest = service.listFoods()
        courseRequest.enqueue(object : Callback<List<Food>> {

            // Si on arrive à executer la requête
            override fun onResponse(call: Call<List<Food>>, response: Response<List<Food>>) {
                val infoFood = response.body()
                if (infoFood != null) {
                    for (item: Food in infoFood) {

                        foods.add(item.name)

                    }
                }
            }

            // Si on arrive pas à faire la requête on affiche une erreur
            override fun onFailure(call: Call<List<Food>>, t: Throwable) {
                println("KO")
            }
        })

        val adapterAuto = ArrayAdapter<String>(
            this,
            android.R.layout.simple_dropdown_item_1line,
            foods
        )
        search.setAdapter(adapterAuto)
        val id_food: ArrayList<String> = ArrayList()


        search.setOnItemClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position).toString()
            val dynamicTextview = TextView(this)

            dynamicTextview.text = item
            linear.addView(dynamicTextview)

            id_food += item
            println(id_food)
        }



        val date = "12/12/12"
        val idmealcategory = "2"

        btn_valider.setOnClickListener {
            val id_food_array = arrayOf(1,2,4,3,5)
            /*for (i in 0..id_food.size -1 ) {
                id_food_array[i] = id_food[i]
                println(id_food_array[0])
            }*/

            val retrofit = Retrofit.Builder()
                .baseUrl("http://mydiet-env.eba-ngy5cnjb.eu-west-3.elasticbeanstalk.com/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

            val service = retrofit.create(UserService::class.java)
            val courseRequest = service.createDataUser(iduser, idmealcategory, id_food_array, date)
            courseRequest.enqueue(object : Callback<ResponseBody> {
                // En cas de réussite
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    println("OK")
                    println(id_food_array)
                }

                // Si il y a une erreur
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    println("food not created")
                }
            })


        }
    }
}

