package com.example.smartyhome

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }

        val sharedPreference = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val login = sharedPreference.getString("username", "")
        if (!login.equals("")) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        val editText = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            var text = editText.text.toString()
            val intent = Intent(this, HomeActivity::class.java)

            val editor: SharedPreferences.Editor = sharedPreference.edit()
            editor.putString("username", text)
            editor.apply()
            Toast.makeText(this, text, Toast.LENGTH_LONG).show()
            startActivity(intent)
        }

    }


}