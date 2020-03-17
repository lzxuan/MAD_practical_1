package com.example.mad_practical_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.IntegerRes
import timber.log.Timber

const val KEY_RANDOM_INT = "random_int_key"
const val KEY_RANDOM_INT_2 = "random_int_2_key"

class MainActivity : AppCompatActivity() {

    lateinit var diceImage : ImageView
    lateinit var diceImage2 : ImageView

    var randomInt = 0
    var randomInt2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image_2)

        if (savedInstanceState != null) {
            randomInt = savedInstanceState.getInt(KEY_RANDOM_INT, 0)
            randomInt2 = savedInstanceState.getInt(KEY_RANDOM_INT_2, 0)
            setDiceImage()
        }

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val clearButton: Button = findViewById(R.id.clear_button)
        clearButton.setOnClickListener { clearDice() }

        Timber.i("onCreate Called")
    }

    override fun onStart() {
        super.onStart()

        Timber.i("onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy Called")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.i("onRestart Called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(KEY_RANDOM_INT, randomInt)
        outState.putInt(KEY_RANDOM_INT_2, randomInt2)

        Timber.i("onSaveInstanceState Called")
    }

    private fun rollDice() {
        setRandomInt()
        setDiceImage()
    }

    private fun setRandomInt() {
        randomInt = (1..6).random()
        randomInt2 = (1..6).random()
    }

    private fun setDiceImage() {
        diceImage.setImageResource(getDiceImage(randomInt))
        diceImage2.setImageResource(getDiceImage(randomInt2))
    }

    private fun getDiceImage(randomInt : Int) : Int {
        return when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
    }

    private fun clearDice() {
        randomInt = 0
        randomInt2 = 0
        diceImage.setImageResource(R.drawable.empty_dice)
        diceImage2.setImageResource(R.drawable.empty_dice)
    }
}
