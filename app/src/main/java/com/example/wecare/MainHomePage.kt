package com.example.wecare

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.content.Intent
import com.google.android.material.bottomnavigation.BottomNavigationView

@Suppress("DEPRECATION")
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
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomnav)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> { startActivity(Intent(this, MainHomePage::class.java)) // or your desired activity
                    true
                }
                R.id.learn ->{ startActivity(Intent(this, HealthyFoodActivity::class.java)) // or your desired activity
                    true
                }
                R.id.health->{ startActivity(Intent(this, HomeActivity::class.java)) // or your desired activity
                    true
                }
                R.id.doctor -> {
                    startActivity(Intent(this, MainDoctor::class.java))
                    true
                }
                R.id.profile -> {
                    startActivity(Intent(this, ProfilePage::class.java))
                    true
                }
//                R.id.navigation_other -> {
//                    // Handle other item click
//                    startActivity(Intent(this, OtherActivity::class.java)) // replace with your desired activity
//                    true
//                }
                // Add more cases for other menu items as needed
                else -> false
            }}
    }
}
