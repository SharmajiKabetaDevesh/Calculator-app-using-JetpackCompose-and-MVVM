package com.example.calculatorappcompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel(){
    companion object{
        private const val MAX_NUM_LEN=8
    }
    var state by mutableStateOf(CalculatorState())

    fun onAction(action:CalcActions){
        when(action){
            is CalcActions.Number -> enterNumber(action.number)
            is CalcActions.Decimal -> enterDecimal()
            is CalcActions.Clear -> state = CalculatorState()
            is CalcActions.operation ->enterOperation(action.operation)
            is CalcActions.Calculate->performCalcultation()
            is CalcActions.Delete ->perfromDeletion();
        }
    }

    fun enterNumber(number:Int){
          if(state.operation==null){
              if(state.number1.length>=MAX_NUM_LEN){
                  return
              }
              state=state.copy(
                  number1=state.number1+number
              )
              return
          }
        if(state.number2.length>=MAX_NUM_LEN){
            return
        }
        state=state.copy(
            number2=state.number2+number
        )
    }
    fun enterDecimal(){
           if(state.operation==null &&  !state.number1.contains(".")
                   && state.number1.isNotBlank()){
                  state=state.copy(
                      number1 =state.number1+'.'
                  )
               return
        }

        if(!state.number2.contains(".") && state.number2.isNotBlank()){
            state=state.copy(
                number2=state.number2+"."
            )
        }

    }
    fun enterOperation(operation:CalculatorOperation){
        if(state.number1.isNotBlank()){
            state=state.copy(operation= operation)
        }

    }
    fun performCalcultation(){
            val number1=state.number1.toDoubleOrNull()
        val number2=state.number2.toDoubleOrNull()
        if(number1!=null && number2 !=null){
        val result=when(state.operation){
            is CalculatorOperation.Add ->number1+ number2
            is CalculatorOperation.Subtract->number1-number2
            is CalculatorOperation.Multiply->number1/number2
            is CalculatorOperation.Divide ->number1*number2
            else -> 0
        }
            state=state.copy(
                number1=result.toString().take(15),
                number2="",
                operation = null
            )

        }
    }
    fun perfromDeletion(){
              when {
                  state.number2.isNotBlank()->state=state.copy(
                      number2=state.number2.dropLast(1)
                  )
                  state.operation !=null -> state=state.copy(
                      operation = null
                  )
                  state.number1.isNotBlank()->state=state.copy(
                      number1 = state.number1.dropLast(1)
                  )

              }

    }


}