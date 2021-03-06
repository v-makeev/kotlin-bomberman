package io.objects

import io.game.Cords
import io.game.Match
import io.game.Player
import io.game.PowerUp
import io.objects.ObjectTypes.BonusType
import io.objects.ObjectTypes.GameObject
import io.util.toJson

class Bonus(val game: Match, val x: Int, val y: Int, val type: BonusType) : GameObject(game.ids++) {
    fun pickUp(p: Player) {
        when (type.name) {
            "BOMBS" -> p.maxNumberOfBombs++
            "SPEED" -> p.speed++
            "RANGE" -> p.explosionSize++
            "PORTAL" -> teleport(p)
            else -> {
            }
        }
        game.addToOutputQueue(PowerUp(id, "Bonus",
                Cords(y * Match.mult, x * Match.mult),
                type.name).toJson())
        game.field[x, y] = Floor()
    }

    private fun teleport(p: Player) {
        val newPos = game.field.getRandomEmptyPos()
        p.updatePos(newPos.x * Match.mult, newPos.y * Match.mult)
        game.addToOutputQueue(p.playerInfo.json())
    }
}