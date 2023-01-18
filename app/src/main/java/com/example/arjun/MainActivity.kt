package com.example.arjun

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.arjun.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState")
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArjunTheme (){
                Surface(modifier = Modifier.fillMaxSize(),color =MaterialTheme.colors.background) {

                    val navController= rememberNavController()

                    NavHost(navController = navController, startDestination = "onBordingScreen", builder ={
                        composable("onBordingScreen", content = { OnBoardingScreen(navController = navController)})
                        composable("RegistrationScreen", content = { RegistrationScreen(navController = navController) })
                        composable("MainScreen", content = { MainScreen() })
                    })
                }
            }
        }
    }

}
