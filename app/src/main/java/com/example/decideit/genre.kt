package com.example.decideit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.decideit.databinding.ActivityGenreBinding



class genre : AppCompatActivity() {
    private lateinit var binding: ActivityGenreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGenreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.dramaBtn.setOnClickListener {
            val intent = Intent(this, drama::class.java)
            startActivity(intent)
        }
        binding.actionBtn.setOnClickListener {
            val intent = Intent(this, action::class.java)
            startActivity(intent)
        }

        binding.comedyBtn.setOnClickListener {
            val intent = Intent(this, comedy::class.java)
            startActivity(intent)
        }

        binding.romanceBtn.setOnClickListener {
            val intent = Intent(this, romance::class.java)
            startActivity(intent)
        }

        binding.thrillerBtn.setOnClickListener {
            val intent = Intent(this, thriller::class.java)
            startActivity(intent)
        }
    }
}