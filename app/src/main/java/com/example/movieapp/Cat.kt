package com.example.movieapp

import io.realm.RealmObject

open class Cat: RealmObject() {
    lateinit var text: String
    lateinit var image: String
}