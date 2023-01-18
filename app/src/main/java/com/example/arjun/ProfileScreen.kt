package com.example.arjun

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.arjun.ui.theme.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProfileScreen() {

    var isEditOpen by remember { mutableStateOf(false) }
    val sheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Expanded)
    val scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = sheetState)
    val scope = rememberCoroutineScope()

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var about by remember { mutableStateOf("") }


    Column(modifier = Modifier.background(Color.White)) {
        Column() {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp),
                backgroundColor = PrimaryColor
            ) {
                Column(
                    modifier = Modifier.padding(top = 40.dp, bottom = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.sai),
                        contentDescription = "a",
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape)
                            .border(2.dp, SecondaryColor, CircleShape),
                    )

                    Spacer(modifier = Modifier.padding(3.dp))

                    Text(
                        text = "Sai Shashank",
                        color = SecondaryColor,
                        fontFamily = Poppins,
                        fontSize = 20.sp,
                    )

                    Text(
                        text = "dharmaraghavasaishashank@gmail.com",
                        color = SecondaryColor.copy(alpha = .5f),
                        fontFamily = Poppins,
                        fontSize = 13.sp,
                    )
                }
            }
        }

        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            sheetContent = {
                Card(
                    modifier = Modifier
                        .height(6000.dp),
                    shape = RoundedCornerShape(30.dp),
                ) {
                    Column(
                        modifier = Modifier.padding(top = 20.dp, bottom = 20.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Top
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 3.dp, end = 3.dp),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Card(shape = RoundedCornerShape(10.dp),
                                elevation = 5.dp,
                                modifier = Modifier.size(90.dp),
                                onClick = {}) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center,
                                    modifier = Modifier.background(Color.LightGray.copy(alpha = .05f))
                                ) {
                                    Card(
                                        modifier = Modifier
                                            .size(60.dp)
//                                            .border(1.dp, SecondaryColor, CircleShape)
//                                            .clip(CircleShape)
//                                            .background(PrimaryColor.copy(alpha = .2f))
                                            .padding(16.dp),
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.pay),
                                            contentDescription = "pay",
//                                            modifier = Modifier.background(PrimaryColor.copy(alpha = .2f))
                                        )
                                    }
                                    Text(
                                        text = "Payment",
                                        color = Color.Gray,
                                        fontFamily = Poppins,
                                        fontSize = 13.sp,
                                    )
                                }
                            }
                            Card(shape = RoundedCornerShape(10.dp),
                                elevation = 5.dp,
                                modifier = Modifier.size(90.dp),
                                onClick = {}) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center,
                                    modifier = Modifier.background(Color.LightGray.copy(alpha = .05f))
                                ) {
                                    Card(
                                        modifier = Modifier
                                            .size(60.dp)
//                                            .border(1.dp, SecondaryColor, CircleShape)
//                                            .clip(CircleShape)
//                                            .background(PrimaryColor.copy(alpha = .2f))
                                            .padding(16.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.img_1),
                                            contentDescription = "pay",
//                                            modifier = Modifier.background(PrimaryColor.copy(alpha = .2f))
                                        )

                                    }

                                    Text(
                                        text = "Settings",
                                        color = Color.Gray,
                                        fontFamily = Poppins,
                                        fontSize = 13.sp,
                                    )
                                }
                            }
                            Card(shape = RoundedCornerShape(10.dp),
                                elevation = 5.dp,
                                modifier = Modifier.size(90.dp),
                                onClick = {}) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center,
                                    modifier = Modifier.background(Color.LightGray.copy(alpha = .05f))
                                ) {
                                    Card(
                                        modifier = Modifier
                                            .size(60.dp)
//                                            .border(1.dp, SecondaryColor, CircleShape)
//                                            .clip(CircleShape)
//                                            .background(PrimaryColor.copy(alpha = .2f))
                                            .padding(16.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.not),
                                            contentDescription = "pay",
//                                            modifier = Modifier.background(PrimaryColor.copy(alpha = .2f))
                                        )
                                    }
                                    Text(
                                        text = "Nofifications",
                                        color = Color.Gray,
                                        fontFamily = Poppins,
                                        fontSize = 13.sp,
                                    )
                                }
                            }
                        }
                        Column(
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(30.dp)
                        ) {
                            Text(
                                text = "Name : Sai Shashank",
                                fontFamily = Poppins,
                                color = SecondaryColor,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                            )
                            Text(
                                text = "Email : sai@gmail.com",
                                fontFamily = Poppins,
                                color = SecondaryColor,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                            )
                            Text(
                                text = "Phone : 9951038852",
                                fontFamily = Poppins,
                                color = SecondaryColor,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                            )
                            Text(
                                text = "About : Still Learning ...",
                                fontFamily = Poppins,
                                color = SecondaryColor,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                            )
                            Text(
                                text = "Address :  IIT ISM Dhanbad",
                                fontFamily = Poppins,
                                color = SecondaryColor,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.End
                            ) {
                                Button(
                                    onClick = {
                                        if(isEditOpen)
                                        {
                                            scope.launch {
                                                sheetState.collapse()
                                            }
                                        }
                                        isEditOpen = true },
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = PrimaryColor,
                                        contentColor = Color.White
                                    ),
                                    shape = RoundedCornerShape(8.dp),
                                    elevation = ButtonDefaults.elevation(5.dp)
                                ) {
                                    Image(
                                        imageVector = Icons.Outlined.Edit,
                                        contentDescription = "edit", modifier = Modifier.size(20.dp)
                                    )
                                    AnimatedVisibility(visible = isEditOpen) {
                                        Text(
                                            text = "Edit Profile",
                                            color = SecondaryColor,
                                            fontFamily = Poppins,
                                            fontSize = 12.sp,
                                            modifier = Modifier.padding(start = 7.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            },
            sheetPeekHeight = 95.dp,
            modifier = Modifier.padding(30.dp),
            sheetShape = RoundedCornerShape(30.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(it)) {
                Text(
                    text = "Edit Profile",
                    color = LightTextColor,
                    fontFamily = Poppins,
                    fontSize = 14.sp,
                )

                OutlinedTextField(
                    value = username, onValueChange = {
                        username = it
                    },
                    label = {
                        Text(text = "Username", color = PrimaryColor)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = PrimaryColor,
                        textColor = PrimaryColor,
                        focusedBorderColor = Color.Gray,
                        cursorColor = Color.Gray,

                        ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType =
                        KeyboardType.Text
                    ),
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_user),
                            contentDescription = "",
                            tint = PrimaryColor,
                            modifier = Modifier.size(24.dp)
                        )
                    }
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
                        .padding(top = 2.dp),
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
                    value = phone, onValueChange = {
                        phone = it
                    },
                    label = {
                        Text(text = "Phone", color = PrimaryColor)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .padding(top = 2.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = PrimaryColor,
                        textColor = PrimaryColor,
                        focusedBorderColor = Color.Gray,
                        cursorColor = Color.Gray,

                        ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType =
                        KeyboardType.Text
                    ),
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_whatsapp),
                            contentDescription = "",
                            tint = PrimaryColor,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                )

                OutlinedTextField(
                    value = about, onValueChange = {
                        about = it
                    },
                    label = {
                        Text(text = "About", color = PrimaryColor)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .padding(top = 2.dp, bottom = 5.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = PrimaryColor,
                        textColor = PrimaryColor,
                        focusedBorderColor = Color.Gray,
                        cursorColor = Color.Gray,

                        ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType =
                        KeyboardType.Text
                    ),
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_about),
                            contentDescription = "",
                            tint = PrimaryColor,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                )
                Row(
                    modifier = Modifier.fillMaxWidth().padding(end=19.dp,start=19.dp,bottom=10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = { scope.launch {
                            sheetState.expand()
                        } },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = PrimaryColor,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(8.dp),
                        elevation = ButtonDefaults.elevation(5.dp)
                    ) {
                        Image(
                            imageVector = Icons.Outlined.Done,
                            contentDescription = "done", modifier = Modifier.size(23.dp)
                        )
                    }
                    Button(
                        onClick = {scope.launch {
                            sheetState.expand()
                        }},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = PrimaryColor,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(8.dp),
                        elevation = ButtonDefaults.elevation(5.dp)
                    ) {
                        Image(
                            imageVector = Icons.Outlined.Close,
                            contentDescription = "cancel", modifier = Modifier.size(23.dp)
                        )
                    }

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun aca() {
    ProfileScreen()
}

