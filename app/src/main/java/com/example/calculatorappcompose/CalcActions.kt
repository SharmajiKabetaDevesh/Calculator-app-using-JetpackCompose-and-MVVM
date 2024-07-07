package com.example.calculatorappcompose

sealed class CalcActions {
    data class Number(val number:Int):CalcActions()
    object Clear:CalcActions()
    object Delete:CalcActions()
    object Decimal:CalcActions()
    object Calculate:CalcActions()
    data class operation(val operation:CalculatorOperation):CalcActions()

}