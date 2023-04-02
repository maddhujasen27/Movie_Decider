package com.example.decideit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.decideit.databinding.ActivityComedyBinding
import com.example.decideit.databinding.ActivityRomanceBinding
import java.util.*

class romance : AppCompatActivity() {
    val movieList = arrayListOf("Titanic", "Good Will Hunting", "Blonde","Rye Lane","Empire of Light")
    val random = Random()
    var randomMovie : Int = 0

    private lateinit var binding: ActivityRomanceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRomanceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.romanceDecideBtn.setOnClickListener {
            randomMovie = random.nextInt(movieList.count())
            binding.romanceMovTxt.text = movieList[randomMovie]
        }

        binding.romanceAddBtn.setOnClickListener {
            val newMovie = binding.romanceAddMovEdit.text.toString()
            if (newMovie.isEmpty() || newMovie.isBlank()){
                Toast.makeText(applicationContext, "Enter a movie", Toast.LENGTH_SHORT).show()

            }
            else {
                movieList.add(newMovie)

            }

            binding.romanceAddMovEdit.text.clear()
        }

        binding.romanceDelBtn.setOnClickListener {
            if (movieList.isEmpty()){
                Toast.makeText(applicationContext, "No more movies left", Toast.LENGTH_SHORT).show()
            }
            else {
                movieList.removeAt(randomMovie)

            }

        }


    }
}