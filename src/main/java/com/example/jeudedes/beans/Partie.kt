package com.example.jeudedes.beans

class Partie(nomJ1: String?, nomJ2: String?) {
    val j1: Joueur
    val j2: Joueur
    var tour: Int
    var joueurSuivant: Joueur
        private set

    fun changerJoueur() {
        joueurSuivant = if (joueurSuivant == j1) {
            j2
        } else {
            j1
        }
    }

    companion object {
        const val NB_LANCER = 10
        const val NB_A_ATTEINDRE = 7
    }

    init {
        j1 = Joueur(nomJ1!!)
        j2 = Joueur(nomJ2!!)
        joueurSuivant = j1
        tour = 1
    }
}