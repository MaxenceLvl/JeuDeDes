package com.example.jeudedes.beans

import java.util.*

class De {
    var valeur = 0
        private set

    fun lancer() {
        valeur = random.nextInt(NB_FACE) + 1
    }

    companion object {
        private const val NB_FACE = 6
        private val random = Random()
    }
}