package hjc.iraq.com.jikananimelist.models
import com.google.gson.annotations.SerializedName
import hjc.iraq.com.jikananimelist.models.Manga


data class SearchMangaResponse(

    @SerializedName("results")
    var results: List<Manga> = listOf()

):BaseSearchResponse()
