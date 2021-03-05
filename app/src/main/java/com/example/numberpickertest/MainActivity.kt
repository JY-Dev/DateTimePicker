package com.example.numberpickertest

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.test_btn).setOnClickListener {
            findViewById<DatePicker>(R.id.test).run {
                Toast.makeText(this@MainActivity,getCurrentDateString(),Toast.LENGTH_SHORT).show()
            }
        }
    }
}