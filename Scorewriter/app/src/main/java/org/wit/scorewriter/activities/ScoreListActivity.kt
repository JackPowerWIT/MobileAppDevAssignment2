package org.wit.scorewriter.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_score_list.*
import kotlinx.android.synthetic.main.card_score.view.*
import org.wit.scorewriter.R
import org.wit.scorewriter.main.MainApp
import org.wit.scorewriter.models.ScoreModel

const val EXTRA_SCORE = "org.wit.scorewriter.SCORE"

class ScoreListActivity : AppCompatActivity(), ScoreItemListener {

    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_list)
        app = application as MainApp
        setSupportActionBar(toolbar_main)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = ScoreListAdapter(app.scores.findAll(), this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_add -> {
            startActivity(Intent(this, ScoreActivity::class.java))
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun onScoreItemClick(score: ScoreModel) {
        val intent = Intent(this, ScoreActivity::class.java).apply {
            putExtra(EXTRA_SCORE, score)
        }
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        recyclerView.adapter?.notifyDataSetChanged()
        super.onActivityResult(requestCode, resultCode, data)
    }
}

interface ScoreItemListener {
    fun onScoreItemClick(score: ScoreModel)
}

class ScoreListAdapter(
        private val scores: List<ScoreModel>,
        private val listener: ScoreItemListener
) :
        RecyclerView.Adapter<ScoreListAdapter.MainHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.card_score, parent, false)

        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(scores[position], listener)
    }

    override fun getItemCount(): Int = scores.size

    class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        fun bind(score: ScoreModel, listener: ScoreItemListener) {
            itemView.scoreTitle.text = score.title
            itemView.scoreArtist.text = score.artist
            itemView.setOnClickListener { listener.onScoreItemClick(score) }
        }
    }
}