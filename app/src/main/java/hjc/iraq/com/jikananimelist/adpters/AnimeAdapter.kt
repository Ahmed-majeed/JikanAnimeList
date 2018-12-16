package hjc.iraq.com.jikananimelist.adpters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hjc.iraq.com.jikananimelist.*
import hjc.iraq.com.jikananimelist.activities.AnimeScrollingActivity
import hjc.iraq.com.jikananimelist.models.Anime
import hjc.iraq.com.jikananimelist.utilies.Consts
import kotlinx.android.synthetic.main.item_anime.view.*


class AnimeAdapter(var animeList: List<Anime>) : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_anime, parent, false)
        return AnimeViewHolder(view)

    }

    override fun getItemCount(): Int {
        return animeList.size
    }

    override fun onBindViewHolder(viewHolder: AnimeViewHolder, position: Int) {

        viewHolder.setAnime(animeList[position])


    }

    inner class AnimeViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        init {
            this.view.setOnClickListener {


                val intent = Intent(it.context, AnimeScrollingActivity::class.java).apply {


                    putExtra(Consts.ANIME_DETAILS, animeList[layoutPosition])


                }
                view.context.startActivity(intent)


            }
        }

        fun setAnime(anime: Anime) {
            view.animeTitleTextView.text = anime.title
            view.scoreTextView.text = anime.score.toString()
            view.animeImageView.loadImageFromURL(anime.imageUrl)

        }

    }
}
