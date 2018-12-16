package hjc.iraq.com.jikananimelist.models
import com.google.gson.annotations.SerializedName
import hjc.iraq.com.jikananimelist.models.Anime


data class SearchAnimeResponse(

    @SerializedName("results")
    var results: List<Anime> = listOf()

):BaseSearchResponse()


