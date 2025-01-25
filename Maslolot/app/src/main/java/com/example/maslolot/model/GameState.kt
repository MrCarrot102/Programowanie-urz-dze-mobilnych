package com.example.maslolot.model

class GameState{
    var score: Int = 0
    var player:Player = Player(100f,400f,10f)
    var enemies: MutableList<Enemy> = mutableListOf(
        Enemy(50f,0f,2f),
        Enemy(150f,-100f,2.5f)
    )
    var bullets:MutableList<Bullet> = mutableListOf()
    var level: Int = 0
}