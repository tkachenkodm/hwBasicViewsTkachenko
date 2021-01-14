package com.example.hwbasicviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.example.hwbasicviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var counter = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIncrement.setOnClickListener {
            counter++

            binding.tvCounter.visibility = View.GONE
            binding.btnIncrement.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE

            binding.tvCounter.text = counter.toInt().toString()

            val delay = counter / 10.0 * 1000

            val handler = Handler()
            handler.postDelayed({
                binding.tvCounter.visibility = View.VISIBLE
                binding.btnIncrement.visibility = View.VISIBLE
                binding.progressBar.visibility = View.GONE
            }, delay.toLong())
        }
    }
}