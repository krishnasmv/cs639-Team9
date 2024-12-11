package com.example.wecare

import android.content.Context

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import com.google.android.material.bottomnavigation.BottomNavigationView

class GeneralSymptoms : AppCompatActivity() {
    private lateinit var binding: GeneralSymptoms
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_general_symptoms);
//        val sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
//        val username = sharedPreferences.getString("username","").toString();
//        Toast.makeText(applicationContext,"welcome "+username, Toast.LENGTH_SHORT).show();

        val energy: CardView = findViewById(R.id.energyAndVitality)
        energy.setOnClickListener {
            startActivity(Intent(this, EnergyVitality::class.java))
        }

        val immuneSystem: CardView = findViewById(R.id.immunesystem)
        immuneSystem.setOnClickListener {
            startActivity(Intent(this, ImmuneSystemHealth::class.java))
        }

        val mentalandhealth: CardView = findViewById(R.id.mentalHealth)
        mentalandhealth.setOnClickListener {
            startActivity(Intent(this, MentalAndHealth::class.java))
        }

        val digestivehealth: CardView = findViewById(R.id.digestiveAndMetalbolic)
        digestivehealth.setOnClickListener {
            startActivity(Intent(this, DigestiveAndMetabolicHealth::class.java))
        }

        val growthhealth: CardView = findViewById(R.id.growthAndDevelopment)
        growthhealth.setOnClickListener {
            startActivity(Intent(this, GrowthandDevelopment::class.java))
        }

        val cardiohealth: CardView = findViewById(R.id.cardiovascularAndMuscular)
        cardiohealth.setOnClickListener {
            startActivity(Intent(this, Cardiovascularhealth::class.java))
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