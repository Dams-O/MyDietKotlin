package com.deams.ynovmydiet

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.CountDownTimer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_chargement)
                val timer = object : CountDownTimer(2000, 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                    }

                    override fun onFinish() {
                        val prf = getSharedPreferences("user_details", Context.MODE_PRIVATE)
                        val session = prf.getString("reste_connecte", "false")
                        if(session == "true"){
                            val intent = Intent(this@MainActivity, HomeActivity::class.java)
                            startActivity(intent)
                        }else{
                            val intent = Intent(this@MainActivity, ConnexionActivity::class.java)
                            startActivity(intent)
                        }

                    }
                }
                timer.start()
    }
}
