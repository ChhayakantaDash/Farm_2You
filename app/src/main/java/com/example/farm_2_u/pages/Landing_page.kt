package com.example.farm_2_u.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeGestures
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.farm_2_u.AboutUs
import com.example.farm_2_u.FAQItem
import com.example.farm_2_u.FAQSection
import com.example.farm_2_u.R
import com.example.farm_2_u.Seller_Loginpage
import com.example.farm_2_u.Buyer_Loginpage

@Composable
fun Landing_page(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.bg_logo_landing_page_03),
                contentDescription = "background logo",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.aspectRatio(16f / 8f)
            )

            Column(
                modifier = Modifier
                    .align(Alignment.CenterEnd) // Align the column to the right
                    .padding(bottom = 40.dp, end = 5.dp)
            ) {
                Text(
                    text = "Fresh from Farm,",
                    fontSize = 25.sp,
                    modifier = Modifier.align(Alignment.End),
                    color = colorResource(id = R.color.c1),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Direct to your doorstep",
                    fontSize = 25.sp,
                    color = colorResource(id = R.color.c1),
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 16.dp)
            ) {
                Button(
                    onClick = {
                        navController.navigate(Seller_Loginpage.route)
                    },
                    modifier = Modifier.padding(end = 1.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.c1)
                    )
                ) {
                    Text(
                        text = "Sell",
                        color = Color.Black,
                        fontSize = 15.sp
                    )
                }

                Button(
                    onClick = {
                        navController.navigate(Buyer_Loginpage.route)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.c1)
                    ),
                    modifier = Modifier.padding(start = 8.dp, end=8.dp)
                ) {
                    Text(
                        text = "Buy",
                        color = Color.Black,
                        fontSize = 15.sp
                    )
                }
            }
        }

        Image(
            painter = painterResource(id = R.drawable.no_bg_logo_1),
            contentDescription = "logo",
            modifier = Modifier
                .width(200.dp)
                .align(Alignment.CenterHorizontally)
                .padding(20.dp)
        )

        Text(
            text = "Why choose FARM2YOU",
            fontSize = 32.sp,
            color = colorResource(id = R.color.teal_700),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp),
            fontWeight = FontWeight.Bold
        )

        Image(
            painter = painterResource(id = R.drawable.features_img),
            contentDescription = "Features",
            contentScale = ContentScale.FillBounds
        )

        Text(
            text = "Frequently Asked Questions",
            fontSize = 25.sp,
            color = colorResource(id = R.color.teal_700),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp),
            fontWeight = FontWeight.Bold
        )

        FAQSection(
            faqItems = listOf(
                FAQItem("What is FARM2YOU?", "FARM2YOU is a platform that connects farmers with consumers directly."),
                FAQItem("How do I sell on FARM2YOU?", "To sell, click on the 'Sell' button and follow the steps to list your products."),
                FAQItem("How do I buy products?", "To buy products, click on the 'Buy' button and explore our product range."),
                FAQItem("What payment methods are supported?", "We support all major credit cards, debit cards, and digital wallets."),
                FAQItem("Is delivery available?", "Yes, we provide doorstep delivery for all listed products.")
            )
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .background(color = colorResource(id = R.color.teal_700))
        ) {
            Text(
                text = "About Us",
                fontSize = 25.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Start)  // Align text to the top-left corner
                    .padding(start = 10.dp, bottom = 5.dp, top = 10.dp)
                    .clickable { navController.navigate(AboutUs.route) },
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Copyright @ 2024 Farm2U \n" +
                        "This is a working prototype of the problem statement\n" +
                        "It is made by My team Farmtak\n" +
                        "Right Reserved\n" +
                        "Privacy Policy\n" +
                        "Terms of Services\n" +
                        "Cancellation Policy\n" +
                        "Career",
                fontSize = 15f.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Start)  // Align text to the top-left corner
                    .padding(start = 10.dp, bottom = 5.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
            ){
                Image(
                    painter = painterResource(id = R.drawable.facebook),
                    contentDescription ="facebooklogo",
                    modifier = Modifier.size(30.dp)
                )
                
                Spacer(modifier = Modifier.padding(5.dp))

                Image(
                    painter = painterResource(id = R.drawable.linkedin),
                    contentDescription ="facebooklogo",
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LandingPagePreview() {
    val navController = rememberNavController()
    Landing_page(navController)
}





