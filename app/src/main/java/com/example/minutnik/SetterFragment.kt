package com.example.minutnik

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class SetterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Pola tekstowe
        val tensMinutesTV = view.findViewById<TextView>(R.id.LinearLayoutSetterTensMinutesText)
        val minutesTV = view.findViewById<TextView>(R.id.LinearLayoutSetterMinutesText)
        val tensSecondsTV = view.findViewById<TextView>(R.id.LinearLayoutSetterTensSecondsText)
        val secondsTV = view.findViewById<TextView>(R.id.LinearLayoutSetterSecondsText)

        tensMinutesTV.text = Timer.minutesTens.toString()
        minutesTV.text = Timer.minutes.toString()
        tensSecondsTV.text = Timer.secondsTens.toString()
        secondsTV.text = Timer.seconds.toString()

        //Minuty - dziesiątki

        var minutesTensPlusButton = view.findViewById<Button>(R.id.ButtonPlusTensMinutes)
        var minutesTensMinusButton = view.findViewById<Button>(R.id.ButtonMinusTensMinutes)

        minutesTensPlusButton.setOnClickListener {
            Timer.minutesTens++
            tensMinutesTV.text = Timer.minutesTens.toString()
        }

        minutesTensMinusButton.setOnClickListener {
            if(Timer.minutesTens > 0)
            {
                Timer.minutesTens--
                tensMinutesTV.text = Timer.minutesTens.toString()
            }
        }

        // Minuty - Jedności

        val minutesPlusButton = view.findViewById<Button>(R.id.ButtonMinutesPLus)
        val minutesMinusButton = view.findViewById<Button>(R.id.ButtonMinutesMinus)

        minutesPlusButton.setOnClickListener {
            if(Timer.minutes < 9)
            {
                Timer.minutes++
                minutesTV.text = Timer.minutes.toString()
            }
            else
            {
                Timer.minutes = 0
                Timer.minutesTens++
                minutesTV.text = Timer.minutes.toString()
                tensMinutesTV.text = Timer.minutesTens.toString()

            }
        }

        minutesMinusButton.setOnClickListener {
            if(Timer.minutes > 0)
            {
                Timer.minutes--
                minutesTV.text = Timer.minutes.toString()
            }
            else
            {
                if(Timer.minutesTens > 0)
                {
                    Timer.minutesTens--
                    Timer.minutes = 9
                    minutesTV.text = Timer.minutes.toString()
                    tensMinutesTV.text = Timer.minutesTens.toString()
                }
            }
        }

        // Sekundy - Dziesiątki

        val secondsTensPlusButton = view.findViewById<Button>(R.id.ButtonSecondsTensPlus)
        val secondsTensMinusButton = view.findViewById<Button>(R.id.ButtonSecondsTensMinus)

        secondsTensPlusButton.setOnClickListener {
            if(Timer.secondsTens < 5)
            {
                Timer.secondsTens++
                tensSecondsTV.text = Timer.secondsTens.toString()
            }
            else
            {
                Timer.secondsTens = 0
                minutesPlusButton.performClick()
                tensSecondsTV.text = Timer.secondsTens.toString()
            }
        }

        secondsTensMinusButton.setOnClickListener {
            if(Timer.secondsTens > 0)
            {
                Timer.secondsTens--
                tensSecondsTV.text = Timer.secondsTens.toString()
            }
            else
            {
                if(Timer.minutes > 0 || Timer.minutesTens > 0)
                {
                    Timer.secondsTens = 5
                    minutesMinusButton.performClick()
                    tensSecondsTV.text = Timer.secondsTens.toString()
                }
            }
        }

        //Sekundy - jedności

        val secondsPlusButton = view.findViewById<Button>(R.id.ButtonSecondsPlus)
        val secondsMinusButton = view.findViewById<Button>(R.id.ButtonSecondsMinus)

        secondsPlusButton.setOnClickListener {
            if(Timer.seconds < 9)
            {
                Timer.seconds++
                secondsTV.text = Timer.seconds.toString()
            }
            else
            {
                Timer.seconds = 0
                secondsTensPlusButton.performClick()
                secondsTV.text = Timer.seconds.toString()
            }
        }

        secondsMinusButton.setOnClickListener {
            if(Timer.seconds > 0)
            {
                Timer.seconds--
                secondsTV.text = Timer.seconds.toString()
            }
            else
            {
                if(Timer.secondsTens > 0 || Timer.minutes > 0 || Timer.minutesTens > 0)
                {
                    Timer.seconds = 9
                    secondsTensMinusButton.performClick()
                    secondsTV.text = Timer.seconds.toString()
                }
            }
        }

    }

}