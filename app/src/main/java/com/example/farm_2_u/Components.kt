package com.example.farm_2_u

import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*

// VIDEO PLAYER COMPONENT
//@Composable
//fun VideoPlayer(videoUri: Uri) {
//    AndroidView(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//            .clip(RoundedCornerShape(16.dp)),
//        factory = { context ->
//            VideoView(context).apply {
//                setVideoURI(videoUri)
//
//                val mediaController = MediaController(context)
//                mediaController.setAnchorView(this)
//
//                setMediaController(mediaController)
//                setOnPreparedListener {
//                    start()
//                }
//            }
//        }
//    )
//}

// CUSTOM OTP TEXT FIELD
@Composable
fun OTPTextField(
    modifier: Modifier = Modifier,
    length: Int,
    onField: (code: String) -> Unit
) {
    var code by remember { mutableStateOf(List(length) { "" }) }
    val focusRequesters: List<FocusRequester> = remember {
        List(length) { FocusRequester() }
    }

    Row(
        modifier = modifier.height(50.dp)
    ) {
        (0 until length).forEach { index ->
            OutlinedTextField(
                value = code[index],
                onValueChange = { value ->
                    if (value.length <= 1) {
                        val newCode = code.toMutableList().apply {
                            this[index] = value
                        }
                        code = newCode
                        onField(newCode.joinToString(""))

                        if (value.isNotEmpty() && index < length - 1) {
                            focusRequesters[index + 1].requestFocus()
                        } else if (value.isEmpty() && index > 0) {
                            focusRequesters[index - 1].requestFocus()
                        }
                    }
                },
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .focusRequester(focusRequesters[index]),
                textStyle = MaterialTheme.typography.bodyMedium.copy(
                    textAlign = TextAlign.Center,
                    color = Color.Black
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = Modifier.width(15.dp))
        }
    }
}

data class FAQItem(val question: String, val answer: String)

@Composable
fun FAQSection(faqItems: List<FAQItem>) {
    @Composable
    fun FAQItemCard(faqItem: FAQItem) {
        var expanded by remember { mutableStateOf(false) }

        // Define the colors for expanded and collapsed states
        val cardBackgroundColor = if (expanded) {
            colorResource(id = R.color.c2) // Color when expanded
        } else {
            colorResource(id = R.color.c1) // Color when collapsed
        }
        // Define the text color based on the card's state
        val textcolor = if (expanded) {
            colorResource(id = R.color.c1) // Color when expanded
        } else {
            colorResource(id = R.color.teal_700) // Color when collapsed
        }

        Card(
            colors = CardDefaults.cardColors(
                containerColor = cardBackgroundColor // Dynamic color based on expanded state
            ),
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded } // Toggle expanded state on click
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                // Question text
                Text(
                    text = faqItem.question,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.fillMaxWidth(),
                    color = textcolor // Adjust text color for better visibility
                )

                // Animated visibility of the answer
                AnimatedVisibility(
                    visible = expanded,
                    enter = expandVertically() + fadeIn(),
                    exit = fadeOut()
                ) {
                    Text(
                        text = faqItem.answer,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        fontSize = 16.sp,
                        color = textcolor // Adjust text color for better visibility
                    )
                }
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        faqItems.forEach { item ->
            FAQItemCard(faqItem = item)
            Spacer(modifier = Modifier.height(8.dp)) // Spacer between FAQ items
        }
    }
}


