package com.example.superheroesapp.model

import androidx.annotation.DrawableRes

data class SuperHero(
    val superHeroName : String,
    val description : String,
    @DrawableRes val imageRes : Int
)

