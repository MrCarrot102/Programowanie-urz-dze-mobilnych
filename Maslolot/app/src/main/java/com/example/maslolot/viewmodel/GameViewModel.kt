package com.example.maslolot.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.maslolot.model.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class GameViewModel : ViewModel() {
    val gameState = GameState()
    private val levelManager = LevelManager()
    init {
        startGameLoop()
    }
    fun movePlayer(dx:Float, dy:Float){
        gameState.player.x = (gameState.player.x + dx).coerceIn(0f,200f)
        gameState.player.y = (gameState.player.y + dy).coerceIn(0f,400f)
    }
    private fun startGameLoop() {
        viewModelScope.launch {
            while (true) {
                updateGameState()
                delay(16L)
            }
        }
        viewModelScope.launch{
            while(true){
                delay(10000L)
                levelManager.increaseDifficulty(gameState)
            }
        }
    }

    private fun updateGameState() {
        gameState.enemies.forEach { enemy ->
            enemy.y += enemy.speed
        }
        gameState.bullets.forEach { bullet ->
            bullet.y -= bullet.speed
        }
        detectCollision()
    }

    private fun detectCollision() {
        val iterator = gameState.bullets.iterator()
        while (iterator.hasNext()) {
            val bullet = iterator.next()
            gameState.enemies.find { enemy ->
                CollisionHandler.detectCollision(bullet, enemy)
            }?.let {
                iterator.remove()
                gameState.enemies.remove(it)
                gameState.score += 10
            }
        }
    }
}