package com.example.wecare

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ExpandableListView
import android.content.Intent
import com.google.android.material.bottomnavigation.BottomNavigationView

class EyeStructure : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eye_structure)

        val expandableListView = findViewById<ExpandableListView>(R.id.expandableListView)

        // Data for the ExpandableListView
        val listGroupTitles = listOf(
            "Dry Eyes",
            "Corneal Ulceration"
        )

        val listChildData = hashMapOf(
            listGroupTitles[0] to listOf(
                Pair("Causes", "Vitamin A, Omega-3 deficiency"),
                Pair(
                    "Foods",
                    "Fatty fish (salmon, mackerel), flaxseeds, walnuts, liver, carrots, leafy greens"
                )
            ),
            listGroupTitles[1] to listOf(
                Pair("Causes", "Severe Vitamin A deficiency"),
                Pair(
                    "Foods", "Liver, sweet potatoes, carrots, dark leafy greens, red bell peppers"
                )
            )
        )

        // Set the adapter
        val adapter = CustomExpandableListAdapter(this, listGroupTitles, listChildData)
        expandableListView.setAdapter(adapter)
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomnav)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    startActivity(
                        Intent(
                            this,
                            MainHomePage::class.java
                        )
                    ) // or your desired activity
                    true
                }

                R.id.learn -> {
                    startActivity(
                        Intent(
                            this,
                            HealthyFoodActivity::class.java
                        )
                    ) // or your desired activity
                    true
                }

                R.id.health -> {
                    startActivity(
                        Intent(
                            this,
                            HomeActivity::class.java
                        )
                    ) // or your desired activity
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
