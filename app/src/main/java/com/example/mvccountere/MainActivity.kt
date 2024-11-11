package com.example.mvccountere

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val counterModel = CounterModel()
        //Get the reference of UI elements
        val countTextView = findViewById<TextView>(R.id.counterTextView)
        val increaseButton: Button = findViewById(R.id.increaseCountButton)
        val resetButton = findViewById<Button>(R.id.resetCountButton)

        //Display the initial count

        countTextView.text = counterModel.getCount().toString()
        //Set click listener for the increase button

        increaseButton.setOnClickListener {
            counterModel.increament() //update the model
            countTextView.text = counterModel.getCount().toString()

        }

        //set onclick listener for the reset

        resetButton.setOnClickListener {
            counterModel.reset()
            countTextView.text = counterModel.getCount().toString()
        }


    }
}