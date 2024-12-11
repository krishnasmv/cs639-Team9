package com.example.wecare

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wecare.databinding.ActivitySigninBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.content.SharedPreferences as SharedPreferences

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: HomeActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        val intent = Intent(this, HealthyFoodActivity::class.java)
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_home);

        val exit: CardView = findViewById(R.id.generalsymptoms)
        exit.setOnClickListener {
            startActivity(Intent(this, GeneralSymptoms::class.java))
        }

        val skinandhair: CardView = findViewById(R.id.skinandhair)
        skinandhair.setOnClickListener {
            startActivity(Intent(this, SkinandHair::class.java))
        }

        val eyes: CardView = findViewById(R.id.eyes)
        eyes.setOnClickListener {
            startActivity(Intent(this, Eyes::class.java))
        }

        val bonejoint: CardView = findViewById(R.id.bonesAndJoint)
        bonejoint.setOnClickListener {
            startActivity(Intent(this, BoneMuscleJointHealth::class.java))
        }

        val bloodcirculationcard: CardView = findViewById(R.id.bloodCirculation)
        bloodcirculationcard.setOnClickListener {

            startActivity(Intent(this, bloodCirulation::class.java))
        }

        val nervoussystemcard: CardView = findViewById(R.id.nervousSystem)
        nervoussystemcard.setOnClickListener {
            startActivity(Intent(this, NervousSystem::class.java))
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
