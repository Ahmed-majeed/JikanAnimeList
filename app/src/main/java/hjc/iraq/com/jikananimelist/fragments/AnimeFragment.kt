package hjc.iraq.com.jikananimelist.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import hjc.iraq.com.jikananimelist.utilies.AnimeInterface
import hjc.iraq.com.jikananimelist.utilies.Consts
import hjc.iraq.com.jikananimelist.R
import hjc.iraq.com.jikananimelist.adpters.AnimeAdapter
import hjc.iraq.com.jikananimelist.models.Anime
import hjc.iraq.com.jikananimelist.models.SearchAnimeResponse
import hjc.iraq.com.jikananimelist.setTextChangedListener
import kotlinx.android.synthetic.main.fragment_anime.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AnimeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_anime, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchAnimeEditText.setTextChangedListener {
            search(it)
        }
    }

    private fun search(searchQuery: String) {

        val retrofit = Retrofit.Builder()
            .baseUrl(Consts.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val animeInterface = retrofit.create(AnimeInterface::class.java)
        animeInterface.getAnime(searchQuery)
            .enqueue(object : Callback<SearchAnimeResponse> {
                override fun onFailure(call: Call<SearchAnimeResponse>, t: Throwable) {
                    Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<SearchAnimeResponse>, response: Response<SearchAnimeResponse>) {

                    response.body()?.let {
                        prepareRecyclerView(it.results)
                    }
                }

            })


    }

    private fun prepareRecyclerView(animeList: List<Anime>) {

        animeRecyclerView.layoutManager = LinearLayoutManager(activity)
        animeRecyclerView.adapter = AnimeAdapter(animeList)

    }

}

