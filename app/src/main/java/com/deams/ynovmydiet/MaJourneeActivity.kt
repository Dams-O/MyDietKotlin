package com.deams.ynovmydiet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ma_journee.*

class MaJourneeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ma_journee)

        val database = AppDb.getInstance(this@MaJourneeActivity)

        val text1 = edt1.text.toString();
        val text2 = edt2.text.toString();

        btn_click_me.setOnClickListener {
            // make a toast on button click event
            val repas = Meal()
            repas.mealId = 0
            repas.userId = 1

            repas.type = "Default";
            repas.food = edt1.text.toString() + " " + edt2.text.toString()
            database.mealDao().insertMeal(repas)
            Toast.makeText(this, edt1.text.toString(), Toast.LENGTH_LONG).show()
        }

        btn2.setOnClickListener {
            // make a toast on button click event
            var meal = database.mealDao().findMealById(0)
            Toast.makeText(this, meal.food, Toast.LENGTH_LONG).show()
        }
    }
}
