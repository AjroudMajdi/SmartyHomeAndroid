package com.example.smartyhome

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

class HomeActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        setContentView(R.layout.activity_home)
        val sharedPreference = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
      val user =sharedPreference.getString("username","")
        val sdf = SimpleDateFormat("MMMM dd, yyyy", Locale.US)
        val currentDate = sdf.format(Date())

        val date = findViewById<TextView>(R.id.date)
        val name = findViewById<TextView>(R.id.name)
        name.setText(user + '!')
        date.setText(currentDate)
    }
}