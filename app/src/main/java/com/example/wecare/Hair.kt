package com.example.wecare

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ExpandableListView

class Hair : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hair)

        val expandableListView = findViewById<ExpandableListView>(R.id.expandableListView)

        // Data for the ExpandableListView
        val listGroupTitles = listOf(
            "Hair Loss",
            "Dry or Brittle Hair"
        )

        val listChildData = hashMapOf(
            listGroupTitles[0] to listOf(
                Pair("Causes", "Protein, Iron, Zinc, Biotin deficiency"),
                Pair("Foods", "Eggs, fish, nuts, seeds, lean meats, legumes, spinach")
            ),
            listGroupTitles[1] to listOf(
                Pair("Causes", "Essential fatty acid, Vitamin E deficiency"),
                Pair("Foods", "Fatty fish, avocados, nuts, seeds, vegetable oils")
        )
        )

        // Set the adapter
        val adapter = CustomExpandableListAdapter(this, listGroupTitles, listChildData)
        expandableListView.setAdapter(adapter)
    }
}
