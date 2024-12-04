package com.example.wecare

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Context
import android.content.Intent

import android.widget.Toast
import androidx.cardview.widget.CardView

class Eyes : AppCompatActivity() {
    private lateinit var binding: GeneralSymptoms
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_eyes);
//        val sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
//        val username = sharedPreferences.getString("username","").toString();
//        Toast.makeText(applicationContext,"welcome "+username, Toast.LENGTH_SHORT).show();

        val visioncard: CardView = findViewById(R.id.vision)
        visioncard.setOnClickListener {
            startActivity(Intent(this, Vision::class.java))
        }

        val eyestructcard: CardView = findViewById(R.id.eyestructure)
            eyestructcard.setOnClickListener {
            startActivity(Intent(this, EyeStructure::class.java))
        }
    }
}