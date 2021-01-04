package org.wit.scorewriter.main

import android.app.Application
import org.wit.scorewriter.models.ScoreModel

class MainApp : Application() {

    val scores = ArrayList<ScoreModel>()

    override fun onCreate() {
        super.onCreate()
        scores.add(ScoreModel("Giant Steps", "John Coltrane"))
    }
}