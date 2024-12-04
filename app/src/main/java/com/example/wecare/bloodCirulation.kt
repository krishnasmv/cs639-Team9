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

class bloodCirulation : AppCompatActivity() {
    private lateinit var binding: GeneralSymptoms
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_blood_cirulation);
//        val sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
//        val username = sharedPreferences.getString("username","").toString();
//        Toast.makeText(applicationContext,"welcome "+username, Toast.LENGTH_SHORT).show();

        val bonecard: CardView = findViewById(R.id.anemia)
        bonecard.setOnClickListener {
            startActivity(Intent(this, Anemia::class.java))
        }

        val musclecard: CardView = findViewById(R.id.bloodclot)
            musclecard.setOnClickListener {
            startActivity(Intent(this, BloodClotting::class.java))
        }

    }
}