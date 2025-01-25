package com.example.maslolot.model

class GameState{

    var enemies: MutableList<Enemy> = mutableListOf(
        Enemy(50f,0f,2f),
        Enemy(150f,-100f,2.5f)
    )
    var level: Int = 0
}