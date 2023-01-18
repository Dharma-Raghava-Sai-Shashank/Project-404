package com.example.arjun

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.arjun.ui.theme.PrimaryColor

@Composable
fun HomeScreen(navController: NavController) {

    val scaffoldState= rememberScaffoldState()
    val scope= rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = { Draw(scaffoldState,scope)},
        drawerBackgroundColor = PrimaryColor.copy(alpha = 1f),
        drawerShape = RoundedCornerShape(bottomEnd = 50.dp),
        drawerElevation = 3.dp,
        topBar ={ TopbarCompose(scaffoldState,scope)}
    ){}
}

@Preview(showBackground = true)
@Composable
fun s() {
    MainScreen()
}