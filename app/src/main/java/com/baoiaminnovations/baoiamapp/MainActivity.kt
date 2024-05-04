package com.baoiaminnovations.baoiamapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.baoiaminnovations.baoiamapp.authenticationfeature.domain.util.Constants
import com.baoiaminnovations.baoiamapp.common.presentation.AppViewModel
import com.baoiaminnovations.baoiamapp.common.presentation.MainScreen

import com.baoiaminnovations.baoiamapp.common.presentation.NavHost
import com.baoiaminnovations.baoiamapp.ui.theme.BaoiamAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: AppViewModel by viewModels()

        val sharedPreferences =
            getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE)
        var result = sharedPreferences.getString(Constants.PREF_KEY, "nothing")!!
        setContent {
            BaoiamAppTheme {
                // A surface container using the 'background' color from the theme
                Column {
                    MainScreen(
                        navHostController = rememberNavController(),
                        viewModel,
                        this@MainActivity,
                        result
                    )

                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BaoiamAppTheme {
        Greeting("Android")
    }
}