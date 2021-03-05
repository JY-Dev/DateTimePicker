package com.example.numberpickertest

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.numberpickertest.picker.DateTimePicker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.test_btn).setOnClickListener {
            findViewById<DateTimePicker>(R.id.test).plusFiveMinute()
        }
    }
}