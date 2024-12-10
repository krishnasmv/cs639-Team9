package com.example.wecare

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.os.Handler


class Bottomnavigation : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_bottomnavigation)


        private lateinit var imageView: ImageView
        private val images = arrayOf(
            R.drawable.image1, // Replace with your image resource names
            R.drawable.image2,
            R.drawable.image3
        )
        private var currentIndex = 0
        private val handler = Handler()
        private val runnable = object : Runnable {
            override fun run() {
                // Update the ImageView with the next image
                imageView.setImageResource(images[currentIndex])
                currentIndex = (currentIndex + 1) % images.size // Loop back to the first image
                handler.postDelayed(this, 2000) // Repeat every 2 seconds
            }
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_bottomnavigation)

            imageView = findViewById(R.id.imageView)

            // Start the image switching
            handler.post(runnable)
        }

        override fun onDestroy() {
            super.onDestroy()
            handler.removeCallbacks(runnable) // Stop the handler when the activity is destroyed
        }


//    }
}