package com.example.arjun.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shape = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)
val BottomCardShape = Shapes(
    large = RoundedCornerShape(topStart = 80.dp, bottomEnd = 80.dp, topEnd = 10.dp, bottomStart = 10.dp) ,
    )

val BottomBoxShape = Shapes(
    medium = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomEnd = 20.dp, bottomStart = 20.dp)
)

val InputBoxShape = Shapes(
    medium = RoundedCornerShape(14.dp)
)