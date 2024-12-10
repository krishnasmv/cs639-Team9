package com.example.wecare

import Food1Fragment
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.ExpandableListView
import android.widget.ImageView
import android.widget.TextView
import com.example.wecare.R
import com.example.wecare.FragmentNavigator

class HealthyFoodActivity : AppCompatActivity() {
    // List of foods with hardcoded data
    private val foodList = listOf(
        FoodItem("Food 1", R.drawable.food1, "Description of food 1", listOf("Vitamin A", "Vitamin C", "Calcium")),
        FoodItem("Food 2", R.drawable.image1, "Description of food 2", listOf("Iron", "Fiber", "Vitamin D")),
        FoodItem("Food 3", R.drawable.image2, "Description of food 3", listOf("Magnesium", "Zinc", "Potassium"))
    )
    
    private var currentFoodIndex = 0
    
    private lateinit var imageViewFood: ImageView
    private lateinit var textViewDescription: TextView
    private lateinit var expandableListView: ExpandableListView
    private lateinit var buttonNext: Button
    private lateinit var buttonPrevious: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_healthy_food)

        // Initialize views
        imageViewFood = findViewById(R.id.imageViewFood)
        textViewDescription = findViewById(R.id.textViewDescription)
        expandableListView = findViewById(R.id.expandableListViewNutrients)
        buttonNext = findViewById(R.id.buttonNext)
        buttonPrevious = findViewById(R.id.buttonPrevious)

        // Set the first food item
        updateFoodItem()

        // Handle "Next" button click
        buttonNext.setOnClickListener {
            if (currentFoodIndex < foodList.size - 1) {
                currentFoodIndex++
                updateFoodItem()
            }
        }

        // Handle "Previous" button click
        buttonPrevious.setOnClickListener {
            if (currentFoodIndex > 0) {
                currentFoodIndex--
                updateFoodItem()
            }
        }
    }

    // Function to update the food details in the views
    private fun updateFoodItem() {
        val food = foodList[currentFoodIndex]
        
        // Update the image
        imageViewFood.setImageResource(food.imageResource)
        
        // Update the description
        textViewDescription.text = food.description
        
        // Update the ExpandableListView for nutrients
        val nutrientAdapter = NutrientExpandableListAdapter(this, food.nutrients)
        expandableListView.setAdapter(nutrientAdapter)
    }
    
    // Data class for FoodItem
    data class FoodItem(
        val name: String,
        val imageResource: Int,
        val description: String,
        val nutrients: List<String>
    )

    // Custom ExpandableListAdapter for Nutrients
    class NutrientExpandableListAdapter(
        private val context: Context,
        private val nutrients: List<String>
    ) : BaseExpandableListAdapter() {

        override fun getGroupCount(): Int {
            return 1
        }

        override fun getChildrenCount(groupPosition: Int): Int {
            return nutrients.size
        }

        override fun getGroup(groupPosition: Int): Any {
            return "Nutrients"
        }

        override fun getChild(groupPosition: Int, childPosition: Int): Any {
            return nutrients[childPosition]
        }

        override fun getGroupId(groupPosition: Int): Long {
            return groupPosition.toLong()
        }

        override fun getChildId(groupPosition: Int, childPosition: Int): Long {
            return childPosition.toLong()
        }

        override fun hasStableIds(): Boolean {
            return true
        }

        override fun getGroupView(
            groupPosition: Int,
            isExpanded: Boolean,
            convertView: View?,
            parent: ViewGroup?
        ): View {
            val view = LayoutInflater.from(context).inflate(android.R.layout.simple_expandable_list_item_1, parent, false)
            val textView = view.findViewById<TextView>(android.R.id.text1)
            textView.text = getGroup(groupPosition).toString()
            return view
        }

        override fun getChildView(
            groupPosition: Int,
            childPosition: Int,
            isLastChild: Boolean,
            convertView: View?,
            parent: ViewGroup?
        ): View {
            val view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false)
            val textView = view.findViewById<TextView>(android.R.id.text1)
            textView.text = getChild(groupPosition, childPosition).toString()
            return view
        }

        override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
            return true
        }
    }
}