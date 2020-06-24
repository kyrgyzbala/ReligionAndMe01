package com.example.religionandme01.fragments.ask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.religionandme01.R
import kotlinx.android.synthetic.main.activity_ask_question.*

class AskQuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ask_question)
//        setSupportActionBar(toolbar_ask)
//
//        supportActionBar?.setHomeAsUpIndicator(R.drawable.arrow_back)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        imgToolbar.setOnClickListener {
            onBackPressed()
        }
    }

}