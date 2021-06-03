package com.evable.cashandmitra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private  lateinit var textView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var goTo = findViewById(R.id.go) as TextView

        goTo.setOnClickListener {
            intent = Intent(this, ChangePassword::class.java)
            startActivity(intent)
        }


    }
    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}