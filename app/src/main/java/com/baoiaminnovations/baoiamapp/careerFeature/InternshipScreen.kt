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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.careerFeature.ui.theme.BaoiamAppTheme

@Composable
fun InternshipScreen() {
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
                text = "Internship",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.weight(1f))
        }
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
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_baoiam_logo),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(100.dp)
                            .height(100.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "UI/UX Designer",
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    TabLayoutExample()


                }
            }
        }
    }
}
data class JobDetails(
    val title: String,
    val location: String,
    val salary: String,
    val description: String
)


@Composable
fun TabLayoutExample() {
    var selectedTabIndex by remember { mutableStateOf(0) }

    val tabs = listOf("Job Details", "Company", "Benefits")

    val jobDetails = JobDetails(
        title = "UX Designer (Remote, Part-time)",
        location = "Aligarh, Uttar Pradesh, India",
        salary = "5000 INR per month",
        description = "Seeking UI/UX interns with a passion for design, creativity,and problem-solving. Collaborate with our team to create intuitive user experiences and innovative interface designs.Apply now for hands-on learning opportunities!"
    )

    Column {
        TabRow(selectedTabIndex = selectedTabIndex, divider = {}, indicator = { tabPositions -> /* No indicator */ } ) {
            tabs.forEachIndexed { index, title ->
                val isSelected = selectedTabIndex == index

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(if (isSelected) Color.Transparent else Color.Transparent)
                        .clickable { selectedTabIndex = index },
                    contentAlignment = Alignment.Center
                ) {
                    if (isSelected) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_send_button),
                            contentDescription = null,
                        )
                    }
                    Text(
                        text = title,
                        color = if (isSelected) Color.White else Color.Black,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp) // Add padding to text
                    )
                }
            }
        }

        when (selectedTabIndex) {
            0 -> TabContent(selectedTabIndex,jobDetails)
            1 -> TabContent(selectedTabIndex,jobDetails.copy(title = "www.boaim.com", description = "BAOIAM is an E-learning platform that focuses on the overall skill development of it's learners by furnishing courses in a variety of disciplines that can help anyone level their skill & pursue their passion.", salary  = "Since 2020"))
            2 -> TabContent(selectedTabIndex,jobDetails.copy(title = "\n \u2022 Dynamic and innovative work environment\n \u2022 Opportunity to work with a passionate team", location = "", salary = "", description = ""))
        }
    }
}

@Composable
fun TabContent(selectedTabIndex: Int,jobDetails: JobDetails) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        val labelTitle = if (selectedTabIndex == 0) {
            "Title: "
        } else if (selectedTabIndex == 1) {
            "Website: "
        } else {
            "Benefits: "
        }
        val labelEstablish = if (selectedTabIndex == 0){
            "Salary: "
        } else if (selectedTabIndex == 1){
            "Establish: "
        } else{
            ""
        }
        val labelAboutUs = if (selectedTabIndex == 0){
            "What we are looking for: "
        } else if (selectedTabIndex == 1){
            "About Us: "
        } else{
            ""
        }
        val labelLocation = if (selectedTabIndex == 0){
            "Location: "
        } else if (selectedTabIndex == 1){
            "Location: "
        } else{
            ""
        }


        AnnotatedText(label = labelTitle, value = jobDetails.title)
        Spacer(modifier = Modifier.height(8.dp))
        AnnotatedText(label = labelLocation, value = jobDetails.location)
        Spacer(modifier = Modifier.height(8.dp))
        AnnotatedText(label = labelEstablish, value = jobDetails.salary)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = labelAboutUs, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = jobDetails.description, fontSize = 16.sp)
        Spacer(modifier = Modifier.height(16.dp))

        // Apply Now button
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_button),
                contentDescription = "Apply Now",
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }

}

@Composable
fun AnnotatedText(label: String, value: String) {
    Text(
        text = buildAnnotatedString {
            pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
            append(label)
            pop()
            append(value)
        },
        fontSize = 16.sp
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BaoiamAppTheme {
        InternshipScreen()
    }
}