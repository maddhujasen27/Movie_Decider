package com.example.decideit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.decideit.databinding.ActivityDramaBinding
import java.util.*


class drama : AppCompatActivity() {
    val movieList = arrayListOf("Air", "The Whale", "65","Babylon","Elvis")
    val random = Random()
    var randomMovie : Int = 0

    private lateinit var binding: ActivityDramaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDramaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.dramaDecideBtn.setOnClickListener {
            //val random = Random()
            randomMovie = random.nextInt(movieList.count())
            binding.dramaMovTxt.text = movieList[randomMovie]
        }

        binding.dramaAddBtn.setOnClickListener {
            val newMovie = binding.dramaAddMovEdit.text.toString()
            if (newMovie.isEmpty() || newMovie.isBlank()){
                Toast.makeText(applicationContext, "Enter a movie", Toast.LENGTH_SHORT).show()

            }
            else {
                movieList.add(newMovie)
                //println(movieList[randomMovie])

            }

            binding.dramaAddMovEdit.text.clear()
        }

        binding.dramaDelBtn.setOnClickListener {
            if (movieList.isEmpty()){
                Toast.makeText(applicationContext, "No more movies left", Toast.LENGTH_SHORT).show()
            }
            else {
                movieList.removeAt(randomMovie)

            }

        }


    }
}