package com.example.farm_2_u.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.farm_2_u.Homepage

@Composable
fun Farmer_Regpage(navController: NavHostController) {
    val farmername = remember { mutableStateOf("") }
    val farmernum = remember { mutableStateOf("") }
    val farmeremail = remember { mutableStateOf("") }
    val newpassword = remember { mutableStateOf("") }
    val confirmpassword = remember { mutableStateOf("") }
    val farmerLocation = remember { mutableStateOf("") }

    // Flags for error handling
    val (passwordError, setPasswordError) = remember { mutableStateOf(false) }
    val (formError, setFormError) = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Farmer Registration Page")

        OutlinedTextField(
            value = farmername.value,
            onValueChange = { farmername.value = it },
            label = { Text("Name") },
            isError = formError && farmername.value.isEmpty() // Show error if name is empty
        )

        OutlinedTextField(
            value = farmeremail.value,
            onValueChange = { farmeremail.value = it },
            label = { Text("Email") },
            isError = formError && farmeremail.value.isEmpty() // Show error if email is empty
        )

        OutlinedTextField(
            value = farmernum.value,
            onValueChange = { newtxt ->
                if (newtxt.length <= 10 && newtxt.all { it.isDigit() }) {
                    farmernum.value = newtxt
                }
            },
            modifier = Modifier.padding(2.dp),
            label = { Text("Number") },
            placeholder = { Text("Enter your number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            isError = formError && farmernum.value.isEmpty() // Show error if number is empty
        )

        OutlinedTextField(
            value = newpassword.value,
            onValueChange = { newpassword.value = it },
            label = { Text("New Password") },
            visualTransformation = PasswordVisualTransformation(),
            isError = passwordError // Show red outline if password mismatch
        )

        OutlinedTextField(
            value = confirmpassword.value,
            onValueChange = { confirmpassword.value = it },
            label = { Text("Confirm Password") },
            visualTransformation = PasswordVisualTransformation(),
            isError = passwordError // Show red outline if password mismatch
        )

        if (passwordError) {
            Text(
                text = "Passwords do not match!",
                color = Color.Red,
                modifier = Modifier.padding(top = 5.dp)
            )
        }

        OutlinedTextField(
            value = farmerLocation.value,
            onValueChange = { farmerLocation.value = it },
            label = { Text("Location") },
            isError = formError && farmerLocation.value.isEmpty() // Show error if location is empty
        )

        Button(
            modifier = Modifier.padding(10.dp),
            onClick = {
                // Reset error flags
                setPasswordError(false)
                setFormError(false)

                // Check if all fields are filled
                if (farmername.value.isEmpty() || farmernum.value.isEmpty() || farmeremail.value.isEmpty() ||
                    newpassword.value.isEmpty() || confirmpassword.value.isEmpty() || farmerLocation.value.isEmpty()) {
                    setFormError(true)
                } else if (newpassword.value != confirmpassword.value) {
                    // Check if passwords match
                    setPasswordError(true)
                } else {
                    // If no errors, navigate to homepage
                    navController.navigate(Homepage.route)
                }
            }
        ) {
            Text(text = "Register", color = Color.White, modifier = Modifier.padding(5.dp))
        }

        // If formError is true, show a general error message
        if (formError) {
            Text(
                text = "Please fill all fields!",
                color = Color.Red,
                modifier = Modifier.padding(top = 5.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FarmerRegpagePreview() {
    val navController = rememberNavController()
    Farmer_Regpage(navController)
}
