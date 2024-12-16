package com.example.wecare

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wecare.databinding.ActivityProfilePageBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import android.content.Intent
import com.google.android.material.bottomnavigation.BottomNavigationView
class ProfilePage : AppCompatActivity() {
    private lateinit var user: FirebaseAuth
    private lateinit var binding: ActivityProfilePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilePageBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile_page)
        user = FirebaseAuth.getInstance()
        val exit: LinearLayout = findViewById(R.id.logout)
        exit.setOnClickListener {
            user.signOut()
            startActivity(Intent(this, MainActivity::class.java))

        }

//        binding.logout.setOnClickListener({
//            user.signOut()
//            startActivity(Intent(this, SigninActivity::class.java))
//        })
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