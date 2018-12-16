package hjc.iraq.com.jikananimelist.adpters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hjc.iraq.com.jikananimelist.R
import hjc.iraq.com.jikananimelist.activities.CharacterScrollingActivity
import hjc.iraq.com.jikananimelist.loadImageFromURL
import hjc.iraq.com.jikananimelist.models.Chara
import hjc.iraq.com.jikananimelist.utilies.Consts
import kotlinx.android.synthetic.main.item_character.view.*


class CharacterAdpter(var characterList: List<Chara>) : RecyclerView.Adapter<CharacterAdpter.CharacterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)

    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(viewHolder: CharacterViewHolder, position: Int) {

        viewHolder.setCharacter(characterList[position])


    }

    inner class CharacterViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        init {
            this.view.setOnClickListener {


                val intent = Intent(it.context, CharacterScrollingActivity::class.java).apply {
                    putExtra(Consts.CHARACTER_DETIAL, characterList[layoutPosition])
                }
                view.context.startActivity(intent)


            }
        }

        fun setCharacter(character: Chara) {
            view.charTextView.text=character.name
            view.charImageView.loadImageFromURL(character.imageUrl)
            Log.i("ahmed", character.alternativeNames.toString())

        }

    }
}