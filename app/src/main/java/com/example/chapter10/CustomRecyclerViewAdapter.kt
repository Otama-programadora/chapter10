package com.example.chapter10

import android.content.Intent
import android.graphics.Color
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.realm.RealmResults

class CustomRecyclerViewAdapter(realmResults: RealmResults<BloodPressure>):
    RecyclerView.Adapter<ViewHolder>() {
    private val rResults: RealmResults<BloodPressure> = realmResults

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.one_result, parent, false)
        val viewholder = ViewHolder(view)
        return viewholder
    }

    override fun getItemCount(): Int {
        return rResults.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bloodPressure = rResults[position]
        holder.dateText?.text = DateFormat.format("yyyy/MM/dd kk:mm", bloodPressure?.dateTime)
        holder.minMaxText?.text = "${bloodPressure?.max.toString()}/${bloodPressure?.min.toString()}"
        holder.pulseText?.text = bloodPressure?.pulse.toString()
        holder.itemView.setBackgroundColor(if(position % 2 == 0)
            Color.LTGRAY else Color.WHITE)
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, EditActivity::class.java)
            intent.putExtra("id", bloodPressure?.id)
            it.context.startActivity(intent)
        }
    }
}