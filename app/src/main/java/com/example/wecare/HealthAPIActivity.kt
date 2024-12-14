package com.example.wecare

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
//import com.squareup.okhttp.OkHttpClient
//import com.squareup.okhttp.Request
//import com.squareup.okhttp.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import android.text.Html
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HealthAPIActivity : AppCompatActivity() {

    private lateinit var heartHealthyFoodsText: TextView
    private lateinit var theBasicsOverviewText: TextView
    private lateinit var heartHealthyFoodsText2: TextView
    private lateinit var theBasicsOverviewText2: TextView
    private lateinit var imageView: ImageView // ImageView to display the image

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health_apiactivity)
        heartHealthyFoodsText = findViewById(R.id.heartHealthyFoodsText)
        theBasicsOverviewText = findViewById(R.id.theBasicsOverviewText)
        heartHealthyFoodsText2 = findViewById(R.id.heartHealthyFoodsText2)
//        theBasicsOverviewText2 = findViewById(R.id.theBasicsOverviewText2)
        imageView = findViewById(R.id.imageView) // Initialize the ImageView

        fetchDataFromApi()
    }

    private fun fetchDataFromApi() {
        // Start a coroutine for background tasks
        GlobalScope.launch(Dispatchers.Main) {
            val jsonResponse = fetchJsonData()
            parseAndDisplayData(jsonResponse)
        }
    }

    private suspend fun fetchJsonData(): String {
        // Run the network request in a background thread
        return withContext(Dispatchers.IO) {
            val client = OkHttpClient()
            val request = Request.Builder()
                .url("https://odphp.health.gov/myhealthfinder/api/v3/topicsearch.json?TopicId=25")
                .build()
            val response: Response = client.newCall(request).execute()
            return@withContext response.body?.string() ?: ""
        }
    }

    private fun parseAndDisplayData(jsonResponse: String) {
        try {
            // Parse the JSON response
            val jsonObject = JSONObject(jsonResponse)
            val resources = jsonObject.getJSONObject("Result").getJSONObject("Resources")
            val resourceArray = resources.getJSONArray("Resource")

            // Loop through resources to find the relevant sections
            for (i in 0 until resourceArray.length()) {
                val resource = resourceArray.getJSONObject(i)
                val sections = resource.getJSONObject("Sections")
                val sectionArray = sections.getJSONArray("section")

                // Extract the Image URL from the resource
                val imageUrl = resource.optString("ImageUrl", "")
                val imageAltText = resource.optString("ImageAlt", "")

                // If imageUrl is available, load it using Glide
                if (imageUrl.isNotEmpty()) {
                    Glide.with(this@HealthAPIActivity)
                        .load(imageUrl)
                        .into(imageView)  // Load image into the ImageView
                }

                for (j in 0 until sectionArray.length()) {
                    val section = sectionArray.getJSONObject(j)
                    val title = section.getString("Title")

                    when (title) {
                        "Heart-Healthy Foods: Shopping List" -> {
                            val description = section.optString("Description", "No description available")
                            val content = section.getString("Content")
                            val plainTextContent = Html.fromHtml(content).toString().trim()
                            val firstParagraph = plainTextContent.split("\n").getOrNull(0) ?: "No content available"

                            heartHealthyFoodsText.text = "$title\n\n$description\n$firstParagraph"
                        }
                        "The Basics: Overview" -> {
                            val description = section.optString("Description", "No description available")
                            val content = section.getString("Content")
                            val plainTextContent = Html.fromHtml(content).toString().trim()
                            val firstParagraph = plainTextContent.split("\n").getOrNull(0) ?: "No content available"

                            theBasicsOverviewText.text = "$title\n\n$description\n$firstParagraph"
                        }

                        "The Basics: What Is Heart Disease?" -> {
                            val description = section.optString("Description", "No description available")
                            val content = section.getString("Content")
                            val plainTextContent = Html.fromHtml(content).toString().trim()
                            val firstParagraph = plainTextContent.split("\n").getOrNull(0) ?: "No content available"

                            heartHealthyFoodsText2.text = "$title\n\n$description\n$firstParagraph"
                        }
//                        "Take Action: Know the Signs of a Heart Attack" -> {
//                            val description = section.optString("Description", "No description available")
//                            val content = section.getString("Content")
//                            val plainTextContent = Html.fromHtml(content).toString().trim()
//                            val firstParagraph = plainTextContent.split("\n").getOrNull(0) ?: "No content available"
//
//                            theBasicsOverviewText2.text = "$title\n\n$description\n$firstParagraph"
//                        }
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}