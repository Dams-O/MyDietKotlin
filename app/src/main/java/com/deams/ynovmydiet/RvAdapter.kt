package com.deams.ynovmydiet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_stats_layout.*

class RvAdapter (val foodList: ArrayList<Food>):
    RecyclerView.Adapter<RvAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.adapter_stats_layout, p0, false)
        return ViewHolder(v);
    }
    override fun getItemCount(): Int {
        return foodList.size
    }
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        p0.name?.text = foodList[p1].name
        p0.family?.text = foodList[p1].family
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.tv_title)
        val family = itemView.findViewById<TextView>(R.id.tv_description)

    }
}
