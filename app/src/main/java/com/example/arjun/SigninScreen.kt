package com.example.arjun

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.arjun.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SigninScreen(pagerState: PagerState,navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(PrimaryColor))
    {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var isPasswordOpen by remember { mutableStateOf(false) }

        BackgroundImage()

        Box(modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.BottomCenter)
        {
            Column(verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(10.dp).padding(bottom = 30.dp)
            ) {
                Text(
                    text = "Welcome",
                    fontSize = 28.sp,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontFamily = ReemKufi
                )
                Box(modifier = Modifier.padding(1.dp))
                {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp),
                        backgroundColor = Color.White,
                        elevation = .5.dp,
                        shape = BottomBoxShape.medium,
                    ) {

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "Sign In",
                                color = LightTextColor,
                                fontFamily = Poppins,
                                fontSize = 14.sp,
                                modifier = Modifier.padding(top = 16.dp)
                            )

                            OutlinedTextField(
                                value = email, onValueChange = {
                                    email = it
                                },
                                label = {
                                    Text(text = "Email Address", color = PrimaryColor)
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp)
                                    .padding(top = 10.dp),
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    unfocusedBorderColor = PrimaryColor,
                                    textColor = PrimaryColor,
                                    focusedBorderColor = Color.Gray,
                                    cursorColor = Color.Gray,

                                ),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType =
                                    KeyboardType.Email
                                ),
                                singleLine = true,
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_email),
                                        contentDescription = "",
                                        tint = PrimaryColor,
                                        modifier = Modifier.size(24.dp)
                                    )
                                }
                            )

                            OutlinedTextField(
                                value = password, onValueChange = {
                                    password = it
                                },
                                label = {
                                    Text(text = "Password", color = PrimaryColor)
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp)
                                    .padding(top = 10.dp),
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    unfocusedBorderColor = PrimaryColor,
                                    textColor = PrimaryColor,
                                    focusedBorderColor = Color.Gray,
                                    cursorColor = Color.Gray,
                                ),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                                singleLine = true,
                                visualTransformation = if (!isPasswordOpen) PasswordVisualTransformation() else VisualTransformation.None,
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_password),
                                        contentDescription = "",
                                        tint = PrimaryColor,
                                        modifier = Modifier.size(24.dp)
                                    )
                                },
                                trailingIcon = {
                                    IconButton(onClick = { isPasswordOpen = !isPasswordOpen }) {
                                        if (!isPasswordOpen) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.ic_eye_open),
                                                contentDescription = "",
                                                tint = PrimaryColor,
                                                modifier = Modifier.size(24.dp)
                                            )
                                        } else {
                                            Icon(
                                                painter = painterResource(id = R.drawable.ic_eye_close),
                                                contentDescription = "",
                                                tint = PrimaryColor,
                                                modifier = Modifier.size(24.dp)
                                            )
                                        }
                                    }
                                }
                            )

                            Button(
                                onClick = {navController.navigate("MainScreen")},
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp)
                                    .padding(top = 20.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = PrimaryColor,
                                    contentColor = Color.White
                                ),
                                contentPadding = PaddingValues(vertical = 14.dp)
                            ) {

                                Text(text = "Signin", fontFamily = Poppins,color = SecondaryColor)
                            }

                            Spacer(modifier = Modifier.padding(10.dp))
                            TextButton(
                                onClick = {GlobalScope.launch {
                                    pagerState.scrollToPage(
                                        pagerState.currentPage + 1,
                                        pageOffset = 0f
                                    )}},
                                colors = ButtonDefaults.buttonColors(Color.White)
                            ) {
                                Text(
                                    text = "Forgot Password ?",
                                    color = LightTextColor,
                                    fontFamily = Poppins,
                                    fontSize = 12.sp,
                                )
                            }
                            TextButton(
                                onClick = {
                                    GlobalScope.launch {
                                    pagerState.scrollToPage(
                                        pagerState.currentPage - 1,
                                        pageOffset = 0f
                                    )}},
                                contentPadding = PaddingValues(vertical = 0.dp),
                                colors = ButtonDefaults.buttonColors(Color.White)
                            ) {
                                Text(
                                    text = "Don't have an Account ? Sign Up",
                                    color = LightTextColor,
                                    fontFamily = Poppins,
                                    fontSize = 12.sp,
                                )
                            }
                            Spacer(modifier = Modifier.height(20.dp))
                        }
                    }
                }

                Box(modifier = Modifier.padding(bottom =30.dp))
                {
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.White
                        ),
                        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp),
                        modifier = Modifier.padding(top = 20.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_google),
                                contentDescription = "",
                                tint = Color.Unspecified,
                                modifier = Modifier.size(26.dp)
                            )
                            Spacer(modifier = Modifier.width(20.dp))
                            Text(text = "Continue with Google", color = PrimaryColor, fontSize = 16.sp)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BackgroundImage() {
    Box(modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.TopCenter)
    {
        Image(painter = painterResource(id = R.drawable.img), contentDescription = "login")
    }
}

@Preview(showBackground = true)
@Composable
fun P() {
//    SigninScreen()
}