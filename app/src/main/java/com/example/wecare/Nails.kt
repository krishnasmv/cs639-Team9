package com.example.wecare

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ExpandableListView

class Nails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nails)

        val expandableListView = findViewById<ExpandableListView>(R.id.expandableListView)

        // Data for the ExpandableListView
        val listGroupTitles = listOf(
            "Hair Loss",
            "Dry or Brittle Hair"
        )

        val listChildData = hashMapOf(
            listGroupTitles[0] to listOf(
                Pair("Causes", "Iron, Zinc deficiency"),
                Pair("Foods", "Red meat, beans, lentils, nuts, seeds, poultry, dark leafy greens")
            ),
            listGroupTitles[1] to listOf(
                Pair("Causes", "Zinc deficiency"),
                Pair("Foods", "Shellfish, red meat, legumes, nuts, seeds, dairy")
        )
        )

        // Set the adapter
        val adapter = CustomExpandableListAdapter(this, listGroupTitles, listChildData)
        expandableListView.setAdapter(adapter)
    }
}
