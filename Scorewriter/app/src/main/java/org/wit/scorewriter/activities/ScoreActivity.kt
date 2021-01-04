package org.wit.scorewriter.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_score.*
import org.wit.scorewriter.R
import org.wit.scorewriter.main.MainApp
import org.wit.scorewriter.models.ScoreModel

class ScoreActivity : AppCompatActivity() {

    lateinit var app: MainApp
    var score = ScoreModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        app = application as MainApp

        setSupportActionBar(toolbar_score)
        // enable up button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        var toUpdate = false

        // check for score extra
        if (intent.hasExtra(EXTRA_SCORE)){
            score = intent.extras?.getParcelable<ScoreModel>(EXTRA_SCORE)!!
            titleField.setText(score.title)
            artistField.setText(score.artist)
            toUpdate = true
        }

        btnAdd.setOnClickListener(){
            score.title = titleField.text.toString()
            score.artist = artistField.text.toString()
            if (score.title.isNotEmpty() && score.artist.isNotEmpty()){
                if (toUpdate){
                    app.scores.update(score)
                }
                else {
                    app.scores.create(score.copy())
                }
                setResult(AppCompatActivity.RESULT_OK)
                finish()
            }
        }
    }
}