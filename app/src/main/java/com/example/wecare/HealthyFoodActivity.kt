package com.example.wecare

import Food1Fragment
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import android.view.Gravity
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
import android.graphics.Color
import com.google.android.material.bottomnavigation.BottomNavigationView

class HealthyFoodActivity : AppCompatActivity() {
    private val foodList = listOf(
        FoodItem("Salmon", R.drawable.salmon, "A fatty fish packed with omega-3 fatty acids, excellent for heart health and brain function.", listOf("Vitamins: Vitamin D, Vitamin B12", "Minerals: Selenium", "Other: Omega-3 Fatty Acids, Protein")),
        FoodItem("Kale", R.drawable.kale, "A highly nutritious leafy green, rich in vitamins A, K, C, and many antioxidants. Known for its anti-inflammatory properties and support for eye health.", listOf("Vitamins: Vitamin A, Vitamin K, Vitamin C", "Minerals: Calcium, Magnesium", "Other: Fiber, Antioxidants")),
        FoodItem("Spinach", R.drawable.spinach, "A leafy green vegetable, rich in iron and vitamins, particularly Vitamin K.", listOf("Vitamins: Vitamin A, Vitamin C, Vitamin K", "Minerals: Iron, Calcium", "Other: Folate")),
        FoodItem("Carrot", R.drawable.carrot, "A crunchy root vegetable known for its high beta-carotene content, which is converted into Vitamin A.", listOf("Vitamins: Vitamin A, Vitamin C", "Minerals: Potassium", "Other: Fiber, Biotin")),

        FoodItem("Almonds", R.drawable.almonds, "A nutrient-dense nut, rich in healthy fats, fiber, and vitamin E.", listOf("Vitamins: Vitamin E", "Minerals: Magnesium, Calcium", "Other: Healthy Fats (Monounsaturated), Protein")),

        FoodItem("Avocado", R.drawable.avocado, "A creamy fruit with healthy fats, perfect for heart health and skin nourishment.", listOf("Vitamins: Vitamin E, Vitamin K", "Minerals: Potassium", "Other: Healthy Fats (Monounsaturated), Fiber")),

FoodItem("Banana", R.drawable.banana, "A high-energy fruit rich in potassium, perfect for maintaining healthy muscle and nerve function.", listOf("Vitamins: Vitamin B6, Vitamin C", "Minerals: Potassium, Magnesium", "Other: Fiber")),

FoodItem("Blueberries", R.drawable.blueberry, "A small, antioxidant-rich berry that is beneficial for brain function and overall health.", listOf("Vitamins: Vitamin C, Vitamin K", "Minerals: Manganese", "Other: Antioxidants, Fiber")),

FoodItem("Sweet Potato", R.drawable.sweetpotato, "A starchy root vegetable high in beta-carotene, known for its anti-inflammatory properties.", listOf("Vitamins: Vitamin A, Vitamin C", "Minerals: Potassium", "Other: Fiber, Manganese")),

FoodItem("Greek Yogurt", R.drawable.greekyogurt, "A thick, creamy yogurt that is packed with probiotics for gut health and high in protein.", listOf("Vitamins: Vitamin B12", "Minerals: Calcium, Potassium", "Other: Protein, Probiotics")),

FoodItem("Broccoli", R.drawable.brocoli, "A cruciferous vegetable loaded with vitamins, minerals, and fiber, known for its cancer-fighting properties.", listOf("Vitamins: Vitamin C, Vitamin K", "Minerals: Folate, Potassium", "Other: Fiber")),

FoodItem("Kale", R.drawable.kale, "A highly nutritious leafy green, rich in vitamins A, K, C, and many antioxidants. Known for its anti-inflammatory properties and support for eye health.", listOf("Vitamins: Vitamin A, Vitamin K, Vitamin C", "Minerals: Calcium, Magnesium", "Other: Fiber, Antioxidants"))



    )

    private var currentFoodIndex = 0

    private lateinit var imageViewFood: ImageView
    private lateinit var textViewDescription: TextView
    private lateinit var textViewTitle: TextView
    private lateinit var expandableListView: ExpandableListView
    private lateinit var buttonNext: Button
    private lateinit var buttonPrevious: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_healthy_food)

        // Initialize views
        imageViewFood = findViewById(R.id.imageViewFood)
        textViewTitle = findViewById(R.id.textViewTitle)
        textViewDescription = findViewById(R.id.textViewDescription)
        expandableListView = findViewById(R.id.expandableListViewNutrients)
        buttonNext = findViewById(R.id.buttonNext)
        buttonPrevious = findViewById(R.id.buttonPrevious)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomnav)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> { startActivity(Intent(this, MainHomePage::class.java)) // or your desired activity
                    true
                }
                R.id.learn ->{ startActivity(Intent(this, HealthyFoodActivity::class.java)) // or your desired activity
                    true
                }
                R.id.health->{ startActivity(Intent(this, HomeActivity::class.java)) // or your desired activity
                    true
                }
                R.id.doctor -> {
                    startActivity(Intent(this, MainDoctor::class.java))
                    true
                }
                R.id.profile -> {
                    startActivity(Intent(this, ProfilePage::class.java))
                    true
                }
//                R.id.navigation_other -> {
//                    // Handle other item click
//                    startActivity(Intent(this, OtherActivity::class.java)) // replace with your desired activity
//                    true
//                }
                // Add more cases for other menu items as needed
                else -> false
            }}

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
        textViewTitle.text = food.name
        textViewDescription.text = food.description

        // Update the ExpandableListView for nutrients
        val nutrientAdapter = NutrientExpandableListAdapter(this, food.nutrients)
        expandableListView.setAdapter(nutrientAdapter)

        // Handle visibility of buttons
        buttonNext.visibility = if (currentFoodIndex == foodList.size - 1) View.GONE else View.VISIBLE
        buttonPrevious.visibility = if (currentFoodIndex == 0) View.GONE else View.VISIBLE
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

            // Set text color to black and center it
            textView.setTextColor(Color.WHITE)
//            textView.setTextColor(Color.parseColor("#000000"))
            textView.gravity = Gravity.CENTER

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

            // Set text color to black and center it
            textView.setTextColor(Color.WHITE)

            return view
        }

        override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
            return true
        }
    }
}