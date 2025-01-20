package com.example.maslolot.model

object CollisionHandler{
    fun detectCollision(bullet: Bullet, enemy: Enemy):Boolean{
        return (bullet.x in (enemy.x - 20)..(enemy.x + 20)) &&
                (bullet.y in (enemy.y - 20)..(enemy.y + 20))
    }
}