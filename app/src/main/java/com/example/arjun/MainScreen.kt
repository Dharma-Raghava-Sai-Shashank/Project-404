package com.example.arjun

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen() {

    var currentScreen by remember {
        mutableStateOf<Screen>(Screen.Home)
    }
    val navController= rememberNavController()

    Scaffold(
        bottomBar = {
            CustomBottomNavigation(currentScreenId = currentScreen.id, onItemSelected =
            {
                currentScreen = it
                navController.navigate(it.id)
            })
        },
    ){
        Box(modifier = Modifier.padding(it))
        {
            NavHost(navController = navController, startDestination = "HomeScreen", builder ={
                composable("HomeScreen", content = { HomeScreen(navController = navController) })
                composable("SettingsScreen", content = { SettingsScreen() })
                composable("ProfileScreen", content = { ProfileScreen() })
                composable("FavouriteScreen", content = { ShareScreen(navController = navController) })
                composable("SearchScreen", content = { SearchScreen(navController = navController) })
            })
        }
    }
}

