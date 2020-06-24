package com.example.religionandme01.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.religionandme01.MainActivity
import com.example.religionandme01.R
import kotlinx.android.synthetic.main.activity_welcome_text.*

class WelcomeTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_text)

        nextButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("EXTRA_FROM_W", true)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            finish()
            startActivity(intent)
        }
    }
}