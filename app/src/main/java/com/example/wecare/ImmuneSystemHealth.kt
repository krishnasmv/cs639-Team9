package com.example.wecare

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ExpandableListView

class ImmuneSystemHealth : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_immune_system_health)

        val expandableListView = findViewById<ExpandableListView>(R.id.expandableListView)

        // Data for the ExpandableListView
        val listGroupTitles = listOf(
            "Frequent Infections",
            "Slow Wound Healing",
            "Inflammation or Autoimmune Issues"
        )

        val listChildData = hashMapOf(
            listGroupTitles[0] to listOf(
                Pair("Causes", "Vitamin C, Zinc, or Iron deficiency"),
                Pair("Foods", "Citrus fruits, bell peppers, strawberries, meat, shellfish, beans, nuts, spinach, fortified cereals")
            ),
            listGroupTitles[1] to listOf(
                Pair("Causes", "Protein, Vitamin C, or Zinc deficiency"),
                Pair("Foods", "Eggs, fish, chicken, legumes, citrus fruits, dairy products, meat, lentils")
                ),
            listGroupTitles[2] to listOf(
                Pair("Causes", "Omega-3 Fatty Acid or Vitamin D deficiency"),
                Pair("Foods", "Fatty fish, flaxseeds, chia seeds, walnuts, avocados, egg yolks, fortified foods, mushrooms")
            )
        )

        // Set the adapter
        val adapter = CustomExpandableListAdapter(this, listGroupTitles, listChildData)
        expandableListView.setAdapter(adapter)
    }
}
