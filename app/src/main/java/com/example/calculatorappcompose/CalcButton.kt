package com.example.calculatorappcompose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.unit.sp

@Composable
fun CalcButton(
    symbol:String,
    modifier: Modifier =Modifier,
    onClick:()->Unit,
    textSize:Int=36
){

    Box(
        contentAlignment = Alignment.Center,
        modifier=Modifier
            .clip(CircleShape)

            .clickable { onClick() }
            .then(modifier)
        ,
    ){
           Text(text=symbol,
               fontSize = textSize.sp,
               color= Color.White)
    }

}