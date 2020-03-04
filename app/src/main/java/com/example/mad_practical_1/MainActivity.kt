package com.example.mad_practical_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val countUpButton: Button = findViewById(R.id.countup_button)
        countUpButton.setOnClickListener { countUp() }
    }

    private fun rollDice() {
        //Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()

        val resultText: TextView = findViewById(R.id.result_text)
        //resultText.text = "Dice Rolled!"

        val randomInt = (1..6).random()
        resultText.text = randomInt.toString()
        Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
    }

    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)
        val num = resultText.text.toString().toIntOrNull()

        if (num == null) {
            resultText.text = "1"
        } else if (num < 6) {
            resultText.text = (num + 1).toString()
        }

        //Sample Answer
        /*if (resultText.text == "Hello world!") {
            resultText.text = "1"
        } else {
            var resultInt = resultText.text.toString().toInt()

            if (resultInt < 6) {
                resultInt++
                resultText.text = resultInt.toString()
            }
        }*/
    }
}
