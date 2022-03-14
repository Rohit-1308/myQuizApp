package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class resultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var tvName:TextView=findViewById(R.id.tv_username)
        var tvresult:TextView=findViewById(R.id.tv_result)
        val btnfinish: Button =findViewById(R.id.btn_finish)

        tvName.text=intent.getStringExtra(Constants.USER_NAME)
        tvresult.text="your Score is ${intent.getIntExtra(Constants.CORRECT_ANSWERS,0)}/${intent.getIntExtra(Constants.TOTAL_QUESTION,0)}"

        btnfinish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}