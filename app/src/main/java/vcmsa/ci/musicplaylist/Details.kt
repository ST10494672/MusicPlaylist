package com.example.playlistapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import vcmsa.ci.musicplaylist.R

class SecondActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val tvAverageRating = findViewById<TextView>(R.id.tvAverageRating)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val btnBackToMain = findViewById<Button>(R.id.btnBackToMain)
        val btnExitApp = findViewById<Button>(R.id.btnExitApp)

        // Get playlist from intent
        val playlist =
            intent.getSerializableExtra("playlist") as? ArrayList<Map<String, Any>> ?: arrayListOf()

        // Calculate average rating
        btnCalculate.setOnClickListener {
            var total = 0.0
            for (song in playlist) {
                val rating = song["rating"] as? Double ?: 0.0
                total += rating
            }
            val average = if (playlist.isNotEmpty()) total / playlist.size else 0.0
            tvAverageRating.text = "Average Rating: ${"%.2f".format(average)}"
        }

        // Return to main screen
        btnBackToMain.setOnClickListener {
            finish()
        }

        // Exit the app
        btnExitApp.setOnClickListener {
            finishAffinity()
        }// Closes all activities
    }
}