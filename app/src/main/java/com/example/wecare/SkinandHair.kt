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


class SkinandHair : AppCompatActivity() {
    private lateinit var binding: GeneralSymptoms
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_skinand_hair);
//        val sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
//        val username = sharedPreferences.getString("username","").toString();
//        Toast.makeText(applicationContext,"welcome "+username, Toast.LENGTH_SHORT).show();

        val skincard: CardView = findViewById(R.id.skin)
        skincard.setOnClickListener {
            startActivity(Intent(this, skin::class.java))
        }

        val haircard: CardView = findViewById(R.id.hair)
            haircard.setOnClickListener {
            startActivity(Intent(this, Hair::class.java))
        }

        val nailscard: CardView = findViewById(R.id.nails)
            nailscard.setOnClickListener {
            startActivity(Intent(this, Nails::class.java))
        }

    }
}