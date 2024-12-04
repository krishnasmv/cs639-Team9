package com.example.wecare

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ExpandableListView

class Anemia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anemia)

        val expandableListView = findViewById<ExpandableListView>(R.id.expandableListView)

        // Data for the ExpandableListView
        val listGroupTitles = listOf(
            "Iron-Deficiency Anemia",
            "Pernicious Anemia"
        )

        val listChildData = hashMapOf(
            listGroupTitles[0] to listOf(
                Pair("Causes", "Iron deficiency"),
                Pair("Foods", "Red meat, poultry, fish, lentils, beans, tofu, spinach, fortified cereals, pumpkin seeds")
            ),
            listGroupTitles[1] to listOf(
                Pair("Causes", "Vitamin B12 deficiency"),
                Pair("Foods", "Animal products (meat, poultry, fish, eggs, dairy), fortified cereals, nutritional yeast, fortified plant milk")
        )
        )

        // Set the adapter
        val adapter = CustomExpandableListAdapter(this, listGroupTitles, listChildData)
        expandableListView.setAdapter(adapter)
    }
}
