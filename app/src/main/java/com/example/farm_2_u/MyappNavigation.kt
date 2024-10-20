package com.example.farm_2_u

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.farm_2_u.pages.AboutUs
import com.example.farm_2_u.pages.Buyer_Loginpage
import com.example.farm_2_u.pages.Farmer_Regpage
import com.example.farm_2_u.pages.Landing_page
import com.example.farm_2_u.pages.GetOTP_page
import com.example.farm_2_u.pages.Home_page
import com.example.farm_2_u.pages.Sell_page
import com.example.farm_2_u.pages.Seller_Loginpage

@Composable
fun MyappNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Landingpage.route, builder = {
        composable(Landingpage.route) {
            Landing_page(navController = navController)
        }
        composable(GetOTP_page.route) {
            GetOTP_page(navController = navController)
        }
        composable(Homepage.route) {
            Home_page(navController = navController)
        }
        composable(Sell_page.route) {
            Sell_page(navController = navController)
        }
        composable(Seller_Loginpage.route) {
            Seller_Loginpage(navController = navController)
        }
        composable(Buyer_Loginpage.route) {
            Buyer_Loginpage(navController = navController)
        }
        composable(AboutUs.route) {
            AboutUs(navController = navController)
        }
        composable(Farmer_Regpage.route) {
            Farmer_Regpage(navController = navController)
        }
    })
}
