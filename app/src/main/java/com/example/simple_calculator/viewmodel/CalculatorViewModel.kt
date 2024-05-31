package com.example.simple_calculator.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simple_calculator.model.CalculatorModel


class CalculatorViewModel : ViewModel() {

    private val _input = MutableLiveData<String>()
    private val calculatorModel = CalculatorModel()
    val input: LiveData<String> get() = _input

    private val _result = MutableLiveData<String>()
    val result: LiveData<String> get() = _result

    init {
        _input.value = ""
        _result.value = "0"
    }

    fun onDigit(digit: String) {
        _input.value =(_input.value?:"") + digit
    }

    fun onOperator(operator: String) {
        if (_input.value!!.isNotEmpty()) {
            calculatorModel.setValue1(_input.value?.toDouble() ?: 0.0)
            calculatorModel.setValue(operator)
            _input.value = ""
        }
    }

    fun onEqual() {
        if (_input.value?.isNotEmpty() == true) {

            calculatorModel.setValue2(_input.value?.toDouble() ?: 0.0)
            val res = calculatorModel.calculate()
            _result.value = res.toString()
            _input.value = res.toString()
        }
    }

    fun onClear() {
        calculatorModel.clear()
        _input.value = ""
        _result.value = "0"
    }

    fun onDelete() {
        _input.value = _input.value?.dropLast(1)
    }
}
