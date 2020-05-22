package com.example.movieapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class PopularMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popular_movie)
        title = "Популярные фильмы" // заголовок
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // кнопка "назад"
    }

    override fun onSupportNavigateUp(): Boolean { // действие по кнопке "назад"
        onBackPressed() // действие
        return super.onSupportNavigateUp()
    }
}
