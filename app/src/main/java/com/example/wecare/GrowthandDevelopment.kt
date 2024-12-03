package com.example.wecare

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ExpandableListView

class GrowthandDevelopment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_growthand_development)

        val expandableListView = findViewById<ExpandableListView>(R.id.expandableListView)

        // Data for the ExpandableListView
        val listGroupTitles = listOf(
            "Stunted Growth (Children)",
            "Hormonal Imbalances",
            "Delayed Motor Development"
        )

        val listChildData = hashMapOf(
            listGroupTitles[0] to listOf(
                Pair("Causes", "Protein, Iron, or Zinc deficiency"),
                Pair("Foods", "Eggs, dairy products, lean meats, beans, lentils, spinach, nuts, seeds")
            ),
            listGroupTitles[1] to listOf(
                Pair("Causes", "Iodine (thyroid function), Vitamin D, or Essential Fatty Acid deficiency"),
                Pair("Foods", "Seafood, dairy, fortified salt (for iodine), fatty fish, egg yolks, avocados, flaxseeds")
            ),
            listGroupTitles[2] to listOf(
                Pair("Causes", "Iodine or Iron deficiency"),
                Pair("Foods", "Seaweed, fish, dairy, red meat, poultry, legumes, fortified cereals")
            )
        )

        // Set the adapter
        val adapter = CustomExpandableListAdapter(this, listGroupTitles, listChildData)
        expandableListView.setAdapter(adapter)
    }
}
