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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        app = application as MainApp

        setSupportActionBar(toolbar_score)
        // enable up button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnAdd.setOnClickListener(){
            val title = titleField.text.toString()
            val artist = artistField.text.toString()
            if (title.isNotEmpty() && artist.isNotEmpty()){
                app.scores.add(ScoreModel(title, artist))
                finish()
            }
        }
    }
}