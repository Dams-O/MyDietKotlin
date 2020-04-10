package com.deams.ynovmydiet

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.deams.ynovmydiet.database.services.UserService
import kotlinx.android.synthetic.main.layout_inscription.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class InscriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_inscription)

        val retour_croix: ImageButton = findViewById(R.id.retour_croix)
        retour_croix.setOnClickListener {
            val intent = Intent(this@InscriptionActivity, ConnexionActivity::class.java)
            startActivity(intent)
        }
        val btn_inscription: ImageButton = findViewById(R.id.btn_inscription_validation)
        btn_inscription.setOnClickListener {

            // On récupère les données du body dans les variables
            val mail = edt_mail_inscription.text.toString()
            val password = edt_password_inscription.text.toString()
            val confirm_password = edt_password_confirm_inscription.text.toString()
            val pseudo = edt_pseudo_inscription.text.toString()
            val firstname = edt_first_name_inscription.text.toString()


            // On initialise la connexion à la base de donnée grâçe à retrofit
            val retrofit = Retrofit.Builder()
                .baseUrl("http://mydiet-env.eba-ngy5cnjb.eu-west-3.elasticbeanstalk.com/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

            val service = retrofit.create(UserService::class.java)

            // Si les mots de passe correspondent
            if (password == confirm_password) {
                // On lance le service createUser avec les informations de l'utilisateur
                val courseRequest = service.createUser(firstname, pseudo, mail, password)
                println(courseRequest)
                println(firstname)
                println(mail)
                println(password)
                println(confirm_password)
                courseRequest.enqueue(object : Callback<ResponseBody> {
                    // En cas de réussite
                    override fun onResponse(
                        call: Call<ResponseBody>,
                        response: Response<ResponseBody>
                    ) {
                        Toast.makeText(
                            this@InscriptionActivity,
                            "Vous êtes inscrit !",
                            Toast.LENGTH_LONG
                        ).show()
                        val valid_inscription = Intent(this@InscriptionActivity, ConnexionActivity::class.java)
                        startActivity(valid_inscription)
                    }

                    // Si il y a une erreur
                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        println("user not created")
                        Toast.makeText(
                            this@InscriptionActivity,
                            "Erreur lors de l'inscription",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })
            }else{
                Toast.makeText(
                    this@InscriptionActivity,
                    "Les mots de passe ne correspondent pas.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
