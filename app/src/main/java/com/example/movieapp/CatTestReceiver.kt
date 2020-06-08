package com.example.movieapp

import java.net.URL

fun main() {
    val content = URL(
        "https://raw.githubusercontent.com/gumam/android_course/master/db.json").
        readText()
    print(content)
}