package io.rybalkinsd.kotlinbootcamp.objects.ObjectTypes

import io.rybalkinsd.kotlinbootcamp.objects.TileType

open class GameObject(val t: TileType) {
    fun isImpassable() = t == TileType.BOMB ||
            t == TileType.BOX ||
            t == TileType.WALL

    fun isBonus() = t == TileType.EXPLOSION_BONUS ||
            t == TileType.SPEED_BONUS ||
            t == TileType.BOMB_BONUS
}