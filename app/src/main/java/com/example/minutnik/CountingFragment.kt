package com.example.minutnik

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import java.sql.Time

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CountingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CountingFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_counting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.ButtonCounterMinutesPlus).isEnabled = false
        view.findViewById<Button>(R.id.ButtonCounterSecondsPlus).isEnabled = false
        view.findViewById<Button>(R.id.ButtonCounterMinutesMinus).isEnabled = false
        view.findViewById<Button>(R.id.ButtonCounterSecondsMinus).isEnabled = false

        view.findViewById<Button>(R.id.ButtonCounterTensMinutesPlus).isEnabled = false
        view.findViewById<Button>(R.id.ButtonCounterTensSecondsPlus).isEnabled = false
        view.findViewById<Button>(R.id.ButtonCounterTensMinutesMinus).isEnabled = false
        view.findViewById<Button>(R.id.ButtonCounterTensSecondsMinus).isEnabled = false

        view.findViewById<TextView>(R.id.LinearLayoutCounterTensMinutesText).text = Timer.minutesTens.toString()
        view.findViewById<TextView>(R.id.LinearLayoutCounterMinutesText).text = Timer.minutes.toString()
        view.findViewById<TextView>(R.id.LinearLayoutCounterTensSecondsText).text = Timer.secondsTens.toString()
        view.findViewById<TextView>(R.id.LinearLayoutCounterSecondsText).text = Timer.seconds.toString()

        view.findViewById<Button>(R.id.ButtonCounterSecondsMinus).setOnClickListener {
            if(Timer.seconds > 0)
            {
                Timer.seconds--
                view.findViewById<TextView>(R.id.LinearLayoutCounterSecondsText).text = Timer.seconds.toString()
            }
            else if(Timer.secondsTens > 0)
            {
                Timer.seconds = 9
                Timer.secondsTens--
                view.findViewById<TextView>(R.id.LinearLayoutCounterTensSecondsText).text = Timer.secondsTens.toString()
                view.findViewById<TextView>(R.id.LinearLayoutCounterSecondsText).text = Timer.seconds.toString()
            }
            else if(Timer.minutes > 0)
            {
                Timer.seconds = 9
                Timer.secondsTens = 5
                Timer.minutes--
                view.findViewById<TextView>(R.id.LinearLayoutCounterMinutesText).text = Timer.minutes.toString()
                view.findViewById<TextView>(R.id.LinearLayoutCounterTensSecondsText).text = Timer.secondsTens.toString()
                view.findViewById<TextView>(R.id.LinearLayoutCounterSecondsText).text = Timer.seconds.toString()
            }
            else if(Timer.minutesTens > 0)
            {
                Timer.seconds = 9
                Timer.secondsTens = 5
                Timer.minutes = 9
                Timer.minutesTens--
                view.findViewById<TextView>(R.id.LinearLayoutCounterTensMinutesText).text = Timer.minutesTens.toString()
                view.findViewById<TextView>(R.id.LinearLayoutCounterMinutesText).text = Timer.minutes.toString()
                view.findViewById<TextView>(R.id.LinearLayoutCounterTensSecondsText).text = Timer.secondsTens.toString()
                view.findViewById<TextView>(R.id.LinearLayoutCounterSecondsText).text = Timer.seconds.toString()
            }
        }

        Timer.CalculateTotalMiliSecs()
        Timer.Start(view.findViewById<Button>(R.id.ButtonCounterSecondsMinus), activity?.findViewById<Button>(R.id.ButtonStop))

    }
}