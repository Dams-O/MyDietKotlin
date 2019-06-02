package com.deams.ynovmydiet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_inscription.*
import kotlinx.android.synthetic.main.nav_header_main.view.*


class InscriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inscription)
    }

    fun creaCompte(){
        Pseudo.editText;
    }
}
