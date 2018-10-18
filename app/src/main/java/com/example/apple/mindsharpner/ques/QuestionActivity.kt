package com.example.apple.mindsharpner.ques

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Adapter
import android.widget.Toast
import com.example.apple.mindsharpner.R
import com.example.apple.mindsharpner.base.BaseMvpActivity
import com.example.apple.mindsharpner.base.MvpPresenter
import com.example.apple.mindsharpner.common.adapter.QuestionAdapter
import com.example.apple.mindsharpner.common.listener.QuestionListener
import com.example.apple.mindsharpner.data.QuestionEntity
import kotlinx.android.synthetic.main.layout_recycler_view.*
import javax.inject.Inject

class QuestionActivity : BaseMvpActivity<QuestionContract.View>(), QuestionContract.View, QuestionListener{

    @Inject
    protected lateinit var mPresenter: QuestionPresenter

    protected lateinit var mAdapter: QuestionAdapter

    override fun getPresenter(): MvpPresenter<QuestionContract.View> = mPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        mPresenter.takeView(this)
        mPresenter.fetchQuestions()
    }

    override fun setUpRecyclerView() {
        val manager = LinearLayoutManager(this)
        recyclerView.layoutManager = manager
        mAdapter = QuestionAdapter(this)
        recyclerView.adapter = mAdapter
    }

    override fun setView() {

    }

    override fun showMessage() {
       Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
    }

    override fun showError() {
        Toast.makeText(this, "Check your internet connection ", Toast.LENGTH_SHORT).show()
    }

    override fun setData(it: List<QuestionEntity>) {
       if (it.isNotEmpty()){
           mAdapter.addToBottom(it)
       }
    }

    override fun launchActivity() {
        Toast.makeText(this, "You answered this question", Toast.LENGTH_SHORT).show()
    }


}