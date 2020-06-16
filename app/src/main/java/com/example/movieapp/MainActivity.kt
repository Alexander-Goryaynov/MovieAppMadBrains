package com.example.movieapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        popularMoviesButton.setOnClickListener{
            val intent = Intent(this, PopularMovieActivity::class.java)
            startActivity(intent)
        }
        favoriteMoviesButton.setOnClickListener{
            val intent = Intent(this, FavoriteMovieActivity::class.java)
            startActivity(intent)
        }
        listButton.setOnClickListener{
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
        exitButton.setOnClickListener{
            finish()
        }
    }
}
