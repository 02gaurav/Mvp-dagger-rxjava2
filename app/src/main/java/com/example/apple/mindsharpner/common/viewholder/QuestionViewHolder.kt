package com.example.apple.mindsharpner.common.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.RadioButton
import com.example.apple.mindsharpner.common.listener.QuestionListener
import com.example.apple.mindsharpner.data.local.QuestionEntity
import kotlinx.android.synthetic.main.viewholder_question_select.view.*

class QuestionViewHolder(itemView : View, private val mListner : QuestionListener) : RecyclerView.ViewHolder(itemView){

    init {
        var view : RadioButton ? = null
        itemView.bt_answer.setOnClickListener {
            if (itemView.rb_option1.isChecked) {
               view = itemView.rb_option1
            } else if (itemView.rb_option2.isChecked) {
                view = itemView.rb_option2
            } else if (itemView.rb_option3.isChecked) {
                view = itemView.rb_option3
            } else if (itemView.rb_option4.isChecked) {
                view = itemView.rb_option4
            }
            mListner.launchActivity(view)
        }

        itemView.rb_option1.setOnClickListener {
            itemView.rb_option2.isChecked = false
            itemView.rb_option3.isChecked = false
            itemView.rb_option4.isChecked = false
        }
        itemView.rb_option2.setOnClickListener {
            itemView.rb_option1.isChecked = false
            itemView.rb_option3.isChecked = false
            itemView.rb_option4.isChecked = false
        }
        itemView.rb_option3.setOnClickListener {
            itemView.rb_option2.isChecked = false
            itemView.rb_option1.isChecked = false
            itemView.rb_option4.isChecked = false
        }
        itemView.rb_option4.setOnClickListener {
            itemView.rb_option2.isChecked = false
            itemView.rb_option3.isChecked = false
            itemView.rb_option1.isChecked = false
        }
    }

    fun setData(questionEntity: QuestionEntity) {
        itemView.tv_question_id.text = questionEntity.quesId
        itemView.tv_question.text = questionEntity.question
        itemView.tv_option1.text = questionEntity.option1
        itemView.tv_option2.text = questionEntity.option2
        itemView.tv_option3.text = questionEntity.option3
        itemView.tv_option4.text = questionEntity.option4
    }
}