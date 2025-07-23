package com.example.appui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appui.R
import kotlinx.coroutines.delay

@Composable
fun FlashScreen(navController: NavController) {
//Launched delay
    LaunchedEffect(Unit) {
        delay(3000)

        navController.navigate("welcome"){
            popUpTo("flash"){
                inclusive = true
            }
        }
    }

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFFFCC80), // light orange-peach
                        Color(0xFFFFAB91), // soft coral
                        Color(0xFFFF8A65)
                    )
                )
            )
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(R.drawable.meal),
                contentDescription = "Logo Image",
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .border(
                        width = 2.dp,
                        color = Color.Black,
                        shape = RoundedCornerShape(20.dp)
                    )
            )
        }
    }
}