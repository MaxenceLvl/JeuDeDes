package com.example.jeudedes

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jeudedes.beans.Partie

class MainActivity : AppCompatActivity(), View.OnClickListener {
    //Éléments graphique
    private var tvTour: TextView? = null
    private var tvScoreJ1: TextView? = null
    private var ivJ1: ImageView? = null
    private var tvScoreJ2: TextView? = null
    private var ivJ2: ImageView? = null
    private var btnLancer: Button? = null
    private var tvDe1: TextView? = null
    private var tvDe2: TextView? = null

    //Données
    private var partie: Partie? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvTour = findViewById<View>(R.id.tvTour) as TextView
        tvScoreJ1 = findViewById<View>(R.id.tvScoreJ1) as TextView
        ivJ1 = findViewById<View>(R.id.ivJ1) as ImageView
        tvScoreJ2 = findViewById<View>(R.id.tvScoreJ2) as TextView
        ivJ2 = findViewById<View>(R.id.ivJ2) as ImageView
        btnLancer = findViewById<View>(R.id.btnLancer) as Button
        tvDe1 = findViewById<View>(R.id.tvDe1) as TextView
        tvDe2 = findViewById<View>(R.id.tvDe2) as TextView
        btnLancer!!.setOnClickListener(this)
        partie = Partie("Joueur1", "Joueur2")
    }

    override fun onClick(v: View) {
        if (v === btnLancer) {
            partie!!.joueurSuivant.lancer()
            if (partie!!.joueurSuivant.scoreDes >= Partie.NB_A_ATTEINDRE) {
                partie!!.joueurSuivant.score = partie!!.joueurSuivant.score + 1
            }
            partie!!.changerJoueur()
            if (partie!!.joueurSuivant === partie!!.j1) {
                partie!!.tour = partie!!.tour + 1
            }
            rafraichirEcran()
        }
    }

    private fun rafraichirEcran() {
        tvTour!!.text = partie!!.tour.toString() + ""
        tvScoreJ1!!.text = partie!!.j1.score.toString() + ""
        tvScoreJ2!!.text = partie!!.j2.score.toString() + ""
        if (partie!!.j1 === partie!!.joueurSuivant) {
            ivJ1!!.visibility = View.VISIBLE
            ivJ2!!.visibility = View.INVISIBLE
            tvDe1!!.text = partie!!.j2.de1.toString() + ""
            tvDe2!!.text = partie!!.j2.de2.toString() + ""
        } else {
            ivJ1!!.visibility = View.INVISIBLE
            ivJ2!!.visibility = View.VISIBLE
            tvDe1!!.text = partie!!.j1.de1.toString() + ""
            tvDe2!!.text = partie!!.j1.de2.toString() + ""
        }
        if (partie!!.tour == Partie.NB_LANCER + 1) {
            Toast.makeText(this, "Partie terminé", Toast.LENGTH_SHORT).show()
            val intent = intent
            finish()
            startActivity(intent)
        }
    }
}