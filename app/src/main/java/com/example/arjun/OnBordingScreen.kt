package com.example.arjun

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.arjun.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield

class OnBoardingData(
    val image: Int,
    val title: String,
    val desc: String,
    val backgroundColor: Color,
    val mainColor: Color = ColorBlue
)


@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen (navController: NavController) {

    rememberSystemUiController().isStatusBarVisible=false

    val item=OnBoardingData()

    // PageState :
    val pagerState= rememberPagerState(
        pageCount =item.count(),
        initialPage = 0,
        initialOffscreenLimit = 2,
        infiniteLoop = false
    )

    LaunchedEffect(Unit) {
        while(pagerState.currentPage!=2) {
            yield()
            delay(1800)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount),
                animationSpec = tween(600)
            )
        }
    }

//    rememberSystemUiController().isSystemBarsVisible=false

    Box(modifier=Modifier.fillMaxSize()){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HorizontalPager(state = pagerState) { page ->
                Column(
                    modifier= Modifier
                        .fillMaxSize()
                        .background(item[page].backgroundColor),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    Image(
                        painter = painterResource(id = item[page].image),
                        contentDescription = "",
                        modifier= Modifier.fillMaxWidth()
                    )
                }
            }

        }
    }

    Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxSize()) {
        Card(
            backgroundColor = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .padding(15.dp),
            elevation = 2.dp,
            shape = BottomCardShape.large,
        ) {
            Box(){
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ){

                    PageIndicator(items=item,currentpage=pagerState.currentPage)

                    Text(
                        text = item[pagerState.currentPage].title,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp, end = 30.dp),
                        color = item[pagerState.currentPage].mainColor,
                        fontFamily = Poppins,
                        textAlign = TextAlign.Right,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Text(
                        text = item[pagerState.currentPage].desc,
                        modifier = Modifier.padding(top = 15.dp, start = 40.dp, end = 20.dp),
                        color = Color.Black.copy(alpha = .9f),
                        fontFamily = Poppins,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.ExtraLight
                    )
                }
            }
            Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxWidth())
            {
                if(pagerState.currentPage!=2)
                {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {

                        TextButton(
                            onClick = { navController.navigate("RegistrationScreen") },
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White.copy(alpha = .95f)),
                            shape = RoundedCornerShape(25.dp),
                            contentPadding = PaddingValues(start=6.dp,end=6.dp),
                            elevation = ButtonDefaults.elevation(0.1.dp),
                        ) {
                            Text(
                                text = "Skip now",
                                color = item[pagerState.currentPage].backgroundColor.copy(alpha = 0.8f),
                                fontFamily = Poppins,
                                textAlign = TextAlign.Right,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold,
                            )
                        }
                        Box(modifier = Modifier.padding(3.dp))
                        {
                            OutlinedButton(
                                onClick = { GlobalScope.launch {
                                    pagerState.scrollToPage(
                                        pagerState.currentPage + 1,
                                        pageOffset = 0f
                                    ) } },
                                border = BorderStroke(10.dp,item[pagerState.currentPage].mainColor),
                                shape = RoundedCornerShape(50),
                                colors = ButtonDefaults.outlinedButtonColors(contentColor = item[pagerState.currentPage].mainColor),
                                modifier = Modifier.size(60.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_right_arrow),
                                    contentDescription = "",
                                    tint = item[pagerState.currentPage].mainColor,
                                    modifier = Modifier.size(60.dp)
                                )
                            }
                        }
                    }
                }
                else{
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 30.dp),
                        horizontalArrangement = Arrangement.Center) {
                        TextButton(
                            onClick = {  navController.navigate("RegistrationScreen")  },
                            colors = ButtonDefaults.buttonColors(backgroundColor = ColorOrange),
                            border = BorderStroke(.5.dp, Color.Black.copy(alpha = 0.9f)),
                            shape = RoundedCornerShape(25.dp),
                            contentPadding = PaddingValues(start=95.dp,end=95.dp, top =8.dp, bottom =8.dp),
                            elevation = ButtonDefaults.elevation(0.5.dp),
                        ) {
                            Box(){
                                Text(
                                    text = "Get Started",
                                    color = ColorGreen.copy(alpha = 0.8f),
                                    fontFamily = Poppins,
                                    textAlign = TextAlign.Center,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PageIndicator(items: List<OnBoardingData>, currentpage:Int) {
    Row(horizontalArrangement = Arrangement.Center) {
        repeat(items.count())
        {
            Indicator(isselected= it==currentpage,color=items[it].mainColor)
        }
    }
}

@Composable
fun Indicator(isselected:Boolean,color: Color) {
    val width = animateDpAsState(targetValue = if(isselected) 40.dp else 10.dp)
    Box(modifier = Modifier
        .padding(5.dp)
        .height(10.dp)
        .width(width.value)
        .clip(CircleShape)
        .background(if (isselected) color else Color.Gray.copy(alpha = 0.5f)))
}


// OnBording Data :
fun OnBoardingData():ArrayList<OnBoardingData>
{
    val items=ArrayList<OnBoardingData>()
    items.add(
        OnBoardingData(
            R.drawable.food,
            "First Page",
            "Not only food. we provide clear healthy drink options for you. Fresh taste always accompanies you",
            backgroundColor = Color(0xFFE4AF19),
            mainColor = ColorYellow
        )
    )

    items.add(
        OnBoardingData(
            R.drawable.fruit,
            "Second Page",
            "A variety of healthy foods made by the best chefs. Ingredients are easy to find. all delicious flavors can only be found at cookbunda",
            backgroundColor = Color(0xFF0189C5),
            mainColor = Color(0xFF00B5EA)
        )
    )

    items.add(
        OnBoardingData(
            R.drawable.cooking,
            "Third Page",
            "Are you ready to make a dish for your friends or family? create an account and cook",
            backgroundColor = Color(0xFF96E172),
            mainColor = ColorGreen
        )
    )
    return items
}

@Composable
fun Screen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(ColorGreen))

}