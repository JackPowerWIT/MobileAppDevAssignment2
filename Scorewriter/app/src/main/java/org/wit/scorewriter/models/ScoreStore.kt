package org.wit.scorewriter.models

interface ScoreStore {
    fun findAll(): List<ScoreModel>
    fun create(score: ScoreModel)
    fun update(score: ScoreModel)
}