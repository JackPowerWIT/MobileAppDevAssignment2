package org.wit.scorewriter.main

import android.app.Application
import org.wit.scorewriter.models.ScoreMemStore

class MainApp : Application() {
    val scores = ScoreMemStore()
}