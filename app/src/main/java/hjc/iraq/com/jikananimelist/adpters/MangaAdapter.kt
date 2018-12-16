package hjc.iraq.com.jikananimelist.adpters


import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hjc.iraq.com.jikananimelist.*
import hjc.iraq.com.jikananimelist.activities.MangaScrollingActivity
import hjc.iraq.com.jikananimelist.models.Manga
import hjc.iraq.com.jikananimelist.utilies.Consts
import kotlinx.android.synthetic.main.item_manga.view.*


class MangaAdapter(var mangaList: List<Manga>) : RecyclerView.Adapter<MangaAdapter.MangaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_manga, parent, false)
        return MangaViewHolder(view)

    }

    override fun getItemCount(): Int {
        return mangaList.size
    }

    override fun onBindViewHolder(viewHolder: MangaViewHolder, position: Int) {

        viewHolder.setManga(mangaList[position])


    }

    inner class MangaViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        init {
            this.view.setOnClickListener {


                val intent = Intent(it.context, MangaScrollingActivity::class.java).apply {
                    putExtra(Consts.MANGA_DETIAL, mangaList[layoutPosition])
                }
                view.context.startActivity(intent)


            }
        }

        fun setManga(manga: Manga) {
            view.mangaTitleTextView.text = manga.title
            view.scoreTextView.text = manga.score.toString()
            view.mangaImageView.loadImageFromURL(manga.imageUrl)

        }

    }
}