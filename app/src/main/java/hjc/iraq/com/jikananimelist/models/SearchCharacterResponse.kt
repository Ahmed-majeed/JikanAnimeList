package hjc.iraq.com.jikananimelist.models

import com.google.gson.annotations.SerializedName

class SearchCharacterResponse
    (@SerializedName("results")
     var results: List<Chara> = listOf()) : BaseSearchResponse()

