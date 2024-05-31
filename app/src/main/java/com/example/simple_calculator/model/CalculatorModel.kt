package com.example.simple_calculator.model

class CalculatorModel {
    private var value1: Double = 0.0
    private var value2: Double = 0.0
    private var operator: String = ""

    fun setValue1(value: Double) {
        value1 = value
    }

    fun setValue2(value: Double) {
        value2 = value
    }

    fun setValue(op: String) {
        operator = op
    }

    fun calculate(): Double {
        return when (operator) {
            "+" -> value1 + value2
            "-" -> value1 - value2
            "*" -> value1 * value2
            "/" -> value1 / value2
            "%" -> value1 % value2
            else -> 0.0
        }
    }

    fun clear() {
        value1 = 0.0
        value2 = 0.0
        operator = ""
    }
}
