package com.baoiaminnovations.baoiamapp.exploreFeature.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.baoiaminnovations.baoiamapp.MainActivity
import com.baoiaminnovations.baoiamapp.R
import com.baoiaminnovations.baoiamapp.authenticationfeature.domain.util.Constants
import com.baoiaminnovations.baoiamapp.common.presentation.AppViewModel
import com.baoiaminnovations.baoiamapp.exploreFeature.components.SearchBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreScreen(
    navHostController: NavHostController,
    viewModel: AppViewModel,
    activity: MainActivity
) {
    viewModel.getUserName()
    var text = remember { mutableStateOf("") }
    var active = remember {
        mutableStateOf(false)
    }

    val sharedPreferences = activity.getSharedPreferences(
        Constants.SHARED_PREF_NAME,
        Context.MODE_PRIVATE
    )
    val editor = sharedPreferences.edit()
    editor.apply {
        putString(Constants.PREF_KEY, Constants.MAIN_SCREEN_VALUE)
    }.apply()

    Column(modifier = Modifier.fillMaxSize()) {
        SearchBar(text = text, active = active)

        viewModel.showVerificationAndOTPDialogBox.value = false
        viewModel.showVerifyingOTPDialogBox.value = false
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            painter = painterResource(id = R.drawable.offer),
            contentDescription = stringResource(id = R.string.offer),
            contentScale = ContentScale.Crop
        )
        Text(
            text = stringResource(R.string.recommendedForYou),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 10.dp)
        )

        LazyRow(modifier = Modifier.padding(start = 10.dp)) {
            item {
                Card(
                    modifier = Modifier
                        .border(
                            1.dp, Color.Black, MaterialTheme.shapes.medium.copy(
                                topStart = CornerSize(10.dp),
                                topEnd = CornerSize(10.dp),
                                bottomStart = CornerSize(10.dp),
                                bottomEnd = CornerSize(10.dp),
                            )
                        )
                        .width(250.dp)
                        .height(330.dp)
                        .padding(10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.onPrimary
                    )

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Course main image",
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "Complete UI/UX course ",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 2
                    )
                    Text(
                        text = "Mayank Sharma",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light,
                        fontStyle = FontStyle.Italic
                    )
                    Text(text = "4.6")
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box(modifier = Modifier.fillMaxSize()) {
                            Text(text = "$100", modifier = Modifier.align(Alignment.CenterStart))
                            OutlinedButton(
                                onClick = { },
                                colors = ButtonDefaults.outlinedButtonColors(
                                    containerColor = MaterialTheme.colorScheme.onPrimary
                                ),
                                modifier = Modifier.align(Alignment.CenterEnd)
                            ) {
                                Text(text = "Buy Now")
                            }
                        }
                    }
                }
            }
        }
    }
}