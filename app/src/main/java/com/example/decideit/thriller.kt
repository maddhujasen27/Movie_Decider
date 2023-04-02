package com.example.decideit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.decideit.databinding.ActivityRomanceBinding
import com.example.decideit.databinding.ActivityThrillerBinding
import java.util.*

class thriller : AppCompatActivity() {
    val movieList = arrayListOf("Fall", " Boston Strangler", "Knock at the Cabin","Infinity Pool","I See You")
    val random = Random()
    var randomMovie : Int = 0

    private lateinit var binding: ActivityThrillerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThrillerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.thrillerDecideBtn.setOnClickListener {
            randomMovie = random.nextInt(movieList.count())
            binding.thrillerMovTxt.text = movieList[randomMovie]
        }

        binding.thrillerAddBtn.setOnClickListener {
            val newMovie = binding.thrillerAddMovEdit.text.toString()
            if (newMovie.isEmpty() || newMovie.isBlank()){
                Toast.makeText(applicationContext, "Enter a movie", Toast.LENGTH_SHORT).show()

            }
            else {
                movieList.add(newMovie)

            }

            binding.thrillerAddMovEdit.text.clear()
        }

        binding.thrillerDelBtn.setOnClickListener {
            if (movieList.isEmpty()){
                Toast.makeText(applicationContext, "No more movies left", Toast.LENGTH_SHORT).show()
            }
            else {
                movieList.removeAt(randomMovie)

            }

        }


    }
}