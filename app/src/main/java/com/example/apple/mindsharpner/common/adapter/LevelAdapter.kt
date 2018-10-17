package com.example.apple.mindsharpner.common.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.apple.mindsharpner.R
import com.example.apple.mindsharpner.common.listener.LevelListener
import com.example.apple.mindsharpner.common.viewholder.LevelViewHolder
import com.example.apple.mindsharpner.level.data.Levels
import java.util.ArrayList

class LevelAdapter(private val mListener : LevelListener) :  RecyclerView.Adapter<LevelViewHolder>(){

    private var mLevelList = ArrayList<Levels>()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): LevelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_level_select, parent, false)
        val levelViewHolder = LevelViewHolder(view)
        levelViewHolder.cvLangCard.setOnClickListener {
            mListener.launchMathActivity()

        }
        return levelViewHolder
    }

    override fun getItemCount(): Int {
        return  mLevelList.size
    }

    override fun onBindViewHolder(holder: LevelViewHolder, position: Int) {
        val level : Levels = mLevelList[position]
        holder.setView(level)
    }

    fun addToBottom(mList: List<Levels>){
        mLevelList.addAll(mList)
    }

}