package com.example.wecare

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ExpandableListView

class MuscleHealth : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_muscle_health)

        val expandableListView = findViewById<ExpandableListView>(R.id.expandableListView)

        // Data for the ExpandableListView
        val listGroupTitles = listOf(
            "Muscle Cramps",
            "Dry or Brittle Hair"
        )

        val listChildData = hashMapOf(
            listGroupTitles[0] to listOf(
                Pair("Causes", "Magnesium, Potassium deficiency"),
                Pair("Foods", "Bananas, avocados, spinach, sweet potatoes, beans, nuts, seeds, whole grains")
            ),
            listGroupTitles[1] to listOf(
                Pair("Causes", "Protein, Vitamin D deficiency"),
                Pair("Foods", "Lean meats, fish, eggs, dairy products, legumes, tofu, fortified cereals")
        )
        )

        // Set the adapter
        val adapter = CustomExpandableListAdapter(this, listGroupTitles, listChildData)
        expandableListView.setAdapter(adapter)
    }
}
