package com.example.apple.mindsharpner.common.viewholder

import android.graphics.Color
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.apple.mindsharpner.R
import com.example.apple.mindsharpner.level.data.Levels
import kotlinx.android.synthetic.main.viewholder_level_select.view.*

class LevelViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

    val cvLangCard = itemView.findViewById<CardView>(R.id.cv_level_container)

    fun setView(levels: Levels) {

        itemView.tv_level_name.text = levels.levels
        itemView.cv_level_container.setCardBackgroundColor(Color.parseColor(levels.resourceUrl.toString()))
    }
}