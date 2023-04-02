package com.example.decideit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.decideit.databinding.ActivityActionBinding
import java.util.*

class action : AppCompatActivity() {
    val movieList = arrayListOf("John Wick", "Shazam!", "Avatar","Bullet Train","The Hunger Games")
    val random = Random()
    var randomMovie : Int = 0

    private lateinit var binding: ActivityActionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.actionDecideBtn.setOnClickListener {
            randomMovie = random.nextInt(movieList.count())
            binding.actionMovTxt.text = movieList[randomMovie]
        }

        binding.actionAddBtn.setOnClickListener {
            val newMovie = binding.actionAddMovEdit.text.toString()
            if (newMovie.isEmpty() || newMovie.isBlank()){
                Toast.makeText(applicationContext, "Enter a movie", Toast.LENGTH_SHORT).show()

            }
            else {
                movieList.add(newMovie)

            }

            binding.actionAddMovEdit.text.clear()
        }

        binding.actionDelBtn.setOnClickListener {
            if (movieList.isEmpty()){
                Toast.makeText(applicationContext, "No more movies left", Toast.LENGTH_SHORT).show()
            }
            else {
                movieList.removeAt(randomMovie)

            }

        }


    }
}