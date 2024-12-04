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

class NervousSystem : AppCompatActivity() {
    private lateinit var binding: GeneralSymptoms
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_nervous_system);
//        val sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
//        val username = sharedPreferences.getString("username","").toString();
//        Toast.makeText(applicationContext,"welcome "+username, Toast.LENGTH_SHORT).show();

        val neurocard: CardView = findViewById(R.id.neurological)
        neurocard.setOnClickListener {
            startActivity(Intent(this, Neurological::class.java))
        }

        val cognitivecard: CardView = findViewById(R.id.cognitive)
        cognitivecard.setOnClickListener {
            startActivity(Intent(this, CognitiveImpairment::class.java))
        }

    }
}