package com.example.maslolot.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

import com.example.maslolot.model.Enemy
import com.example.maslolot.model.Player
import com.example.maslolot.ui.components.*

@Composable
fun GameScreen() {
    val playerState = remember { mutableStateOf(Player(x = 100f, y = 400f, speed = 10f)) }
    val enemies = remember { mutableStateListOf(Enemy(x = 50f, y = 0f, speed = 2f)) }

    Box(modifier = Modifier.fillMaxSize()) {
        BackgroundComposable()
        PlayerComposable(
            player = playerState.value,
            onMove = { dx, dy ->
                playerState.value = playerState.value.copy(
                    x = (playerState.value.x + dx).coerceIn(0f, 200f),
                    y = (playerState.value.y + dy).coerceIn(0f, 400f)
                )
            }
        )
        Enemycomposable(enemies = enemies)
        ScoreboardComposable(score = 0)
    }
}


