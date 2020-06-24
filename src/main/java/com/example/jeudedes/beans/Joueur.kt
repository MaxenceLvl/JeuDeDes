package com.example.jeudedes.beans

class Joueur(val nom: String) {
    var score: Int
    val gobelet: Gobelet
    fun lancer() {
        gobelet.lancer()
    }

    val scoreDes: Int
        get() = gobelet.scoreDes

    val de1: Int
        get() = gobelet.de1.valeur

    val de2: Int
        get() = gobelet.de2.valeur

    init {
        gobelet = Gobelet()
        score = 0
    }
}