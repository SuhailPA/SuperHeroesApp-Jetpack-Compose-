package com.example.superheroesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroesapp.data.SuperHeroData
import com.example.superheroesapp.model.SuperHero
import com.example.superheroesapp.ui.theme.SuperHeroesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperHeroesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SuperHeroList(SuperHeroData.heros)
                }
            }
        }
    }
}

@Composable
fun SuperHeroList(superHeroes: List<SuperHero>, modifier: Modifier = Modifier) {
    LazyColumn() {
        items(superHeroes) { superHero ->
            SuperHeroCardItem(superHero = superHero)
        }
    }
}

@Composable
fun SuperHeroCardItem(superHero: SuperHero, modifier: Modifier = Modifier) {
    var expand by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = modifier
            .padding(5.dp)
            .animateContentSize(
                spring(Spring.DampingRatioMediumBouncy, Spring.StiffnessLow)
            )
    ) {
        Column() {
            Row(
                modifier = Modifier
                    .padding(5.dp)
                    .height(72.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = superHero.superHeroName)
                Spacer(modifier = Modifier.weight(1F))
                Image(
                    painter = painterResource(id = superHero.imageRes),
                    contentDescription = superHero.superHeroName,
                    modifier = Modifier
                        .clip(RoundedCornerShape(15.dp))
                        .clickable {
                            expand = !expand
                        }
                )
            }
            if (expand) DogDescriptionUI(superHero = superHero)
        }


    }
}

@Composable
fun DogDescriptionUI(superHero: SuperHero) {
    Row(
        Modifier.padding(10.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = superHero.description, modifier = Modifier.fillMaxWidth())
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreviewDarkTheme() {
    SuperHeroesAppTheme(darkTheme = true) {
        SuperHeroList(superHeroes = SuperHeroData.heros)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    SuperHeroesAppTheme(darkTheme = false) {
        SuperHeroList(superHeroes = SuperHeroData.heros)
    }
}