import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.wecare.HealthyFoodActivity
import com.example.wecare.R

class Food2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_food2, container, false)

        val imageView: ImageView = view.findViewById(R.id.food2fragment)
        val textView: TextView = view.findViewById(R.id.text_description2)
        val buttonNext: Button = view.findViewById(R.id.button_next)
        val buttonPrevious: Button = view.findViewById(R.id.button_previous)

        // Set the image and description for Food 2
        imageView.setImageResource(R.drawable.image5) // Replace with your image resource
        textView.text = "This is a long description for Food 2. It includes details about the dish, ingredients, and preparation methods."

        buttonNext.setOnClickListener {
            // No next fragment, do nothing or show a message
        }

        buttonPrevious.setOnClickListener {
//            (activity as HealthyFoodActivity).loadFragment(Food1Fragment())
        }

        return view
    }
}