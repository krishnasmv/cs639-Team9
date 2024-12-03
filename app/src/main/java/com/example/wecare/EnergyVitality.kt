package com.example.wecare

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ExpandableListView

class EnergyVitality : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_energy_vitality)

        val expandableListView = findViewById<ExpandableListView>(R.id.expandableListView)

        // Data for the ExpandableListView
        val listGroupTitles = listOf(
            "Fatigue and Weakness",
            "Muscle Weakness or Cramps",
            "Slow Metabolism"
        )

        val listChildData = hashMapOf(
            listGroupTitles[0] to listOf(
                Pair("Causes", "Iron, Vitamin B12, Folate, or Vitamin D deficiency"),
                Pair("Foods", "Spinach, eggs, citrus fruits, sunlight exposure")
            ),
            listGroupTitles[1] to listOf(
                Pair("Causes", "Protein, Magnesium, or Potassium deficiency"),
                Pair("Foods", "Chicken, nuts, bananas, spinach")
            ),
            listGroupTitles[2] to listOf(
                Pair("Causes", "Iodine deficiency (affects thyroid function)"),
                Pair("Foods", "Iodized salt, fish, dairy products")
            )
        )

        // Set the adapter
        val adapter = CustomExpandableListAdapter(this, listGroupTitles, listChildData)
        expandableListView.setAdapter(adapter)
    }
}
