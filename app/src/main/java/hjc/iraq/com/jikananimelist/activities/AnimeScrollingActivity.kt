package hjc.iraq.com.jikananimelist.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import hjc.iraq.com.jikananimelist.R
import hjc.iraq.com.jikananimelist.loadImageFromURL
import hjc.iraq.com.jikananimelist.models.Anime
import hjc.iraq.com.jikananimelist.utilies.Consts
import kotlinx.android.synthetic.main.activity_anime_scrolling.*
import kotlinx.android.synthetic.main.content_anime_scrolling.*

class AnimeScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anime_scrolling)
        setSupportActionBar(toolbar)


        val anime = intent.getParcelableExtra<Anime>(Consts.ANIME_DETAILS)

        toolbar_layout.title = anime.title
        typeTextView.text = anime.type
        animeratingBar.rating = anime.score
        synopsisTextView.text = anime.synopsis
        ratedTextView.text = anime.rated
        animestartdateView.text = anime.startDate.split("T")[0]
        animeendDateView!!.text = anime.endDate.split("T")[0]
        animemembersTextView.text = anime.members.toString()
        animeDetialimageView.loadImageFromURL(anime.imageUrl)



        fab.setOnClickListener {

            val url = anime.url
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }
}
