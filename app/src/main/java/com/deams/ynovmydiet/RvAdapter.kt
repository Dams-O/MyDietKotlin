package com.deams.ynovmydiet

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

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
        p0.count?.text = foodList[p1].count.toString()
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.tvName)
        val count = itemView.findViewById<TextView>(R.id.tvCount)

    }
}
)