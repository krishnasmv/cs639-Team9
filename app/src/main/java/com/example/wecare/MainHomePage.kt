package com.example.wecare

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainHomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home_page)

        // Initialize Views
        val searchSymptoms = findViewById<EditText>(R.id.searchSymptoms)
        val exploreSymptomsButton = findViewById<Button>(R.id.exploreSymptomsButton)
        val foodSuggestionsButton = findViewById<Button>(R.id.foodSuggestionsButton)
        val healthTipText = findViewById<TextView>(R.id.healthTipText)

        // Example: Dynamic Health Tip
        val tips = listOf(
            "Eat more greens for better digestion.",
            "Stay hydrated – drink at least 8 glasses of water daily!",
            "Exercise regularly to boost your energy."
        )
        healthTipText.text = tips.random()

        // Button: Navigate to Explore Symptoms
        exploreSymptomsButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        // Button: Navigate to Food Suggestions
        foodSuggestionsButton.setOnClickListener {
            val intent = Intent(this, HealthyFoodActivity::class.java)
            startActivity(intent)
        }
    }
}
