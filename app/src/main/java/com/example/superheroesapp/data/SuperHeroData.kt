package com.example.superheroesapp.data

import com.example.superheroesapp.R
import com.example.superheroesapp.model.SuperHero

object SuperHeroData {
    val heros = listOf<SuperHero>(
        SuperHero(
            "SuperMan",
            "One of the SuperHero who can save the world",
            R.drawable.android_superhero1
        ),
        SuperHero(
            "SpiderMan",
            "One of the SuperHero who have the power of spider web",
            R.drawable.android_superhero2
        ),
        SuperHero(
            "Batman",
            "One of the Superher who have the power of Bat",
            R.drawable.android_superhero3
        ),
        SuperHero(
            "Hulk",
            "SuperHero who have the power to become a Powerful man",
            R.drawable.android_superhero4
        ),
        SuperHero(
            "Thor",
            "SuperHero who have the power of Thunder",
            R.drawable.android_superhero5
        ),
        SuperHero(
            "Flash",
            "Superhero who have the power of Speed",
            R.drawable.android_superhero6
        )
    )
}