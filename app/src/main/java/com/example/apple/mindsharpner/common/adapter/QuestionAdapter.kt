package com.example.apple.mindsharpner.common.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.apple.mindsharpner.R
import com.example.apple.mindsharpner.common.listener.QuestionListener
import com.example.apple.mindsharpner.common.viewholder.QuestionViewHolder
import com.example.apple.mindsharpner.data.local.QuestionEntity
import java.util.ArrayList

class QuestionAdapter(private val mListener : QuestionListener) : RecyclerView.Adapter<QuestionViewHolder>(){

    private var mQuestionList = ArrayList<QuestionEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): QuestionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_question_select, parent, false)
        return QuestionViewHolder(view, mListener)
    }

    override fun getItemCount(): Int {
       return mQuestionList.size
    }

    override fun onBindViewHolder(viewHolder : QuestionViewHolder, position: Int) {
        val ques = mQuestionList[position]
        viewHolder.setData(ques)

    }

    fun addToBottom(mList: List<QuestionEntity>){
        mQuestionList.addAll(mList)
        notifyDataSetChanged()
    }

}//1860266333333--- KASSIST 5676788 25th