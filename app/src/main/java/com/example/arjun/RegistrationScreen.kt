package com.example.arjun

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@OptIn(ExperimentalPagerApi::class)
@Composable
fun RegistrationScreen(navController: NavController) {

    rememberSystemUiController().isStatusBarVisible=true

    // PageState :
    val pagerState= rememberPagerState(
        pageCount =3,
        initialPage = 0,
        initialOffscreenLimit = 2,
        infiniteLoop = false
    )

    HorizontalPager(state = pagerState) { page ->
        if (page == 0)
            SignupScreen(pagerState,navController)
        else if(page==1)
            SigninScreen(pagerState,navController)
        else
            ForgotPasswordScreen(pagerState)
    }
}
