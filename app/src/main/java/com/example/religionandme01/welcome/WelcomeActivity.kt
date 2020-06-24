package com.example.religionandme01.welcome

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.religionandme01.R
import kotlinx.android.synthetic.main.activity_welcome.*
import java.util.*

class WelcomeActivity : AppCompatActivity() {

    private var choosenLang: String = ""
    private var choosenAge: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val sharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language = sharedPreferences.getString("My_Lang", "")!!

        if (language == "ky") {
            langKyCardView.setCardBackgroundColor(Color.parseColor("#5fb3a3"))
            buttonLangKy.setTextColor(Color.parseColor("#ffffff"))
            choosenLang = "ky"
        } else if (language == "en") {
            langRussCardView.setCardBackgroundColor(Color.parseColor("#5fb3a3"))
            buttonLangRu.setTextColor(Color.parseColor("#ffffff"))
            choosenLang = "ru"
        }

        buttonLangKy.setOnClickListener {
            setLocale("ky", 1)
        }
        buttonLangRu.setOnClickListener {
            setLocale("en", 1)
        }

        buttonAgeRange01.setOnClickListener {
            choosenAge = buttonAgeRange01.text.toString()
            ageRange01.setCardBackgroundColor(Color.parseColor("#5fb3a3"))
            ageRange02.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
            ageRange03.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
            ageRange04.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
        }

        buttonAgeRange02.setOnClickListener {
            choosenAge = buttonAgeRange02.text.toString()
            ageRange02.setCardBackgroundColor(Color.parseColor("#5fb3a3"))
            ageRange01.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
            ageRange03.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
            ageRange04.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
        }

        buttonAgeRange03.setOnClickListener {
            choosenAge = buttonAgeRange03.text.toString()
            ageRange03.setCardBackgroundColor(Color.parseColor("#5fb3a3"))
            ageRange02.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
            ageRange01.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
            ageRange04.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
        }

        buttonAgeRange04.setOnClickListener {
            choosenAge = buttonAgeRange04.text.toString()
            ageRange04.setCardBackgroundColor(Color.parseColor("#5fb3a3"))
            ageRange02.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
            ageRange03.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
            ageRange01.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
        }

        nextButton.setOnClickListener {
            if (choosenLang.isNotEmpty()) {
                if (choosenAge.isNotEmpty()) {
                    postAge()
                }
                setStatus()
                goToNextPage()
            } else {
                Toast.makeText(this, getString(R.string.welcomeErrorMessage), Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    private fun setStatus() {
        val editor = getSharedPreferences("userStatus", Context.MODE_PRIVATE).edit()
        editor.putString("user_status", "done")
        editor.apply()
    }

    private fun goToNextPage() {
        val intent = Intent(this, WelcomeTextActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        finish()
        startActivity(intent)
    }

    private fun postAge() {
        //TO-DO when API is ready
    }

    @Suppress("DEPRECATION")
    private fun setLocale(lang: String, code: Int) {

        val locale = Locale(lang)

        Locale.setDefault(locale)

        val config = Configuration()

        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

        val editor = getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        editor.putString("My_Lang", lang)
        editor.apply()

//        Toast.makeText(this, getString(R.string.changeLanguageMessage), Toast.LENGTH_LONG).show()

        if (code == 1)
            this.recreate()

    }
}