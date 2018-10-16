package com.example.apple.mindsharpner.mind

import android.os.Bundle
import android.widget.Toast
import com.example.apple.mindsharpner.R
import com.example.apple.mindsharpner.base.BaseMvpActivity
import com.example.apple.mindsharpner.base.MvpPresenter
import com.example.apple.mindsharpner.data.TwoNumbers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MathActivity : BaseMvpActivity<MathContract.View>(), MathContract.View{

    @Inject
    protected lateinit var mPresenter : MathContract.Presenter

    override fun getPresenter(): MvpPresenter<MathContract.View> = mPresenter


    companion object {
         var correct :Int = 0
         var incorrect : Int =0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter.takeView(this)
        setListener()
    }

    override fun onStart() {
        super.onStart()
        mPresenter.genrateNumbers()
        mPresenter.genrateOperators()
    }

    override fun setView(twoNumbers: TwoNumbers) {
        tvFirstNumber.text = twoNumbers.number1.toString()
        tvSecondNumber.text = twoNumbers.number2.toString()
    }

    override fun setOperator(op : String) {
        tvOperator.text = op
    }

    override fun showMessage() {
        Toast.makeText(this, "Error in genrating ", Toast.LENGTH_SHORT).show()
    }


    private fun setListener() {
        bt_next.setOnClickListener{
            mPresenter.genrateNumbers()
            mPresenter.genrateOperators()
        }

        bt_submit.setOnClickListener {
            if (et_answer.text.toString() != "") {
                val f = tvFirstNumber.text.toString().toInt()
                val s = tvSecondNumber.text.toString().toInt()
                val res = et_answer.text.toString().toInt()
                mPresenter.verifyAnswer(f, s, res, tvOperator.text.toString())
                et_answer.clearFocus()
                et_answer.text.clear()
                mPresenter.genrateNumbers()
                mPresenter.genrateOperators()
            }
        }

    }

    override fun setCount(correct : String, incorrect :String) {
        tvCorreect.text = correct
        tvInCorreect.text = incorrect
    }

}