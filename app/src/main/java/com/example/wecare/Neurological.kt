package com.example.wecare

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ExpandableListView

class Neurological : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_neurological)

        val expandableListView = findViewById<ExpandableListView>(R.id.expandableListView)

        // Data for the ExpandableListView
        val listGroupTitles = listOf(
            "Neuropathy (Numbness, Tingling)",
            "Seizures"
        )

        val listChildData = hashMapOf(
            listGroupTitles[0] to listOf(
                Pair("Causes", "Vitamin B1, B6, B12 deficiency"),
                Pair("Foods", "Whole grains, beans, legumes, meat, poultry, fish, dairy products, eggs, fortified cereals, bananas")
            ),
            listGroupTitles[1] to listOf(
                Pair("Causes", "Magnesium deficiency"),
                Pair("Foods", "Nuts, seeds, legumes, whole grains, leafy greens (spinach, kale), bananas, avocado, fish")
            )
        )

        // Set the adapter
        val adapter = CustomExpandableListAdapter(this, listGroupTitles, listChildData)
        expandableListView.setAdapter(adapter)
    }
}
