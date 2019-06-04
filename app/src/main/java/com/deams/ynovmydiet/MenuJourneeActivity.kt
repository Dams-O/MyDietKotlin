package com.deams.ynovmydiet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu_journee.*

class MenuJourneeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_journee)

        btn_ptidej.setOnClickListener {
            val intent1 = Intent(this@MenuJourneeActivity, MaJourneeActivity::class.java)
            startActivity(intent1)
        }
    }
}
