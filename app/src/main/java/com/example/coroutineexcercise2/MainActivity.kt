package com.example.coroutineexcercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coroutineexcercise2.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.lifecycle.lifecycleScope


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var currentValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val inputText = binding.edittext1.text.toString()
            val inputNumber = inputText.toIntOrNull()

            if (inputNumber != null) {
                lifecycleScope.launch {
                    delay(2000)
                    currentValue = inputNumber + 1
                    binding.textview1.text = currentValue.toString()
                }
            }
        }
    }
}