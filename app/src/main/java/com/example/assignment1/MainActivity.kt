package com.example.assignment1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

        //retrieving all relevant components added to UI
        val btnReset = findViewById<Button>(R.id.btnReset)
        val edtTime = findViewById<EditText>(R.id.edtTime)
        val txtSpark = findViewById<TextView>(R.id.txtSpark)
        val btnSpark = findViewById<Button>(R.id.btnSpark)

        //variables to use in other parts of the code
        val greeting = "Your Spark Of The Day Is:"

         //reset button code
        btnReset?.setOnClickListener {

            txtSpark.text = greeting      //Clears the suggested sparks

            edtTime.text.clear()     //Clears the user's input
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}