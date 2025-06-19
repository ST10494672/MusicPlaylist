//ST10494672 Jordan Knipe IMAD
package com.example.playlistapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import vcmsa.ci.musicplaylist.R

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // References to UI elements
        val etTitle = findViewById<EditText>(R.id.etTitle)
        val etArtist = findViewById<EditText>(R.id.etArtist)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val etComment = findViewById<EditText>(R.id.etComment)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val tvMessage = findViewById<TextView>(R.id.tvMessage)

        btnSave.setOnClickListener {
            // Get input values
            val title = etTitle.text.toString().trim()
            val artist = etArtist.text.toString().trim()
            val rating = ratingBar.rating
            val comment = etComment.text.toString().trim()

            // Validate required field
            if (title.isEmpty()) {
                etTitle.error = "Title is required"
                return@setOnClickListener
            }
            // Set up start button click listener
            val startButton = findViewById<Button>(R.id.btnSave)
            startButton.setOnClickListener {

                // Launch the quiz activity when start is clicked
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

                // Display success message
                tvMessage.text = """
                Saved Playlist:
                Title: $title
                Artist: $artist
                Rating: $rating
                Comment: $comment
            """.trimIndent()
            }
        }
    }
}
