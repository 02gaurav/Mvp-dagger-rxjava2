package com.example.apple.mindsharpner.level

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.apple.mindsharpner.R
import com.example.apple.mindsharpner.base.BaseMvpActivity
import com.example.apple.mindsharpner.base.MvpPresenter
import com.example.apple.mindsharpner.common.adapter.LevelAdapter
import com.example.apple.mindsharpner.common.listener.LevelListener
import com.example.apple.mindsharpner.level.data.Levels
import com.example.apple.mindsharpner.mind.MathActivity
import kotlinx.android.synthetic.main.layout_recycler_view.*
import javax.inject.Inject

class LevelActivity : BaseMvpActivity<LevelContract.View>(), LevelContract.View, LevelListener{

    @Inject
    protected lateinit var mPresenter: LevelPresenter

    private lateinit var mAdapter : LevelAdapter

    companion object {

        const val LEVEL ="level"
    }
    override fun getPresenter(): MvpPresenter<LevelContract.View> = mPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.takeView(this)
        setContentView(R.layout.activity_level)
        setUpRecyclerView()
        setAdapter()
        mPresenter.getAllLevel()
    }

    private fun setUpRecyclerView() {
        val manager = LinearLayoutManager(this)
        recyclerView.layoutManager = manager
    }

    private fun setAdapter() {
        mAdapter = LevelAdapter(this)
        recyclerView.adapter = mAdapter
    }

    override fun getList(mlevelList  : List<Levels>){
        if (mlevelList.isNotEmpty()){
            mAdapter.addToBottom(mlevelList)
        }
    }

    override fun launchMathActivity(level : Int) {
        val intent = Intent(this, MathActivity::class.java )
        intent.putExtra(LEVEL, level)
        startActivity(intent)
    }


}