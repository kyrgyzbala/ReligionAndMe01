package com.example.religionandme01.fragments.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.religionandme01.R
import kotlinx.android.synthetic.main.activity_review.*

class ReviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        titleReview.text = getString(R.string.leaveReview)

        imgToolbarRev.setOnClickListener {
            onBackPressed()
        }
    }
}