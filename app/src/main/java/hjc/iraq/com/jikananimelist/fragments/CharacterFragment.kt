package hjc.iraq.com.jikananimelist.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import hjc.iraq.com.jikananimelist.R
import hjc.iraq.com.jikananimelist.adpters.CharacterAdpter
import hjc.iraq.com.jikananimelist.models.Chara
import hjc.iraq.com.jikananimelist.models.SearchCharacterResponse
import hjc.iraq.com.jikananimelist.setTextChangedListener
import hjc.iraq.com.jikananimelist.utilies.AnimeInterface
import hjc.iraq.com.jikananimelist.utilies.Consts
import kotlinx.android.synthetic.main.fragment_character.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CharacterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_character, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchCharaTextView.setTextChangedListener {
            search(it)
        }
    }

    private fun search(searchQuery: String) {

        val retrofit = Retrofit.Builder()
            .baseUrl(Consts.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val animeInterface = retrofit.create(AnimeInterface::class.java)
        animeInterface.getCharacter(searchQuery)
            .enqueue(object : Callback<SearchCharacterResponse> {
                override fun onFailure(call: Call<SearchCharacterResponse>, t: Throwable) {
                    Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<SearchCharacterResponse>, response: Response<SearchCharacterResponse>) {

                    response.body()?.let {
                        prepareRecyclerView(it.results)
                    }
                }

            })


    }

    private fun prepareRecyclerView(characterList: List<Chara>) {

        charRecyclerView.layoutManager = GridLayoutManager(activity,3)
        charRecyclerView.adapter=CharacterAdpter(characterList)

    }
}
