package hjc.iraq.com.jikananimelist.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import hjc.iraq.com.jikananimelist.R
import hjc.iraq.com.jikananimelist.loadImageFromURL
import hjc.iraq.com.jikananimelist.models.Manga
import hjc.iraq.com.jikananimelist.utilies.Consts
import kotlinx.android.synthetic.main.activity_manga_scrolling.*
import kotlinx.android.synthetic.main.content_manga_scrolling.*

class MangaScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manga_scrolling)
        setSupportActionBar(toolbar)

        val manga = intent.getParcelableExtra<Manga>(Consts.MANGA_DETIAL)

        toolbar_layout.title = manga.title
        typeTextView.text = manga.type
        mangaratingBar.rating = manga.score / 2f
        synopsisTextView.text = manga.synopsis
        ratedTextView.text = manga.title
        mangastartdateView.text = manga.title?.split("T")[0]
        mangaendDateView.text = manga.title?.split("T")[0]
        mangamembersTextView.text = manga.members.toString()
        mangaDetialimageView.loadImageFromURL(manga.imageUrl)

        fab.setOnClickListener { _ ->
            val url = manga.url
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }
}
