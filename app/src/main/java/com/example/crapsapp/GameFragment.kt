package com.example.crapsapp

import android.os.Bundle
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class GameFragment : Fragment() {
    private var points = 0
    private lateinit var diceResult: TextView
    private lateinit var pointDisplay: TextView
    private lateinit var diceButton: Button
    private lateinit var gameButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        diceResult = view.findViewById(R.id.diceResult)
        pointDisplay = view.findViewById(R.id.pointDisplay)
        diceButton = view.findViewById(R.id.diceButton)
        gameButton = view.findViewById(R.id.gameButton)

        gameButton.setOnClickListener {
            startRound()
        }

        diceButton.setOnClickListener {
            rollDice(diceResult, pointDisplay)
        }
    }
    private fun rollDice(diceResult: TextView, pointDisplay: TextView) {
        /*
        * roll two dice
        * determine if they are important
        * display the dice total and add any points
        */
        val roll = (1..6).random() + (1..6).random()
        evaluateRoll(roll)
        updateDisplay(roll)
    }

    private fun updateDisplay(roll: Int) {
        pointDisplay.text = getString(R.string.points_display, points.toString())
        if (roll == 2 || roll == 12) {
            diceResult.text = getString(R.string.round_over_display)
        } else {
            diceResult.text = getString(R.string.roll_display, roll.toString())
        }
    }

    private fun evaluateRoll(roll: Int) {
        if (roll == 7 || roll == 11) {
            points++
        } else if (roll == 2 || roll == 12) {
            endRound()
        }
    }

    private fun startRound() {
        diceButton.setOnClickListener {
            rollDice(diceResult, pointDisplay)
        }
        points = 0
        updateDisplay(0)
    }

    private fun endRound() {
        diceButton.setOnClickListener {  }
    }
}
