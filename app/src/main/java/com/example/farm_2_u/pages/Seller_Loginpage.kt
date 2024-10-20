package com.example.farm_2_u.pages

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.farm_2_u.R

@Composable
fun Seller_Loginpage(navController: NavHostController) {
    val num = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val passwordVisible = remember { mutableStateOf(false) }
    val context = LocalContext.current
    val bgcolor = colorResource(id = R.color.c1)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bgcolor)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome Farmers,\nLogin & Sell your Products",
            fontSize = 20.sp,
            style = TextStyle(
                textAlign = TextAlign.Center,
                color = Color.Black
            ),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(20.dp))

        Image(
            painter = painterResource(id = R.drawable.no_bg_logo_1),
            contentDescription = "logo",
            modifier = Modifier.width(200.dp)
        )

        Spacer(modifier = Modifier.padding(20.dp))

        OutlinedTextField(
            value = num.value,
            onValueChange = { newtxt ->
                if (newtxt.length <= 10 && newtxt.all { it.isDigit() }) {
                    num.value = newtxt
                }
            },
            modifier = Modifier
                .padding(2.dp)
                .fillMaxWidth(),
            label = { Text("Number") },
            placeholder = { Text("Enter your number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.padding(20.dp))

        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            modifier = Modifier
                .padding(2.dp)
                .fillMaxWidth(),
            label = { Text("Password") },
            placeholder = { Text("Enter your password") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.padding(20.dp))

        Button(onClick = {
            navController.navigate(com.example.farm_2_u.GetOTP_page.route)
            Toast.makeText(context, "OTP Sent", Toast.LENGTH_SHORT).show()
        },
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.c4))
        ) {
            Text(
                text = "Get OTP",
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.padding(50.dp))

        TextButton(onClick = {
            navController.navigate(com.example.farm_2_u.Farmer_Regpage.route)
        }) {
            Text(
                text = "Register! New User",
                style = TextStyle(
                    color = Color.Blue
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SellerLoginpagePreview() {
    val navController = rememberNavController()
    Seller_Loginpage(navController)
}