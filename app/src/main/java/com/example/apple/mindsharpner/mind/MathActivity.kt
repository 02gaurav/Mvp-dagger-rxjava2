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

    private  var mlevel : Int = 1

    override fun getPresenter(): MvpPresenter<MathContract.View> = mPresenter

    var mCorrect :String = ""
    var mIncorrect : String = ""


    companion object {
        const val LEVEL = "level"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter.takeView(this)
        setListener()
        mlevel = intent.getIntExtra(LEVEL, 1)
        mPresenter.genrateNumbers(mlevel)
        mPresenter.genrateOperators(mlevel)
    }

    override fun setView(twoNumbers: TwoNumbers) {
        tvFirstNumber.text = twoNumbers.number1.toString()
        tvSecondNumber.text = twoNumbers.number2.toString()
    }

    override fun setOperator(op : String) {
        tvOperator.text = op
    }

    override fun showMessage() {
      //  Toast.makeText(this, "Error in generating ", Toast.LENGTH_SHORT).show()
    }


    private fun setListener() {
        bt_next.setOnClickListener{
            mPresenter.genrateNumbers(mlevel)
            mPresenter.genrateOperators(mlevel)
        }

        bt_submit.setOnClickListener {
            if (et_answer.text.toString() != "") {
                val f = tvFirstNumber.text.toString().toInt()
                val s = tvSecondNumber.text.toString().toInt()
                val res = et_answer.text.toString().toInt()
                mPresenter.verifyAnswer(f, s, res, tvOperator.text.toString())
                et_answer.clearFocus()
                et_answer.text.clear()
                mPresenter.genrateNumbers(mlevel)
                mPresenter.genrateOperators(mlevel)
            }
        }

    }

    override fun setCount(correct : String, inCorrect :String) {
        tvCorreect.text = correct
        tvInCorreect.text = inCorrect
        mCorrect = correct
        mIncorrect = inCorrect
    }

    override fun onResume() {
        super.onResume()
        tvCorreect.text = mCorrect
        tvInCorreect.text = mIncorrect
    }

    override fun onBackPressed() {

        finish()
    }

}