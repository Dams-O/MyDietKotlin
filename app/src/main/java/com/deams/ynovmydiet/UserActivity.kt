package com.deams.ynovmydiet

import android.app.slice.Slice
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.deams.ynovmydiet.database.entities.User
import com.deams.ynovmydiet.database.services.UserService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.test.*
import lecho.lib.hellocharts.model.PieChartData
import lecho.lib.hellocharts.view.PieChartView
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import lecho.lib.hellocharts.model.SliceValue
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import java.util.ArrayList
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.TextView


class UserActivity: AppCompatActivity() {

    private val url = "http://backapi-mydietapp.43ki6n3qg7.eu-west-1.elasticbeanstalk.com/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test)

        // Création d'un graphique
        val pieChartView = findViewById(R.id.chart) as PieChartView
        val pieData = arrayListOf<SliceValue>()
        pieData.add(SliceValue(30f, Color.parseColor("#E13131")).setLabel("Viande"))
        pieData.add(SliceValue(5f, Color.parseColor("#EF7A3D")).setLabel("Viande"))
        pieData.add(SliceValue(5f, Color.parseColor("#FAB749")).setLabel("Viande"))
        pieData.add(SliceValue(5f, Color.parseColor("#629B33")).setLabel("Viande"))
        pieData.add(SliceValue(5f, Color.parseColor("#355B9F")).setLabel("Viande"))
        pieData.add(SliceValue(5f, Color.parseColor("#91398D")).setLabel("Viandessss"))

        val pieChartData = PieChartData(pieData)
        pieChartData.setHasLabels(true).valueLabelTextSize = 7
        pieChartView.pieChartData = pieChartData


        // Création d'un graphique
        val pieChartView2 = findViewById(R.id.chart2) as PieChartView
        val pieData2 = arrayListOf<SliceValue>()
        pieData2.add(SliceValue(30f, Color.parseColor("#E13131")).setLabel("Viande"))
        pieData2.add(SliceValue(5f, Color.parseColor("#EF7A3D")).setLabel("Viande"))
        pieData2.add(SliceValue(5f, Color.parseColor("#FAB749")).setLabel("Viande"))
        pieData2.add(SliceValue(5f, Color.parseColor("#629B33")).setLabel("Viande"))
        pieData2.add(SliceValue(5f, Color.parseColor("#355B9F")).setLabel("Viande"))
        pieData2.add(SliceValue(5f, Color.parseColor("#91398D")).setLabel("Viandessss"))

        val pieChartData2 = PieChartData(pieData)
        pieChartData2.setHasLabels(true).valueLabelTextSize = 7
        pieChartView2.pieChartData = pieChartData2

        val textView = findViewById(R.id.text) as TextView
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        val service = retrofit.create(UserService::class.java)
        val courseRequest = service.listUsers()
        courseRequest.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                val allUser = response.body()
                if (allUser != null) {
                    for (c in allUser)
                        textView.setText("${c.pseudo}")
                }else{
                    println("ça marche pas")
                }
            }
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                println("KO")
            }
        })

    }

}