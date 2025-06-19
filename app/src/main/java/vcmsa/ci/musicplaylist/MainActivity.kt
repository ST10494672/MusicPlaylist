//ST10494672 Jordan Knipe IMAD
package com.example.playlistapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import vcmsa.ci.musicplaylist.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            Toast.makeText(this, "MainActivity Loaded", Toast.LENGTH_SHORT).show()
        }


        // Initialize Views
        val etTitle = findViewById<EditText>(R.id.etTitle)
        val etArtist = findViewById<EditText>(R.id.etArtist)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val etComment = findViewById<EditText>(R.id.etComment)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnGoToSecond = findViewById<Button>(R.id.btnGoToSecond)
        val tvMessage = findViewById<TextView>(R.id.tvMessage)

        // Save Playlist Data
        btnSave.setOnClickListener {
            val title = etTitle.text.toString().trim()
            val artist = etArtist.text.toString().trim()
            val rating = ratingBar.rating.toDouble()
            val comment = etComment.text.toString().trim()

            if (title.isEmpty()) {
                etTitle.error = "Title is required"
                return@setOnClickListener
            }

            // Show success message
            tvMessage.text = "Saved:\nTitle: $title\nArtist: $artist\nRating: $rating\nComment: $comment"

            // Store in a list or pass to SecondActivity
            val playlistItem = mapOf(
                "title" to title,
                "artist" to artist,
                "rating" to rating,
                "comment" to comment
            )
        }

        // Navigate to Second Screen
        btnGoToSecond.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}
