package com.example.wecare

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ExpandableListView

class DigestiveAndMetabolicHealth : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_digestive_and_metabolic_health)

        val expandableListView = findViewById<ExpandableListView>(R.id.expandableListView)

        // Data for the ExpandableListView
        val listGroupTitles = listOf(
            "Poor Digestion or Constipation",
            "Diarrhea",
            "Weight Fluctuations"
        )

        val listChildData = hashMapOf(
            listGroupTitles[0] to listOf(
                Pair("Causes", "Fiber, Magnesium, or Water deficiency"),
                Pair("Foods", "Whole grains, fruits (apples, pears), vegetables, nuts, seeds, leafy greens, legumes, plenty of water")
            ),
            listGroupTitles[1] to listOf(
                Pair("Causes", "Zinc or B Vitamins deficiency"),
                Pair("Foods", "Bananas, rice, applesauce, toast, shellfish, red meat, fortified cereals, dairy products")
            ),
            listGroupTitles[2] to listOf(
                Pair("Causes", "Protein, B Vitamins, or Essential Fatty Acids deficiency"),
                Pair("Foods", "Eggs, fish, lean meats, beans, nuts, avocados, whole grains, flaxseeds, chia seeds")
            )
        )

        // Set the adapter
        val adapter = CustomExpandableListAdapter(this, listGroupTitles, listChildData)
        expandableListView.setAdapter(adapter)
    }
}