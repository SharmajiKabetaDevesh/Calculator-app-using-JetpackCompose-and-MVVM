package com.example.calculatorappcompose


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Calculatoe(
    modifier:Modifier=Modifier,
    state:CalculatorState,
    buttonSpacing: Dp =8.dp,

    onAction:(CalcActions)->Unit

){
       Box(modifier=modifier){
           Column(
               modifier=Modifier.fillMaxWidth()
                   .align(Alignment.BottomCenter),
               verticalArrangement = Arrangement.spacedBy(buttonSpacing)
           ) {
                     Text(
                         text=state.number1 +(state.operation?.symbol ?:"")+state.number2,
                         textAlign= TextAlign.End,
                         modifier=Modifier
                             .fillMaxWidth()
                             .fillMaxHeight(0.45f)
                             .padding(vertical =32.dp),
                         fontWeight = FontWeight.Light,
                         fontSize = 80.sp,
                         color= Color.White,
                         maxLines=2
                     )
               Row(
                   modifier=Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
               ){
                 CalcButton(
                    symbol="AC",
                     modifier=Modifier
                         .background(Color.Magenta)
                         .aspectRatio(2f)
                         .weight(2f),
                     onClick={
                         onAction(CalcActions.Clear)
                     }
                 )
                   CalcButton(
                       symbol="D",

                       modifier=Modifier
                           .background(Color.Red)
                           .aspectRatio(1f)
                           .weight(1f),
                       onClick={
                           onAction(CalcActions.Delete)
                       }
                   )

                   CalcButton(
                       symbol="/",
                       modifier=Modifier
                           .background(Color.Cyan)
                           .aspectRatio(2f)
                           .weight(2f),
                       onClick={
                           onAction(CalcActions.operation(CalculatorOperation.Divide))
                       }
                   )
               }

               Row(
                   modifier=Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
               ){
                   CalcButton(
                       symbol="7",
                       modifier=Modifier
                           .background(Color.DarkGray)
                           .aspectRatio(1f)
                           .weight(1f),
                       onClick={
                           onAction(CalcActions.Number(7))
                       }
                   )
                   CalcButton(
                       symbol="8",
                       modifier=Modifier
                           .background(Color.DarkGray)
                           .aspectRatio(1f)
                           .weight(1f),
                       onClick={
                           onAction(CalcActions.Number(8))
                       }
                   )

                   CalcButton(
                       symbol="9",
                       modifier=Modifier
                           .background(Color.DarkGray)
                           .aspectRatio(1f)
                           .weight(1f),
                       onClick={
                           onAction(CalcActions.Number(9))
                       }
                   )
                   CalcButton(
                       symbol="*",
                       modifier=Modifier
                           .background(Color.Cyan)
                           .aspectRatio(1f)
                           .weight(1f),
                       onClick={
                           onAction(CalcActions.operation(CalculatorOperation.Multiply))
                       }
                   )
               }

               Row(
                   modifier=Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
               ){
                   CalcButton(
                       symbol="4",
                       modifier=Modifier
                           .background(Color.DarkGray)
                           .aspectRatio(1f)
                           .weight(1f),
                       onClick={
                           onAction(CalcActions.Number(4))
                       }
                   )
                   CalcButton(
                       symbol="5",
                       modifier=Modifier
                           .background(Color.DarkGray)
                           .aspectRatio(1f)
                           .weight(1f),
                       onClick={
                           onAction(CalcActions.Number(5))
                       }
                   )

                   CalcButton(
                       symbol="6",
                       modifier=Modifier
                           .background(Color.DarkGray)
                           .aspectRatio(1f)
                           .weight(1f),
                       onClick={
                           onAction(CalcActions.Number(6))
                       }
                   )
                   CalcButton(
                       symbol="-",
                       modifier=Modifier
                           .background(Color.Cyan)
                           .aspectRatio(1f)
                           .weight(1f),
                       onClick={
                           onAction(CalcActions.operation(CalculatorOperation.Subtract))
                       }
                   )
               }

               Row(
                   modifier=Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
               ){
                   CalcButton(
                       symbol="1",
                       modifier=Modifier
                           .background(Color.DarkGray)
                           .aspectRatio(1f)
                           .weight(1f),
                       onClick={
                           onAction(CalcActions.Number(1))
                       }
                   )
                   CalcButton(
                       symbol="2",
                       modifier=Modifier
                           .background(Color.DarkGray)
                           .aspectRatio(1f)
                           .weight(1f),
                       onClick={
                           onAction(CalcActions.Number(2))
                       }
                   )

                   CalcButton(
                       symbol="3",
                       modifier=Modifier
                           .background(Color.DarkGray)
                           .aspectRatio(1f)
                           .weight(1f),
                       onClick={
                           onAction(CalcActions.Number(3))
                       }
                   )
                   CalcButton(
                       symbol="+",
                       modifier=Modifier
                           .background(Color.Cyan)
                           .aspectRatio(1f)
                           .weight(1f),
                       onClick={
                           onAction(CalcActions.operation(CalculatorOperation.Add))
                       }
                   )
               }

               Row(
                   modifier=Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
               ){
                   CalcButton(
                       symbol="0",
                       modifier=Modifier
                           .background(Color.DarkGray)
                           .aspectRatio(2f)
                           .weight(2f),
                       onClick={
                           onAction(CalcActions.Number(0))
                       }
                   )
                   CalcButton(
                       symbol=".",
                       modifier=Modifier
                           .background(Color.DarkGray)
                           .aspectRatio(1f)
                           .weight(1f),
                       onClick={
                           onAction(CalcActions.Decimal)
                       }
                   )

                   CalcButton(
                       symbol="=",
                       modifier=Modifier
                           .background(Color.DarkGray)
                           .aspectRatio(1f)
                           .weight(1f),
                       onClick={
                           onAction(CalcActions.Calculate)
                       }
                   )

               }
           }
       }
}