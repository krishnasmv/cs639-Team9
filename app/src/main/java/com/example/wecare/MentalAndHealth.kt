package com.example.wecare

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ExpandableListView
import android.content.Intent
import com.google.android.material.bottomnavigation.BottomNavigationView

class MentalAndHealth : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mental_and_health)

        val expandableListView = findViewById<ExpandableListView>(R.id.expandableListView)

        // Data for the ExpandableListView
        val listGroupTitles = listOf(
            "Depression or Anxiety",
            "Memory Loss or Brain Fog",
            "Irritability or Mood Swings"
        )

        val listChildData = hashMapOf(
            listGroupTitles[0] to listOf(
                Pair("Causes", "Vitamin D, B Vitamins, Omega-3 Fatty Acids, or Magnesium deficiency"),
                Pair("Foods", "Fatty fish, egg yolks, fortified dairy products, leafy greens, nuts, seeds, dark chocolate, avocados")

                ),
            listGroupTitles[1] to listOf(
                Pair("Causes", "Vitamin B12, Iron, or Omega-3 Fatty Acids deficiency"),
                Pair("Foods", "Red meat, fish, eggs, dairy, spinach, lentils, walnuts, flaxseeds")
                ),
            listGroupTitles[2] to listOf(
                Pair("Causes", "Vitamin B6 or Iron deficiency"),
                Pair("Foods", "Bananas, poultry, potatoes, fish, fortified cereals, red meat, beans, leafy greens")
            )
        )

        // Set the adapter
        val adapter = CustomExpandableListAdapter(this, listGroupTitles, listChildData)
        expandableListView.setAdapter(adapter)
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
