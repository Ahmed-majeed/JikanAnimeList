package hjc.iraq.com.jikananimelist.utilies

import hjc.iraq.com.jikananimelist.models.SearchAnimeResponse
import hjc.iraq.com.jikananimelist.models.SearchMangaResponse
import hjc.iraq.com.jikananimelist.models.SearchCharacterResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeInterface {
    @GET("search/anime")
    fun getAnime(@Query("q") searchAnimeQuery: String): Call<SearchAnimeResponse>

    @GET("search/manga")
    fun getManga(@Query("q") searchMangaQuery: String): Call<SearchMangaResponse>

    @GET("search/character")
    fun getCharacter(@Query("q") searchCharaterQuery: String): Call<SearchCharacterResponse>

}