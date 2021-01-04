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
import org.wit.scorewriter.models.ScoreModel

class ScoreListActivity : AppCompatActivity() {

    val scores = ArrayList<ScoreModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_list)
        setSupportActionBar(toolbar_main)

        scores.add(ScoreModel("Giant Steps", "John Coltrane"))
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = ScoreListAdapter(scores)
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
}

class ScoreListAdapter(private val scores: ArrayList<ScoreModel>) :
        RecyclerView.Adapter<ScoreListAdapter.MainHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.card_score, parent, false)

        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(scores[position])
    }

    override fun getItemCount(): Int = scores.size

    class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        fun bind(score: ScoreModel) {
            itemView.scoreTitle.text = score.title
            itemView.scoreArtist.text = score.artist
        }
    }
}