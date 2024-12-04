package com.example.wecare

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ExpandableListView


class skin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skin)

        val expandableListView = findViewById<ExpandableListView>(R.id.expandableListView)

        // Data for the ExpandableListView
        val listGroupTitles = listOf(
            "Dry or Flaky Skin",
            "Dermatitis",
            "Pale Skin"
        )

        val listChildData = hashMapOf(
            listGroupTitles[0] to listOf(
                Pair("Causes", "Vitamin A, E deficiency"),
                Pair("Foods", "Carrots, sweet potatoes, almonds, sunflower seeds, spinach, avocados")
            ),
            listGroupTitles[1] to listOf(
                Pair("Causes", "B Vitamins (B2, B3, B6) deficiency"),
                Pair("Foods", "Eggs, dairy products, fish, chicken, leafy greens, whole grains")
                ),
            listGroupTitles[2] to listOf(
                Pair("Causes", "Iron, Vitamin B12 deficiency"),
                Pair("Foods", "Red meat, fish, poultry, fortified cereals, beans, dairy products")
            )
        )

        // Set the adapter
        val adapter = CustomExpandableListAdapter(this, listGroupTitles, listChildData)
        expandableListView.setAdapter(adapter)
    }
}
