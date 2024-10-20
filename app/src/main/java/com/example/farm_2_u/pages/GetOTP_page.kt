package com.example.farm_2_u.pages

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.farm_2_u.Homepage
import com.example.farm_2_u.OTPTextField
import com.example.farm_2_u.R

@Composable
fun GetOTP_page(navController: NavHostController) {
    val context = LocalContext.current
    val otpVal = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Ensure that the drawable resource exists
        Image(
            painter = painterResource(id = R.drawable.otp),
            contentDescription = "OTP image",
            modifier = Modifier.height(300.dp)
        )

        Text(
            text = "Enter your OTP",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        OTPTextField(
            length = 4,
            onField = { otp -> otpVal.value = otp }
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                if (otpVal.value.isEmpty()) {
                    Toast.makeText(context, "Please enter OTP", Toast.LENGTH_SHORT).show()
                } else {
                    navController.navigate(Homepage.route)
                }
            },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(45.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.c4)
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Submit OTP",
                fontSize = 18.sp,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GetOTPPagePreview() {
    val navController = rememberNavController()
    GetOTP_page(navController = navController)
}