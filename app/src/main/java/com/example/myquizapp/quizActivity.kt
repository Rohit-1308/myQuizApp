package com.example.myquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class quizActivity : AppCompatActivity(),View.OnClickListener{
    private var mCurrentPosition:Int=1
    private var mQuestionList:ArrayList<Question>?=null
    private var mSelectedOptionPostion:Int=0
    private var mUsername:String?=null
    private var mCorrectanswers:Int=0
    private var progressbar:ProgressBar?=null
    private var tvprogress:TextView?=null
    private var tvquestion:TextView?=null
    private var ivimage:ImageView?=null

    private var optionone:TextView?=null
    private var optiontwo:TextView?=null
    private var optionthree:TextView?=null
    private var optionfour:TextView?=null
    private var btnSubmit:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        mUsername=intent.getStringExtra(Constants.USER_NAME)
        progressbar=findViewById(R.id.progressbar)
        tvprogress=findViewById(R.id.tv_progress)
        tvquestion=findViewById(R.id.tv_question)
        ivimage=findViewById(R.id.iv_image)

        optionone=findViewById(R.id.optionone)
        optiontwo=findViewById(R.id.optiontwo)
        optionthree=findViewById(R.id.optionthree)
        optionfour=findViewById(R.id.optionfour)
        btnSubmit=findViewById(R.id.btn_Submit)

        mQuestionList = Constants.getQuestions()

        optionone?.setOnClickListener(this)
        optiontwo?.setOnClickListener(this)
        optionthree?.setOnClickListener(this)
        optionfour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)
        setQuestion()



    }

    private fun setQuestion() {
        defaultOptionView()
        val question: Question = mQuestionList!![mCurrentPosition - 1]
        ivimage?.setImageResource(question.image)
        progressbar?.progress = mCurrentPosition
        tvprogress?.text = "$mCurrentPosition / ${progressbar?.max}"
        tvquestion?.text = question.question
        optionone?.text = question.optionOne
        optiontwo?.text = question.optionTwo
        optionthree?.text = question.optionThree
        optionfour?.text = question.optionFour
        if(mCurrentPosition==mQuestionList!!.size){
            btnSubmit?.text="FINISH"
        }
        else{
            btnSubmit?.text="SUBMIT"
        }
    }
    private fun defaultOptionView(){
        val options=ArrayList<TextView>()
        optionone?.let {
            options.add(0,it)
        }
        optiontwo?.let {
            options.add(1,it)
        }
        optionthree?.let {
            options.add(2,it)
        }
        optionfour?.let {
            options.add(3,it)
        }
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(
                this,R.drawable.default_option_border_bg
            )
        }
    }
    private fun selectedOptionView(tv:TextView ,selectedOptionNum:Int){
        defaultOptionView()
        mSelectedOptionPostion=selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background= ContextCompat.getDrawable(
            this,R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(view: View?) {

        when(view?.id){
            R.id.optionone->{
                optionone?.let{
                    selectedOptionView(it,1)
                }
            }
        R.id.optiontwo->{
            optiontwo?.let{
                    selectedOptionView(it,2)
                }
            }
        R.id.optionthree->{
            optionthree?.let{
                    selectedOptionView(it,3)
                }
            }
        R.id.optionfour->{
            optionfour?.let{
                    selectedOptionView(it,4)
                }
        }
            R.id.btn_Submit->{
                if(mSelectedOptionPostion==0){
                    mCurrentPosition++
                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }else->{
                            val intent=Intent(this,resultActivity::class.java)
                        intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectanswers)
                        intent.putExtra(Constants.USER_NAME,mUsername)
                        intent.putExtra(Constants.TOTAL_QUESTION,mQuestionList!!.size)
                        startActivity(intent)
                        finish()
                        }
                    }
                }
                else{
                    val question=mQuestionList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer!=mSelectedOptionPostion ){
                        answerview(mSelectedOptionPostion,R.drawable.wrong_option_border_bg)

                    }else{
                        mCorrectanswers++;
                    }
                    answerview(question!!.correctAnswer,R.drawable.correct_option_border_bg)

                    if(mCurrentPosition==mQuestionList!!.size){
                        btnSubmit?.text="FINISH"
                    }
                    else{
                        btnSubmit?.text="Next Question"

                    }
                    mSelectedOptionPostion=0

                }
            }
        }
    }

    private fun answerview(answer:Int,drawableview:Int){
        when(answer){
            1->{
                optionone?.background=ContextCompat.getDrawable(
                    this,
                    drawableview
                )
            }
            2->{
                optiontwo?.background=ContextCompat.getDrawable(
                    this,
                    drawableview
                )
            }3->{
                optionthree?.background=ContextCompat.getDrawable(
                    this,
                    drawableview
                )
            }4->{
                optionfour?.background=ContextCompat.getDrawable(
                    this,
                    drawableview
                )
            }
        }
    }

}