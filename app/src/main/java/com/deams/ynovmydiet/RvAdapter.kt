package com.deams.ynovmydiet

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deams.ynovmydiet.database.entities.ResumeMeal


class RvAdapter (val foodList: ArrayList<ResumeMeal>):
    RecyclerView.Adapter<RvAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.adapter_stats_layout, p0, false)
        return ViewHolder(v);
    }
    override fun getItemCount(): Int {
        return foodList.size
    }
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        p0.date?.text = foodList[p1].date
        p0.aliment?.text = foodList[p1].aliment
        p0.score?.text = foodList[p1].score
        p0.moment?.text = foodList[p1].moment

        val test = p0.score?.text.toString()
        val testMoment = foodList[p1].moment.toString()

        /* p0.moment?.visibility = View.INVISIBLE
        //Condition Pour photoRepas src
        if(testMoment.equals("Petit Déjeuner")){
            p0.photoRepas.setImageResource(R.drawable.petit_dej_icon)
        }
        if(testMoment.equals("Déjeuner")){
            p0.photoRepas.setImageResource(R.drawable.dej_icon)
        }
        if(testMoment.equals("Diner")){
            p0.photoRepas.setImageResource(R.drawable.diner_icon)
        } */

        //Condition Pour Score color
        if(test.equals("En accord à 100%") || test.equals("En accord à 90%")){
            p0.score?.setTextColor(Color.parseColor("#0EC200"))
        }
        if(test.equals("En accord à 80%") || test.equals("En accord à 70%")){
            p0.score?.setTextColor(Color.parseColor("#ADF12F"))
        }

        if(test.equals("En accord à 60%") || test.equals("En accord à 50%") || test.equals("En accord à 40%")){
            p0.score?.setTextColor(Color.parseColor("#F1832F"))
        }

        if(test.equals("En accord à 20%")) {
            p0.score?.setTextColor(Color.parseColor("#F00107"))
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val date = itemView.findViewById<TextView>(R.id.food)
        val aliment = itemView.findViewById<TextView>(R.id.tv_description)
        val score = itemView.findViewById<TextView>(R.id.tv_score)
        val moment = itemView.findViewById<TextView>(R.id.tv_moment)
        val photoRepas = itemView.findViewById<ImageView>(R.id.iv_repas)


    }
}
