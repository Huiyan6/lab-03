package com.example.listycity3

data class City(
    val name: String, // These can be changed because they are class properties
    val province: String // Not function parameters, for some reason class properties are different
)
