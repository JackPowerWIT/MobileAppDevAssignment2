package org.wit.scorewriter.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_score.*
import org.wit.scorewriter.R

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        setSupportActionBar(toolbar_score)
        // enable up button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}