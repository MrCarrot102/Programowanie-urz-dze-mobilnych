package com.example.maslolot.model

class LevelManager {
    fun increaseDifficulty(gameState: GameState){
        gameState.level++
        val newEnemies = List(gameState.level * 2){
            Enemy(
                x = (0..200).random().toFloat(),
                y = 0f,
                speed = (1..3).random().toFloat()
            )
        }
        gameState.enemies.addAll(newEnemies)
    }
}