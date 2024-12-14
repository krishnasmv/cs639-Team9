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
import android.widget.ImageView
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
            "Eat well: Eat a balanced diet of nourishing, real foods that are unprocessed and have few ingredients. Limit processed foods and sugar.",
            "Stay hydrated: Drink plenty of water, about 8 glasses a day. Water helps your body in many ways, including regulating your temperature, pumping blood, and promoting regular bowel movements.",
            "Exercise regularly: Physical activity can help reduce stress and improve your health.",
            "Get enough sleep: Poor sleep can disrupt your appetite and hormones, and reduce your mental and physical performance.",
            "Limit alcohol: There is no safe level of alcohol consumption. Excessive alcohol can lead to liver damage, cancer, heart disease, and mental illness."
        )
        healthTipText.text = tips.random()

        // Button: Navigate to Explore Symptoms
        exploreSymptomsButton.setOnClickListener {
            val intent = Intent(this, HealthAPIActivity::class.java)
            startActivity(intent)
        }
        val featured: ImageView = findViewById(R.id.symptomOfTheDayImage)
        featured.setOnClickListener() {
            val intent = Intent(this, FeaturedItems::class.java)
            startActivity(intent)
        }
        val featured2: ImageView = findViewById(R.id.foodHighlightImage)
        featured2.setOnClickListener() {
            val intent = Intent(this, FeaturedItems::class.java)
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
