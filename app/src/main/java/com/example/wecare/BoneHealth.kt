package com.example.wecare

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ExpandableListView

class BoneHealth : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bone_health)

        val expandableListView = findViewById<ExpandableListView>(R.id.expandableListView)

        // Data for the ExpandableListView
        val listGroupTitles = listOf(
            "Soft or Brittle Bones",
            "Osteoporosis"
        )

        val listChildData = hashMapOf(
            listGroupTitles[0] to listOf(
                Pair("Causes", "Vitamin D, Calcium, Phosphorus deficiency"),
                Pair("Foods", "Dairy products, fortified plant milk, leafy greens (kale, spinach), fish (salmon, sardines), eggs, tofu")
            ),
            listGroupTitles[1] to listOf(
                Pair("Causes", "Calcium, Vitamin D deficiency"),
                Pair("Foods", "Dairy products, fortified cereals, leafy greens (collard greens, bok choy), fish (salmon, mackerel), egg yolks")
        )
        )

        // Set the adapter
        val adapter = CustomExpandableListAdapter(this, listGroupTitles, listChildData)
        expandableListView.setAdapter(adapter)
    }
}
