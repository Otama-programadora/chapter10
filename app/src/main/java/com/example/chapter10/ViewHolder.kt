package com.example.chapter10

import android.view.View
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.one_result.view.*

class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    var dateText: TextView? = null
    var minMaxText: TextView? = null
    var pulseText: TextView? = null
    init {
        dateText = itemView.dateText
        minMaxText = itemView.minMaxText
        pulseText = itemView.pulseText
    }
}