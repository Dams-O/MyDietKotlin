package com.deams.ynovmydiet

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Path
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.deams.ynovmydiet.database.entities.Food
import com.deams.ynovmydiet.database.services.UserService
import kotlinx.android.synthetic.main.adapter_majournee3.view.*
import kotlinx.android.synthetic.main.layout_majournee3.*
import kotlinx.coroutines.NonCancellable.start
import lecho.lib.hellocharts.animation.ChartDataAnimator.DEFAULT_ANIMATION_DURATION
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

        search.setOnFocusChangeListener { v, hasFocus ->
            val animationLeft = AnimationUtils.loadAnimation(this, R.anim.search_transition_left)
            animationLeft.setFillAfter(true)
            loupe.startAnimation(animationLeft)
        }

        search.setOnItemClickListener { parent, view, position, id ->

            val item = parent.getItemAtPosition(position).toString()
            if(item !in id_food) {

                val newView =
                    this.layoutInflater.inflate(R.layout.adapter_majournee3, null) as LinearLayout

                val mainView =
                    findViewById<View>(R.id.linear_food) as LinearLayout

                var chiffre = 1
                newView.NombreR.text = chiffre.toString()
                newView.food.text = item

                linear_food.setPadding(100, 0, 0, 0)
                mainView.addView(newView)

                newView.flecheG.setOnClickListener {
                    chiffre -= 1
                    newView.NombreR.text = chiffre.toString()
                    if (chiffre == 0) {
                        newView.removeAllViews()
                        id_food -= item
                    }
                }

                newView.flecheD.setOnClickListener {
                    chiffre += 1
                    newView.NombreR.text = chiffre.toString()
                }

                id_food += item
                println(id_food)
            }
        }


        val date = "12/12/12"
        val idmealcategory = "2"

        btn_valider.setOnClickListener {
            val id_food_array = arrayOf(1,2,4,3,5)

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

