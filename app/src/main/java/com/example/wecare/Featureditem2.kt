package com.example.wecare

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
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
import androidx.navigation.NavHostController

@Composable
fun FeaturedItem2(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0F7FA)) // Light cyan background color
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.food2), // Replace with your image resource
                contentDescription = "Image Description",
                modifier = Modifier
                    .width(300.dp) // Set your desired width
                    .height(300.dp) // Set your desired height
            )
            Text(
                text = "Un-Cobb Salad",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp),
                color = Color.Black
            )

            Text(
                text = "It's a \"composed\" salad with avocados, bacon, chicken, hard boiled eggs, and tomatoes.\n" +
                        "In \"Anti-Cobb\" salad, Instead of bacon, eggs, and tomato, You can include mango, apple slices, and dried cranberries.",
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
                        text = "\u2022 Romaine lettuce, chopped cross-wise in 1-inch strips (or favorite salad greens)",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 8.dp),
                        color = Color.Black
                    )
                }
                item {
                    Text(
                        text = "\u2022 Grilled skinless, boneless chicken breast, chopped",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 4.dp),
                        color = Color.Black
                    )
                }
                item {
                    Text(
                        text = "\u2022 Mango, peeled and chopped",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 4.dp),
                        color = Color.Black
                    )
                }
                item {
                    Text(
                        text = "\u2022 Tart apple, peeled and sliced",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 4.dp),
                        color = Color.Black
                    )
                }
            }
            Button(onClick = {
                navController.popBackStack()
                }) {
                    Text(text = "Back")
            }
        }
    }
}
//
//Row(
//modifier = Modifier
//.fillMaxSize()
//.padding(16.dp),
//horizontalArrangement = Arrangement.SpaceEvenly) {
//    //            Spacer(modifier = Modifier.height(16.dp))
////
////            Button(onClick = {
////                // Navigate to the next page (FeaturedItem2)
////                navController.navigate("Feature")
////            }) {
////                Text(text = "Next")
////            }
//
//    Spacer(modifier = Modifier.height(16.dp))
//
//    Button(onClick = {
//        // Navigate back if needed
//        navController.popBackStack()
//    }) {
//        Text(text = "Back")
//    }
//}