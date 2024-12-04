package com.example.wecare

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ExpandableListView

class CognitiveImpairment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cognitive_impairment)

        val expandableListView = findViewById<ExpandableListView>(R.id.expandableListView)

        // Data for the ExpandableListView
        val listGroupTitles = listOf(
            "Memory Loss or Confusion",
            "Mood Disorders (Depression, Irritability)"
        )

        val listChildData = hashMapOf(
            listGroupTitles[0] to listOf(
                Pair("Causes", "B Vitamins, Omega-3 deficiency"),
                Pair("Foods", "Fatty fish (salmon, mackerel, sardines), eggs, leafy greens (spinach, kale), fortified cereals, nuts, seeds, legumes")
            ),
            listGroupTitles[1] to listOf(
                Pair("Causes", "Vitamin D, B6 deficiency"),
                Pair("Foods", "Fatty fish (salmon, tuna), eggs, fortified plant milk, leafy greens (spinach, kale), bananas, potatoes, poultry")
            )
        )

        // Set the adapter
        val adapter = CustomExpandableListAdapter(this, listGroupTitles, listChildData)
        expandableListView.setAdapter(adapter)
    }
}
