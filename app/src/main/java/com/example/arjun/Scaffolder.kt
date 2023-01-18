package com.example.arjun

import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.arjun.ui.theme.DPrimaryColor
import com.example.arjun.ui.theme.Poppins
import com.example.arjun.ui.theme.PrimaryColor
import com.example.arjun.ui.theme.SecondaryColor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

sealed class Screen(
    val id:String,
    val title:String,
    val icon: ImageVector,
){
    object Home:Screen("HomeScreen","Home", Icons.Outlined.Home)
    object Like:Screen("FavouriteScreen","Share", Icons.Outlined.Share)
    object Search:Screen("SearchScreen","Search",Icons.Outlined.Search)
    object Profile:Screen("ProfileScreen","Profile",Icons.Outlined.Person)
    object Settings:Screen("SettingsScreen","Settings",Icons.Outlined.Settings)

    object Items{
        val list= listOf(Home,Like,Search,Profile,Settings)
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CustomBottomNavigation(
    currentScreenId:String,
    onItemSelected:(Screen)->Unit
) {

    val items=Screen.Items.list

    Row(
        modifier= Modifier
            .background(MaterialTheme.colors.background)
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {

        items.forEach { item->

            CustomBottomNavigationItem(item = item, isSelected = item.id==currentScreenId) {
                onItemSelected(item)
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun CustomBottomNavigationItem(item:Screen,isSelected:Boolean,onClick:()->Unit){

    val background=if (isSelected) PrimaryColor.copy(alpha = 0.3f) else Color.Transparent
    val contentColor=if (isSelected) DPrimaryColor else MaterialTheme.colors.onBackground

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = onClick)
    ){
        Row(
            modifier=Modifier
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            Icon(
                imageVector = item.icon,
                contentDescription =null,
                tint = contentColor
            )

            AnimatedVisibility(visible = isSelected) {
                Text(
                    text = item.title,
                    color=contentColor
                )
            }
        }
    }
}

@Composable
fun TopbarCompose(scaffoldState: ScaffoldState,scope:CoroutineScope) {
    TopAppBar(
        modifier = Modifier.background(PrimaryColor),
        title = { Text(
            text = "Sai Shashank",
            color = SecondaryColor,
            fontFamily = Poppins,
            fontSize = 16.sp,
        ) },
        navigationIcon = {
            Spacer(modifier = Modifier.padding(3.dp))
            Image(
                painter = painterResource(id =R.drawable.sai),
                contentDescription = "a",
                modifier = Modifier
                    .size(49.dp)
                    .clip(CircleShape)
                    .border(2.dp, SecondaryColor, CircleShape)
                    .padding(2.dp),
            ) },
        actions = { IconButton(onClick = { scope.launch {
            scaffoldState.drawerState.open()
        } }) {
            Icon(Icons.Default.Menu, contentDescription ="menu" )
        }},
        backgroundColor = PrimaryColor,
    )
}

@Composable
fun SearchbarCompose() {
    var search by remember { mutableStateOf("") }
    var issearched by remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(PrimaryColor.copy(alpha = 0.01f))
            .padding(5.dp),
        value = search,
        placeholder = { Text(text = "Search ...")},
        onValueChange = {
            search=it
            issearched=true
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search Icon",
                tint = Color.Black.copy(
                    alpha = ContentAlpha.medium
                )
            )
        },
        singleLine = true,
        trailingIcon = {
            if(issearched)
            {
                IconButton(onClick = { search=""}) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Close Icon",
                        tint = Color.Black
                    )
                }
            }
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.Black.copy(
                alpha = ContentAlpha.disabled
            ),
            focusedBorderColor = Color.Black,
            cursorColor = Color.Black
        ),
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Draw(scaffoldState: ScaffoldState,scope:CoroutineScope) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(end = 10.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.End,
    ) {
        IconButton(
            onClick = { scope.launch {
                scaffoldState.drawerState.close()
            }},
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_right_arrow),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .size(25.dp)
                    .rotate(180f)
            )
        }
    }
    SettingsScreen()
}
