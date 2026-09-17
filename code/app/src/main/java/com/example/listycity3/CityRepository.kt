package com.example.listycity3

import androidx.compose.runtime.mutableStateListOf

class CityRepository {
    private val _cities = mutableStateListOf(
        City("Edmonton", "AB"),
        City("Vancouver", "BC"),
        City("Toronto", "ON")
    )

    val cities: List<City>
        get() = _cities

    fun addCity(city: City){
        _cities.add(city)
    }

    // from here we can make a function that updates the Province fields of the cities in the
    // _cities array, that is if we are allowed to change the val to var in City.kt
    // if we are not allowed to do so, then we need to delete the city and create a new city, both are easy to do, lets wait for tmrs lab

    // lets just implement it with deleting the city and assume val is mandatory

    fun updateCity(city: City){
        // check if the city is in the list of the cities
        for (i in 1 until _cities.size)
        {
            // we need to delete the city and update the province
            // however this does introduce a case where the provice can be entered as the same as before
            // should we show an error here? -> no specifications to do so,
            // if user enters a City that is one to one with an existing city, it will just move the city to the
            // bottom of the list (because we delete then readd)
            if (_cities[i].name == city.name){
                _cities.removeAt(i)
                break
            }
        }
        _cities.add(city)

    }

}