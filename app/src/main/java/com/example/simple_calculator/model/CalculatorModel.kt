package com.example.simple_calculator.model

class CalculatorModel {
    private var operand1: Double = 0.0
    private var operand2: Double = 0.0
    private var operator: String = ""

    fun setOperand1(value: Double) {
        operand1 = value
    }

    fun setOperand2(value: Double) {
        operand2 = value
    }

    fun setOperator(op: String) {
        operator = op
    }

    fun calculate(): Double {
        return when (operator) {
            "+" -> operand1 + operand2
            "-" -> operand1 - operand2
            "*" -> operand1 * operand2
            "/" -> operand1 / operand2
            "%" -> operand1 % operand2
            else -> 0.0
        }
    }

    fun clear() {
        operand1 = 0.0
        operand2 = 0.0
        operator = ""
    }
}
