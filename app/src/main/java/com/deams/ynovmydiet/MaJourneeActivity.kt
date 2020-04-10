package com.deams.ynovmydiet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.deams.ynovmydiet.database.AppDb
import com.deams.ynovmydiet.database.entities.Meal
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.content_ma_journee.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.deams.ynovmydiet.database.entities.User
import com.deams.ynovmydiet.database.services.UserService
import com.squareup.moshi.Json
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import com.google.gson.JsonObject
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import retrofit2.converter.gson.GsonConverterFactory


class MaJourneeActivity : AppCompatActivity() {
    var id_auto_count = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_type)
        /**
        val id_user = intent.getStringExtra("id_user")
        println(id_user)

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


        btn_saisie.setOnClickListener {
        println(auto1.text.toString())

        val jsonObject = JsonObject()
        jsonObject.addProperty("id", id_user)
        jsonObject.addProperty("Aliment1", auto1.text.toString())
        jsonObject.addProperty("Aliment2", "Pomme de terre")
        println(jsonObject)


        val retrofit = Retrofit.Builder()
        .baseUrl("http://backapi-mydietapp.43ki6n3qg7.eu-west-1.elasticbeanstalk.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        val service = retrofit.create(UserService::class.java)

        // On lance le service loginUser avec l'identifiant 'mail' et le password
        val courseRequest = service.createDataUser(jsonObject)
        courseRequest.enqueue(object : Callback<Void> {

        override fun onResponse(call: Call<Void>, response: Response<Void>) {
        println("YES")
        }

        override fun onFailure(call: Call<Void>, t: Throwable) {
        println("PAS YES")
        }


        })

        val intent1 = Intent(this@MaJourneeActivity, StatsActivity::class.java)
        intent1.putExtra("moment", "Diner")
        startActivity(intent1)
        }

        btn_add.setOnClickListener {
        System.out.println(auto1.getTag())
        linel.addView(createNewAutoTextView(adapterAuto))
        }

        btn_del.setOnClickListener {
        linel.removeView(linel.findViewById(id_auto_count))
        id_auto_count--
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
         **/
    }

    private fun createNewAutoTextView(adapter: ArrayAdapter<String>): TextView {
        id_auto_count++
        val lparams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        val autotextView = AutoCompleteTextView(this)
        autotextView.layoutParams = lparams
        autotextView.setAdapter(adapter)
        autotextView.setHint("Aliments")
        System.out.println(autotextView.getId())
        autotextView.setId(id_auto_count)
        return autotextView
    }
}
