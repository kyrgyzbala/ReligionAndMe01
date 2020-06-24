package com.example.religionandme01.fragments.settings

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.religionandme01.MainActivity
import com.example.religionandme01.R
import kotlinx.android.synthetic.main.activity_change_language.*
import java.util.*

class ChangeLanguageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_language)

        titleLang.text = getString(R.string.chooseLanguage)
        imgToolbarLang.setOnClickListener {
            onBackPressed()
        }

        val sharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language = sharedPreferences.getString("My_Lang", "")!!
        if (language == "ky") {
            kyrgyzLang.setBackgroundColor(Color.parseColor("#5fb3a3"))
        } else {
            russianLang.setBackgroundColor(Color.parseColor("#5fb3a3"))
        }

        russianLang.setOnClickListener {
            val builder = AlertDialog.Builder(this, R.style.AlertDialogStyle)
                .setMessage("Перейти с кыргызского на русский язык?")
                .setPositiveButton("Перейти") { _, _ ->
                    setLocale("en", 1)
                }
                .setNegativeButton(R.string.cancel) { _, _ ->
                }
            builder.create().show()
        }
        kyrgyzLang.setOnClickListener {
            val builder = AlertDialog.Builder(this, R.style.AlertDialogStyle)
                .setMessage("Орус тилинен кыргыз тилине өтүү?")
                .setPositiveButton("Өтүү") { _, _ ->
                    setLocale("ky", 1)
                }
                .setNegativeButton(R.string.cancel) { _, _ ->

                }
            builder.create().show()
        }
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

        Toast.makeText(this, getString(R.string.changeLanguageMessage), Toast.LENGTH_LONG).show()

        if (code == 1)
            this.recreate()
        val intent = Intent(this, MainActivity::class.java)
        finish()
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("EXTRA_LANG", "11")
        startActivity(intent)
    }
}