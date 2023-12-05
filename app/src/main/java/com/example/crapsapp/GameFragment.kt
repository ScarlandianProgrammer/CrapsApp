package com.example.crapsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val diceButton: Button = view.findViewById(R.id.diceButton)
        val diceResult: TextView = view.findViewById(R.id.diceResult)

        diceButton.setOnClickListener {
            val dice1 = rollDice()
            val dice2 = rollDice()
            val sum = dice1 + dice2

            diceResult.text = "Dice 1: $dice1\nDice 2: $dice2\nSum: $sum"
        }
    }

    private fun rollDice(): Int {
        return (1..6).random()
    }
}
