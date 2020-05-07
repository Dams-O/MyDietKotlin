package com.deams.ynovmydiet

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class HomeActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_type)
        
        val btn_ajout_repas: ImageButton = findViewById(R.id.btn_plus)
        btn_ajout_repas.setOnClickListener {
            val intent1 = Intent(this, MaJournee2Activity::class.java)
            startActivity(intent1)
        }
        val btn_menu_type: ImageButton = findViewById(R.id.btn_menu_type)
        btn_menu_type.setOnClickListener {
            val intent1 = Intent(this, MenuTypeActivity::class.java)
            startActivity(intent1)
        }
        val btn_accueil: ImageButton = findViewById(R.id.btn_accueil)
        btn_accueil.setOnClickListener {
            val intent1 = Intent(this, StatActivity::class.java)
            startActivity(intent1)
        }


        // La gestion du calendrier
        val mPickTimeBtn: ImageButton = findViewById(R.id.calendar)
        val nextdate: ImageButton = findViewById(R.id.nextdate)
        val precdate: ImageButton = findViewById(R.id.precdate)
        val textView : TextView = findViewById(R.id.date)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        println(Calendar.DAY_OF_MONTH)
        val plusday = Calendar.DAY_OF_MONTH + 1
        val moinday = Calendar.DAY_OF_MONTH - 1
        val MONTH = arrayOf(
            "Jan",
            "Feb",
            "Mar",
            "Avr",
            "Mai",
            "Jun",
            "Jul",
            "Aou",
            "Sep",
            "Oct",
            "Nov",
            "Dec"
        )
        textView.setText("" + day + " " + MONTH[month])
        mPickTimeBtn.setOnClickListener {
            println(month)
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener {
                    view,
                    year,
                    monthOfYear,
                    dayOfMonth ->
                // Display Selected date in TextView
                textView.setText("" + dayOfMonth + " " + MONTH[monthOfYear])

            }, year, month, day)
            dpd.show()


        }

        nextdate.setOnClickListener {
            textView.setText("" + 1 + " " + MONTH[month])
        }
        precdate.setOnClickListener {
            textView.setText("" + 2 + " " + MONTH[month])
        }




        // Récupération donnée de session envoyé depuis ConnexionActivity
        /* val prf = getSharedPreferences("user_details", Context.MODE_PRIVATE)
        val result: TextView = findViewById(R.id.monobjectif)
        result.setText(prf.getString("pseudo", null)) */

    }

}
