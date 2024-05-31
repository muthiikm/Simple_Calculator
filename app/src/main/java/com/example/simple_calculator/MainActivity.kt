package com.example.simple_calculator
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.simple_calculator.databinding.ActivityMainBinding
import com.example.simple_calculator.viewmodel.CalculatorViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: CalculatorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.input.observe(this, { input ->
            binding.textView.text = input
        })

        viewModel.result.observe(this, { result ->
            binding.result.text = result
        })

        setUpButtons()
    }

    private fun setUpButtons() {
        binding.btn0.setOnClickListener { viewModel.onDigit("0") }
        binding.btn1.setOnClickListener { viewModel.onDigit("1") }
        binding.btn2.setOnClickListener { viewModel.onDigit("2") }
        binding.btn3.setOnClickListener { viewModel.onDigit("3") }
        binding.btn4.setOnClickListener { viewModel.onDigit("4") }
        binding.btn5.setOnClickListener { viewModel.onDigit("5") }
        binding.btn6.setOnClickListener { viewModel.onDigit("6") }
        binding.btn7.setOnClickListener { viewModel.onDigit("7") }
        binding.btn8.setOnClickListener { viewModel.onDigit("8") }
        binding.btn9.setOnClickListener { viewModel.onDigit("9") }
        binding.btnDecimal.setOnClickListener { viewModel.onDigit(".") }

        binding.btnAdd.setOnClickListener { viewModel.onOperator("+") }
        binding.btnSubtract.setOnClickListener { viewModel.onOperator("-") }
        binding.btnMultiply.setOnClickListener { viewModel.onOperator("*") }
        binding.btnDivide.setOnClickListener { viewModel.onOperator("/") }
        binding.btnModulus.setOnClickListener { viewModel.onOperator("%") }

        binding.btnEqual.setOnClickListener { viewModel.onEqual() }
        binding.btnClear.setOnClickListener { viewModel.onClear() }
        binding.btnDelete.setOnClickListener { viewModel.onDelete() }
    }
}
