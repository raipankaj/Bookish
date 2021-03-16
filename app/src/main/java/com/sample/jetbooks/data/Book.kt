package com.sample.jetbooks.data

data class Book(
    val name: String, val author: String, val image: String,
    val description: String
) {
    constructor() : this("", "", "", "")
}