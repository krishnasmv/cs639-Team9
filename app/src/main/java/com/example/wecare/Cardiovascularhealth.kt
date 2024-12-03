package com.example.wecare

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ExpandableListView

class Cardiovascularhealth : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cardiovascularhealth)

        val expandableListView = findViewById<ExpandableListView>(R.id.expandableListView)

        // Data for the ExpandableListView
        val listGroupTitles = listOf(
            "Heart Issues (Palpitations, Arrhythmias)",
            "High Blood Pressure",
            "Bone Health (Osteoporosis or Brittle Bones)"
        )

        val listChildData = hashMapOf(
            listGroupTitles[0] to listOf(
                Pair("Causes", "Potassium, Magnesium, or Calcium deficiency"),
                Pair("Foods", "Bananas, avocados, leafy greens, nuts, seeds, dairy products, fish")
            ),
            listGroupTitles[1] to listOf(
                Pair("Causes", "Potassium or Magnesium deficiency"),
                Pair("Foods", "Leafy greens, sweet potatoes, beans, bananas, avocados, almonds, whole grains")
            ),
            listGroupTitles[2] to listOf(
                Pair("Causes", "Calcium, Vitamin D, or Phosphorus deficiency"),
                Pair("Foods", "Dairy products, fortified cereals, leafy greens, fatty fish, egg yolks, nuts, seeds")
            )
        )

        // Set the adapter
        val adapter = CustomExpandableListAdapter(this, listGroupTitles, listChildData)
        expandableListView.setAdapter(adapter)
    }
}
