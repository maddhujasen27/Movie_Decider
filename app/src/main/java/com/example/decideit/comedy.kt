package com.example.decideit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.decideit.databinding.ActivityActionBinding
import com.example.decideit.databinding.ActivityComedyBinding
import java.util.*

class comedy : AppCompatActivity() {
    val movieList = arrayListOf("Renfield", "The Menu", "Champions","Joy Ride","We Have a Ghost")
    val random = Random()
    var randomMovie : Int = 0

    private lateinit var binding: ActivityComedyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComedyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.comedyDecideBtn.setOnClickListener {
            randomMovie = random.nextInt(movieList.count())
            binding.comedyMovTxt.text = movieList[randomMovie]
        }

        binding.comedyAddBtn.setOnClickListener {
            val newMovie = binding.comedyAddMovEdit.text.toString()
            if (newMovie.isEmpty() || newMovie.isBlank()){
                Toast.makeText(applicationContext, "Enter a movie", Toast.LENGTH_SHORT).show()

            }
            else {
                movieList.add(newMovie)

            }

            binding.comedyAddMovEdit.text.clear()
        }

        binding.comedyDelBtn.setOnClickListener {
            if (movieList.isEmpty()){
                Toast.makeText(applicationContext, "No more movies left", Toast.LENGTH_SHORT).show()
            }
            else {
                movieList.removeAt(randomMovie)

            }

        }


    }
}