package com.example.wecare

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ExpandableListView

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
                Pair("Foods", "Fatty fish (salmon, mackerel), flaxseeds, walnuts, liver, carrots, leafy greens")
            ),
            listGroupTitles[1] to listOf(
                Pair("Causes", "Severe Vitamin A deficiency"),
                Pair("Foods", "Liver, sweet potatoes, carrots, dark leafy greens, red bell peppers"
                )
            )
        )

        // Set the adapter
        val adapter = CustomExpandableListAdapter(this, listGroupTitles, listChildData)
        expandableListView.setAdapter(adapter)
    }
}
