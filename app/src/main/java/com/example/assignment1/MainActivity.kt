package com.example.assignment1

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
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


        //Suggest button code
        btnSpark?.setOnClickListener {

            val time = edtTime.text.toString().lowercase()

            Log.d("MainActivity","Suggested spark button clicked")
            Log.d("MainActivity","User input: $time")

            var message: String

            if (time == "morning") {
                message = "Send a good morning text to your partner"
                Log.d("MainActivity","Morning selected")

            } else if (time == "afternoon") {
                message = "Send a relatable funny tiktok to your bestfriend"
                Log.d("MainActivity", "Afternoon selected")

            } else if (time == "night") {
                message = "Send a goodnight text to your partner"
                Log.d("MainActivity", "Night selected")

            } else {
                //If no valid input was given by user
                Toast.makeText(
                    this@MainActivity,
                    "Please enter a valid time of day",
                    Toast.LENGTH_LONG).show()
                return@setOnClickListener


            }
            txtSpark.text = greeting+ "\n\n" +message
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}