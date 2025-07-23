package com.example.appui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appui.R

@Composable
fun HomeScreen(navController: NavController) {
    val modifier = Modifier
    Column(
        modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFF3E0),
                        Color(0xFFFFCC80)
                    )
                )
            )
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu Icon",
                tint = Color(0xff272140),
                modifier = Modifier.size(28.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.cook),
                    contentDescription = "Cook Image",
                    modifier = Modifier.size(48.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Cook",
                    fontSize = 14.sp,
                    color = Color(0xff272140)
                )
            }
        }
//        Greetings Text
        Text(
            text = "Hey foodie! What’s on the menu today? 🍲",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF272140),
            lineHeight = 28.sp,
            modifier = Modifier.padding(bottom = 24.dp)
        )
//        SearchBar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = colorResource(R.color.white),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(horizontal = 16.dp, vertical = 10.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                tint = colorResource(R.color.gray_500)
            )
            Spacer(Modifier.width(12.dp))
            Text(
                text = "Search...",
                color = Color.Gray,
                fontSize = 16.sp
            )
            Spacer(Modifier.weight(1f))
            Image(
                painter = painterResource(R.drawable.list),
                contentDescription = "Filter List",
                Modifier.height(20.dp)
            )
        }

        Spacer(Modifier.height(32.dp))
        Text(
            "Recommend Combo",
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyRow (
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(bottom = 16.dp)
        ){
            items(2){ index ->

                RecommendedComboCard(

                    if(index == 0) "Salad" else "Fruits",
                    if (index == 0) "50 $" else "150 $",
                    if (index == 0) R.drawable.food_1 else R.drawable.food_2)
            }
        }
//        Category Tab
        val categories = listOf("Hottest", "Popular", "New Combo", "Top")
        var selectedCategory by remember { mutableStateOf("Hottest") }

        val combos = when (selectedCategory) {
            "Hottest" -> listOf(
                Triple("Salad", "50 $", R.drawable.food_1),
                Triple("Fruits", "150 $", R.drawable.food_4),
                Triple("Wraps", "90 $", R.drawable.food_2)
            )
            "Popular" -> listOf(
                Triple("Pizza", "120 $", R.drawable.food_4)
            )
            "New Combo" -> listOf(
                Triple("Wraps", "90 $", R.drawable.food_2)
            )
            "Top" -> listOf(
                Triple("Steak", "200 $", R.drawable.food_1),
                Triple("Pasta", "110 $", R.drawable.food_4)
            )
            else -> emptyList()
        }

        LazyColumn {
            item {
                // Category Tab
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(24.dp),
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    items(categories) { category ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .clickable { selectedCategory = category }
                        ) {
                            Text(
                                text = category,
                                fontSize = 16.sp,
                                fontWeight = if (category == selectedCategory) FontWeight.Bold else FontWeight.Normal,
                                color = if (category == selectedCategory) Color(0xFFd81b60) else Color.DarkGray
                            )
                            Spacer(modifier = Modifier.height(4.dp))

                            Box(
                                modifier = Modifier
                                    .height(2.dp)
                                    .width(40.dp)
                                    .background(
                                        color = if (category == selectedCategory) Color(0xFFd81b60) else Color.Transparent,
                                        shape = RoundedCornerShape(1.dp)
                                    )
                            )
                        }
                    }
                }
            }

            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    items(combos) { (title, price, image) ->
                        RecommendedComboCard(title, price, image)
                    }
                }
            }
        }


    }
}

@Composable
fun RecommendedComboCard(
    name: String,
    price: String,
    imageRes: Int,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.white)
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .width(180.dp)
            .height(220.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favourite Icon",
                    tint = Color.Gray,
                    modifier = Modifier.size(20.dp)
                )
            }

            Image(
                painter = painterResource(imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = price,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color(0xFFd81b60)
                )
                Card(
                    shape = CircleShape,
                    modifier = Modifier.size(28.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFd81b60))
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Icon",
                        tint = Color.White,
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
        }
    }
}
