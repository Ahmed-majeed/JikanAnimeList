package hjc.iraq.com.jikananimelist.adpters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hjc.iraq.com.jikananimelist.R
import kotlinx.android.synthetic.main.content_character.view.*


class CharacterDetails(var characterDetailsList: List<String>) :
    RecyclerView.Adapter<CharacterDetails.CharacterDetailsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterDetailsViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_characterdetails, parent, false)
        return CharacterDetailsViewHolder(view)

    }

    override fun getItemCount(): Int {
        return characterDetailsList.size
    }

    override fun onBindViewHolder(viewHolder: CharacterDetailsViewHolder, position: Int) {

        viewHolder.setCharacterDetails(characterDetailsList[position])


    }

    inner class CharacterDetailsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        init {

        }

        fun setCharacterDetails(character: String) {

            view.alternativeNamesTextView?.text = character

        }

    }
}