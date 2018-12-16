package hjc.iraq.com.jikananimelist.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import hjc.iraq.com.jikananimelist.R
import hjc.iraq.com.jikananimelist.R.id.charAnimeRecView
import hjc.iraq.com.jikananimelist.adpters.CharacterDetails
import hjc.iraq.com.jikananimelist.loadImageFromURL
import hjc.iraq.com.jikananimelist.models.Chara
import hjc.iraq.com.jikananimelist.models.CharactersAppearances
import hjc.iraq.com.jikananimelist.utilies.Consts
import kotlinx.android.synthetic.main.activity_character.*
import kotlinx.android.synthetic.main.content_character.*

class CharacterScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)
        setSupportActionBar(toolbar)

        val character = intent.getParcelableExtra<Chara>(Consts.CHARACTER_DETIAL)
        val appearances = intent.getParcelableExtra<CharactersAppearances>("Appearances_DETIAL")

        toolbar_layout.title = character.name
        charaterimageView.loadImageFromURL(character.imageUrl)

        prepareRecyclerViewChar(character.alternativeNames)





        fab.setOnClickListener { _ ->

            val url = character.url
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)

        }
    }

    private fun prepareRecyclerViewChar(anime: List<String>) {
        charAnimeRecView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        charAnimeRecView.adapter = CharacterDetails(anime)

    }


}
