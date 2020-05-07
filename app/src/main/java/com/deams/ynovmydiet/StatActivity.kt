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


class StatActivity: AppCompatActivity() {

    private val url = "http://backapi-mydietapp.43ki6n3qg7.eu-west-1.elasticbeanstalk.com/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test)

        // Création d'un graphique
        val pieChartView = findViewById(R.id.chart) as PieChartView
        val pieData = arrayListOf<SliceValue>()
        pieData.add(SliceValue(25f, Color.parseColor("#E13131")).setLabel("Viande"))
        pieData.add(SliceValue(25f, Color.parseColor("#EF7A3D")).setLabel("Blé"))
        pieData.add(SliceValue(25f, Color.parseColor("#FAB749")).setLabel("Chocolat"))
        pieData.add(SliceValue(12f,Color.parseColor("#629B33")).setLabel("Cuillère"))
        pieData.add(SliceValue(40f,Color.parseColor("#629B33")).setLabel("Cuillère"))
        pieData.add(SliceValue(10f,Color.parseColor("#629B33")).setLabel("Cuillère"))

        val pieChartData = PieChartData(pieData)
        pieChartData.setHasCenterCircle(true).setCenterText1("70%").setCenterText1FontSize(30).setCenterText1Color(Color.parseColor("#000000"));
        pieChartData.setHasLabels(false).valueLabelTextSize = 7
        pieChartView.pieChartData = pieChartData

    }

}