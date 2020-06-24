package com.example.jeudedes.beans

class Gobelet {
    var de1: De
    var de2: De
    fun lancer() {
        de1.lancer()
        de2.lancer()
    }

    val scoreDes: Int
        get() = de1.valeur + de2.valeur

    init {
        de1 = De()
        de2 = De()
    }
}