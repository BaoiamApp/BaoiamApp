package com.baoiaminnovations.baoiamapp.careerFeature

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.baoiaminnovations.baoiamapp.R

@Composable
fun ReportScreen() {
    var text = remember { mutableStateOf("") }
    var active = remember { mutableStateOf(false) }
    var name by remember { mutableStateOf("") } // State for holding the name
    var phone by remember { mutableStateOf("") } // State for holding the phone number
    var email by remember { mutableStateOf("") } // State for holding the email address
    var selectedCourse by remember { mutableStateOf("") } // State for holding the selected course
    var companyName by remember { mutableStateOf("") }
    // Sample course list
    val courseList = listOf("Course A", "Course B", "Course C")

    Column(modifier = Modifier.fillMaxSize()) {
        // Header
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            // Back button image
            Image(painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "Back",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { /* Handle back button click */ })
            Spacer(modifier = Modifier.weight(1f))
            // Scholarship text
            Text(
                text = "Report",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.weight(1f))
        }

        // Apply for scholarship section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center, // Center horizontally
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_report),
                        contentDescription = "Apply for Scholarship",
                        modifier = Modifier
                            .width(59.dp)
                            .height(46.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = "Want to report a Listing?",
                            style = TextStyle(
                                color = Color(0xFFFF810B), // Orange color
                                fontSize = 20.sp // Text size 20sp
                            ),
                            modifier = Modifier.padding(top = 2.dp) // Adjust top padding for better alignment
                        )
                        Text(
                            text = "Fill the given form now",
                            style = TextStyle(
                                color = Color(0xFFFF810B), // Orange color
                                fontSize = 20.sp // Text size 20sp
                            ),
                            modifier = Modifier.padding(start = 10.dp) // Adjust padding for better alignment
                        )
                    }
                }

                // Text field for entering name
                OutlinedTextField(value = name,
                    onValueChange = { name = it },
                    label = { Text("Name") }, // Hint for the text field
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                )

                // Text field for entering phone number
                OutlinedTextField(value = phone,
                    onValueChange = { phone = it },
                    label = { Text("Phone No") }, // Hint for the text field
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                )

                // Text field for entering email address
                OutlinedTextField(value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") }, // Hint for the text field
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                )
                // Text field for entering Company Name
                OutlinedTextField(value = companyName,
                    onValueChange = { companyName = it },
                    label = { Text("Company Name") }, // Hint for the text field
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                )

                // Outlined box for selecting course
                OutlinedTextField(value = selectedCourse,
                    onValueChange = {},
                    label = { Text("Write your message") }, // Hint for the text field
                    readOnly = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.7f)
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                        .clickable { active.value = true })


                // Button for applying
                Image(
                    painter = painterResource(id = R.drawable.ic_send_button),
                    contentDescription = "Send",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ReportScreenPreview() {
    val navController = rememberNavController()
    ReportScreen()
}
