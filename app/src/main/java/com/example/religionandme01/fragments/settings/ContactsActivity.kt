package com.example.religionandme01.fragments.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.religionandme01.R
import kotlinx.android.synthetic.main.activity_contacts.*

class ContactsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)
        setSupportActionBar(toolbar_contacts)

        title = getString(R.string.contacts)


    }
}