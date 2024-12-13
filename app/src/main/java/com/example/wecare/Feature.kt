package com.example.wecare

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavHostController
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import android.content.Context

@Composable
fun Featured(navController: NavHostController, context: Context) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0F7FA)) // Light cyan background color
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.food4), // Replace with your image resource
                contentDescription = "Image Description",
                modifier = Modifier
                    .width(300.dp) // Set your desired width
                    .height(300.dp) // Set your desired height
            )
            Text(
                text = "Low-Carb Asian Chopped Salad with Garlic-Ginger Chicken",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp),
                color = Color.Black
            )

            Text(
                text = "Going low-carb? Don’t miss this low-carb Asian chopped salad with garlic-ginger chicken. Its ingredient list may look a bit long, but every item on the list adds to a tangy crunchy dish.",
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 8.dp),
                color = Color.Black
            )

            LazyColumn(
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                item {
                    Text(
                        text = "Ingredients",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
                item {
                    Text(
                        text = "\u2022 2 tbsps sesame oil with 3 cloves garlic (minced), 1-inch piece ginger (grated)",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 8.dp),
                        color = Color.Black
                    )
                }
                item {
                    Text(
                        text = "\u2022 1 1/4 pound chicken breasts, 1 lettuce (chopped) + 9-ounce shredded cabbage, 1 large carrot grated ",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 4.dp),
                        color = Color.Black
                    )
                }
                item {
                    Text(
                        text = "\u2022 1 cucumber, 2 stalks celery, 2 scallions, 2 tbsps mint, 2 tbsps cilantro (chopped)",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 4.dp),
                        color = Color.Black
                    )
                }
                item {
                    Text(
                        text = "\u2022 1 tsp honey and Juice of 1 lime",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 4.dp),
                        color = Color.Black
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = {
                    // Navigate to the next page (FeaturedItem2)
                    navController.navigate("featureditem2")
                }) {
                    Text(text = "Next")
                }

//                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = {
                    // Navigate back if needed
                    val intent = Intent(context, MainHomePage::class.java)
                    context.startActivity(intent)
                }) {
                    Text(text = "Back")
                }
            }
        }
    }
}