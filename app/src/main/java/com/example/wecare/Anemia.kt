package com.example.wecare

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ExpandableListView
import com.google.android.material.bottomnavigation.BottomNavigationView

class Anemia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anemia)

        val expandableListView = findViewById<ExpandableListView>(R.id.expandableListView)

        // Data for the ExpandableListView
        val listGroupTitles = listOf(
            "Iron-Deficiency Anemia",
            "Pernicious Anemia"
        )

        val listChildData = hashMapOf(
            listGroupTitles[0] to listOf(
                Pair("Causes", "Iron deficiency"),
                Pair("Foods", "Red meat, poultry, fish, lentils, beans, tofu, spinach, fortified cereals, pumpkin seeds")
            ),
            listGroupTitles[1] to listOf(
                Pair("Causes", "Vitamin B12 deficiency"),
                Pair("Foods", "Animal products (meat, poultry, fish, eggs, dairy), fortified cereals, nutritional yeast, fortified plant milk")
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
