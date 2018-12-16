package hjc.iraq.com.jikananimelist.models
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class Chara(

    @SerializedName("mal_id")
    var malId: Int = 0, // 87401
    @SerializedName("url")
    var url: String = "", // https://myanimelist.net/character/87401/Toki
    @SerializedName("image_url")
    var imageUrl: String = "", // https://cdn.myanimelist.net/images/characters/10/212059.jpg?s=a37d5a30b09abbe0ffc0d5d5df8831a1
    @SerializedName("name")
    var name: String = "", // Toki
    @SerializedName("alternative_names")
    var alternativeNames: List<String> = listOf(),
    @SerializedName("anime")
    var anime: List<CharactersAppearances> = listOf(),
    @SerializedName("manga")
    var manga: List<CharactersAppearances> = listOf()
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readInt(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.createStringArrayList(),
        source.createTypedArrayList(CharactersAppearances.CREATOR),
        source.createTypedArrayList(CharactersAppearances.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(malId)
        writeString(url)
        writeString(imageUrl)
        writeString(name)
        writeStringList(alternativeNames)
        writeTypedList(anime)
        writeTypedList(manga)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Chara> = object : Parcelable.Creator<Chara> {
            override fun createFromParcel(source: Parcel): Chara = Chara(source)
            override fun newArray(size: Int): Array<Chara?> = arrayOfNulls(size)
        }
    }
}
