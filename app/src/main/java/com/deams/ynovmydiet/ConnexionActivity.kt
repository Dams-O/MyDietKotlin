package com.deams.ynovmydiet

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.deams.ynovmydiet.database.services.UserService
import kotlinx.android.synthetic.main.content_connexion.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import com.deams.ynovmydiet.database.entities.User
import android.widget.Button
import android.widget.ImageButton


/**
 * A login screen that offers login via email/password.
 */
class ConnexionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_connexion)

        val btn_mdp_oublie: Button = findViewById(R.id.mdpoublie)
        btn_mdp_oublie.setOnClickListener {
            val intent = Intent(this@ConnexionActivity, MotDePasseOublieActivity::class.java)
            startActivity(intent)
        }
        val btn_inscription: Button = findViewById(R.id.btn_inscription_validation)
        btn_inscription.setOnClickListener {
            val intent = Intent(this@ConnexionActivity, InscriptionActivity::class.java)
            startActivity(intent)
        }

        val btn_connexion: ImageButton = findViewById(R.id.btn_connexion)
        btn_connexion.setOnClickListener {
            val intent = Intent(this@ConnexionActivity, HomeActivity::class.java)
            startActivity(intent)
            // On récupère les données du body dans les variables mail et password
            /*val mail = mail.text.toString()
            val password = password.text.toString()
            println(mail)
            println(password)

            // On initialise la connexion à la base de donnée grâçe à retrofit
            val retrofit = Retrofit.Builder()
                .baseUrl("http://backapi-mydietapp.43ki6n3qg7.eu-west-1.elasticbeanstalk.com/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
            val service = retrofit.create(UserService::class.java)

            // On lance le service loginUser avec l'identifiant 'mail' et le password
            val courseRequest = service.loginUser(mail, password)
            courseRequest.enqueue(object : Callback<User> {

                // Si on arrive à executer la requête
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    val infoUser = response.body()

                    // Si on arrive à récupérer les identifiants ( si l'utilisateur existe en base ) on le connecte
                    if (mail == infoUser?.mail){
                        Toast.makeText(this@ConnexionActivity,"Vous êtes connecté(e)", Toast.LENGTH_LONG).show()
                        val intent = Intent(this@ConnexionActivity, HomeActivity::class.java)
                        intent.putExtra("id_user", infoUser.id_user.toString())
                        intent.putExtra("pseudo", infoUser.pseudo)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this@ConnexionActivity,"Identifiant/mot de passe incorrect ou inexistant", Toast.LENGTH_LONG).show()
                    }
                }

                // Si on arrive pas à faire la requête on affiche une erreur
                override fun onFailure(call: Call<User>, t: Throwable) {
                    println("KO")
                }
            })
*/
            }

        }
    }
