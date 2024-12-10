import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.wecare.R
import com.example.wecare.FragmentNavigator

class Food1Fragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find buttons using the correct IDs from the fragment layout
        val buttonPrevious = view.findViewById<Button>(R.id.buttonPrevious)
        val buttonNext = view.findViewById<Button>(R.id.buttonNext)

        // Check if buttons are null to avoid NullPointerException
        if (buttonPrevious != null && buttonNext != null) {
            // Set OnClickListener for the 'Next' button to go to Food2Fragment
            buttonNext.setOnClickListener {
                val fragmentTransaction = parentFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.food2linearlayout,Food2Fragment())
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }

            // Set OnClickListener for the 'Previous' button to go back to HealthyFoodActivity
            buttonPrevious.setOnClickListener {
                activity?.finish() // This will finish the current activity and return to the previous one
            }
        } else {
            Log.e("Food1Fragment", "Buttons not found in the layout!")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_food1, container, false)
    }
}