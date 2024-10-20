package com.example.farm_2_u.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun CustomCard(title: String, description: String) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = androidx.compose.ui.graphics.Color.LightGray),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, fontSize = 20.sp)
            Text(text = description, fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp))
        }
    }
}

@Composable
fun Sell_page(navController: NavHostController) {
    // List of titles and descriptions for the cards
    val cardData = listOf(
        Pair("Card Title 1", "This is the description for card 1."),
        Pair("Card Title 2", "This is the description for card 2."),
        Pair("Card Title 3", "This is the description for card 3."),
        Pair("Card Title 4", "This is the description for card 4.")
    )

    // Creating multiple cards
    Column {
        cardData.forEach { (title, description) ->
            CustomCard(title = title, description = description)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MultipleCardsPreview() {
    val navController = rememberNavController()
    Sell_page(navController)
}

