package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.diceroller.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.diceImageView.isVisible = false

        binding.rollButton.setOnClickListener {
            rollDice()
        }
    }

    fun rollDice() {
        val dice = Dice(6)
        val result = dice.roll()

        val imageResource = when (result) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        binding.diceImageView.setImageResource(imageResource)
        binding.diceImageView.contentDescription = imageResource.toString()
        binding.diceImageView.isVisible = true
    }
}

class Dice(val value: Int) {
    fun roll() : Int {
        return (1..value).random()
    }
}