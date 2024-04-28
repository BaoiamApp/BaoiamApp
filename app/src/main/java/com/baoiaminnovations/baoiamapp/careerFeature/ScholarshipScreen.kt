package com.baoiaminnovations.baoiamapp.careerFeature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.careerFeature.ui.theme.BaoiamAppTheme
import com.baoiaminnovations.baoiamapp.exploreFeature.components.SearchBar

@Composable
fun ScholarshipScreen() {
    var text = remember { mutableStateOf("") }
    var active = remember { mutableStateOf(false) }
    var name by remember { mutableStateOf("") } // State for holding the name
    var phone by remember { mutableStateOf("") } // State for holding the phone number
    var email by remember { mutableStateOf("") } // State for holding the email address
    var selectedCourse by remember { mutableStateOf("") } // State for holding the selected course

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
            Image(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "Back",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { /* Handle back button click */ }
            )
            Spacer(modifier = Modifier.weight(1f))
            // Scholarship text
            Text(
                text = "Scholarship",
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
                    verticalAlignment = Alignment.CenterVertically ,
                    horizontalArrangement = Arrangement.Center, // Center horizontally
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_black_hat),
                        contentDescription = "Apply for Scholarship",
                        modifier = Modifier
                            .width(59.dp)
                            .height(46.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = "Want to apply for scholarship?",
                            style = TextStyle(
                                color = Color(0xFFFF810B), // Orange color
                                fontSize = 20.sp // Text size 20sp
                            ),
                            modifier = Modifier.padding(top = 2.dp) // Adjust top padding for better alignment
                        )
                        Text(
                            text = "Fill the given form",
                            style = TextStyle(
                                color = Color(0xFFFF810B), // Orange color
                                fontSize = 20.sp // Text size 20sp
                            ),
                            modifier = Modifier.padding(start = 10.dp) // Adjust padding for better alignment
                        )
                    }
                }

                // Text field for entering name
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Name") }, // Hint for the text field
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                )

                // Text field for entering phone number
                OutlinedTextField(
                    value = phone,
                    onValueChange = { phone = it },
                    label = { Text("Phone") }, // Hint for the text field
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                )

                // Text field for entering email address
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") }, // Hint for the text field
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                )

                // Outlined box for selecting course
                OutlinedTextField(
                    value = selectedCourse,
                    onValueChange = {},
                    label = { Text("Select Course") }, // Hint for the text field
                    readOnly = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                        .clickable { active.value = true }
                )

                DropdownMenu(
                    expanded = active.value,
                    onDismissRequest = { active.value = false },
                    modifier = Modifier.background(Color.White)
                ) {
                    // Dropdown items
                    courseList.forEach { course ->

                    }
                }

                // Button for applying
                Image(
                    painter = painterResource(id = R.drawable.ic_button),
                    contentDescription = "Apply Now",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                )
            }
        }
    }
}
