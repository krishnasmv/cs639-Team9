package com.example.wecare

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ExpandableListView

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
    }
}
