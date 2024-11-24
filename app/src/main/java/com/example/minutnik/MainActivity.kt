package com.example.minutnik

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.trackPipAnimationHintView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    private lateinit var startButton : Button
    private lateinit var pauseButton: Button
    private lateinit var stopButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var transakcja = supportFragmentManager.beginTransaction()
        transakcja.replace(R.id.MainFragmentContainer, SetterFragment())
        transakcja.commit()

        startButton = findViewById<Button>(R.id.ButtonStart)
        pauseButton = findViewById<Button>(R.id.ButtonPause)
        stopButton = findViewById<Button>(R.id.ButtonStop)

        var currentfragment = supportFragmentManager.findFragmentById(R.id.MainFragmentContainer)

        if(currentfragment is SetterFragment)
        {
            pauseButton.isEnabled = false
            stopButton.isEnabled = false
        }


        startButton.setOnClickListener {
            var trans = supportFragmentManager.beginTransaction()
            trans.remove(SetterFragment())
            trans.replace(R.id.MainFragmentContainer ,CountingFragment())
            trans.commit()

            startButton.isEnabled = false
            pauseButton.isEnabled = true
            stopButton.isEnabled = true

        }

        pauseButton.setOnClickListener {
            var trans = supportFragmentManager.beginTransaction()
            trans.replace(R.id.MainFragmentContainer, SetterFragment())
            trans.commit()

            startButton.isEnabled = true
            pauseButton.isEnabled = false
            stopButton.isEnabled = false

            Timer.Stop()
        }

        stopButton.setOnClickListener {
            var trans = supportFragmentManager.beginTransaction()
            trans.replace(R.id.MainFragmentContainer, SetterFragment())
            trans.commit()

            Timer.seconds = 0
            Timer.secondsTens = 0
            Timer.minutes = 0
            Timer.minutesTens = 0

            startButton.isEnabled = true
            pauseButton.isEnabled = false
            stopButton.isEnabled = false

            Timer.Stop()
        }
    }
}