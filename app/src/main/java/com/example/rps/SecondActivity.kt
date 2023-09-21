package com.example.rps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setResult()
    }

    private fun setResult(){
        val lable = findViewById<TextView>(R.id.result)
        lable.text = intent.getStringExtra("result")
    }
}