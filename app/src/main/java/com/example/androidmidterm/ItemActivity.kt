package com.example.androidmidterm

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidmidterm.databinding.ActivityItemBinding
import com.example.androidmidterm.databinding.ActivityMainBinding
import com.google.android.material.carousel.Carousel

class ItemActivity : AppCompatActivity() {

    lateinit var binding: ActivityItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityItemBinding.inflate(layoutInflater)

        setContentView(binding.root)
        test()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun test() = with(binding) {
        appCompatButton2.setOnClickListener {
            val intent = Intent(this@ItemActivity, CartActivity::class.java)
            startActivity(intent)
        }
    }
}