package com.example.maslolot.model

object CollisionHandler{
    fun detectCollision(bullet: Bullet, enemy: Enemy):Boolean{
        return (bullet.x in (enemy.x - 40)..(enemy.x + 40)) &&
                (bullet.y in (enemy.y - 40)..(enemy.y + 40))
    }
    fun detectCollisionPlayer(enemy: Enemy, player: Player): Boolean{
        return (enemy.x in (player.x - 40) .. (player.x + 40)) &&
                (enemy.y in (player.y - 40).. (player.y +40))
    }
}