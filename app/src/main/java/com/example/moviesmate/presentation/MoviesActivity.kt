package com.example.moviesmate.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moviesmate.databinding.ActivityMoviesBinding

class MoviesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoviesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}