package com.example.farm_2_u

interface Destination {
    val route : String
}

object Homepage: Destination {
    override val route = "home"
}

object Landingpage:Destination{
    override val route = "landingpage"
}

object Loginpage:Destination{
    override val route = "login"
}

object GetOTP_page:Destination{
    override val route = "getotp"
}
object Sell_page:Destination{
    override val route = "sell"
}
object Seller_Loginpage:Destination{
    override val route = "sellerlogin"
}
object Buyer_Loginpage:Destination{
    override val route = "buyerlogin"
}
object AboutUs:Destination{
    override val route = "aboutus"
}
object Farmer_Regpage:Destination{
    override val route = "farmerreg"
}