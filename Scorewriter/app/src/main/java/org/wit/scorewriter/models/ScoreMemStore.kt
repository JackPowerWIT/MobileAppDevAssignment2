package org.wit.scorewriter.models

import android.util.Log

var lastId = 0L

internal fun newId(): Long {
    return lastId++
}

class ScoreMemStore : ScoreStore {

    val scores = ArrayList<ScoreModel>()

    override fun findAll(): List<ScoreModel> {
        return scores
    }

    override fun create(score: ScoreModel) {
        score.id = newId()
        scores.add(score)
        Log.i("create","Created score $score")
    }

    override fun update(score: ScoreModel) {
        val foundScore: ScoreModel? = scores.find { s -> s.id == score.id }
        if (foundScore != null){
            foundScore.title = score.title
            foundScore.artist = score.artist
            Log.i("update", "Updated score $score")
        }
    }
}