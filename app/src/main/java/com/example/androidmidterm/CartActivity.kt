package com.example.androidmidterm

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidmidterm.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {

    lateinit var binding: ActivityCartBinding
    private var count: Int = 1
    private val price: Int = 120

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityCartBinding.inflate(layoutInflater)

        setContentView(binding.root)

        test()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun test() = with(binding) {
        back.setOnClickListener {
            val intent = Intent(this@CartActivity, ItemActivity::class.java)
            startActivity(intent)
        }

        placeOrder.setOnClickListener {
            val intent = Intent(this@CartActivity, SuccessActivity::class.java)
            startActivity(intent)
        }

        quantity.text = "$count"
        quantity2.text = "$count"

        textView7.text = "$price"
        val tot = count * price
        total.text = "$tot"

        plus.setOnClickListener {
            count++
            quantity.text = "$count"
            quantity2.text = "$count"

            textView7.text = "$price"
            val tot = count * price
            total.text = "$tot"
        }

        minus.setOnClickListener {
            if (count > 0) {
                count--
                quantity.text = "$count"
                quantity2.text = "$count"

                textView7.text = "$price"
                val tot = count * price
                total.text = "$tot"
            }
        }
    }
}