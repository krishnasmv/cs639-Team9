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
        val sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("username","").toString();
        Toast.makeText(applicationContext,"welcome "+username, Toast.LENGTH_SHORT).show();

        val exit: CardView = findViewById(R.id.generalsymptoms)
        exit.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            startActivity(Intent(this, GeneralSymptoms::class.java))
        }

        val skinandhair: CardView = findViewById(R.id.skinandhair)
        skinandhair.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            startActivity(Intent(this, SkinandHair::class.java))
        }

        val eyes: CardView = findViewById(R.id.eyes)
        eyes.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            startActivity(Intent(this, Eyes::class.java))
        }

        val bonejoint: CardView = findViewById(R.id.bonesAndJoint)
        bonejoint.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            startActivity(Intent(this, BoneMuscleJointHealth::class.java))
        }

        val bloodcirculationcard: CardView = findViewById(R.id.bloodCirculation)
        bloodcirculationcard.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            startActivity(Intent(this, bloodCirulation::class.java))
        }

        val nervoussystemcard: CardView = findViewById(R.id.nervousSystem)
        nervoussystemcard.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            startActivity(Intent(this, NervousSystem::class.java))
        }

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomnav)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> { startActivity(intent) // or your desired activity
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
            }
        }

    }
}
