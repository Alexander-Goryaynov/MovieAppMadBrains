package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        title = "Список цветов"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setList()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    fun setList() {
        val colors = listOf(
            "Красный",
            "Жёлтый",
            "Зелёный",
            "Синий",
            "Красный",
            "Жёлтый",
            "Зелёный",
            "Синий",
            "Красный",
            "Жёлтый",
            "Зелёный",
            "Синий",
            "Красный",
            "Жёлтый",
            "Зелёный",
            "Синий",
            "Красный",
            "Жёлтый",
            "Зелёный",
            "Красный",
            "Жёлтый",
            "Зелёный",
            "Синий",
            "Красный",
            "Жёлтый",
            "Зелёный",
            "Синий",
            "Красный",
            "Жёлтый",
            "Зелёный",
            "Синий",
            "Красный",
            "Жёлтый",
            "Зелёный",
            "Синий",
            "Красный",
            "Жёлтый",
            "Зелёный",
            "Синий"
        )
        val adapter = ListAdapter(colors)
        recyclerId.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        recyclerId.layoutManager = layoutManager
    }
}
