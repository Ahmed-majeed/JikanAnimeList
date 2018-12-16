package hjc.iraq.com.jikananimelist.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Manga(
    @SerializedName("mal_id")
    var malId: Int = 0, // 78425
    @SerializedName("url")
    var url: String = "", // https://myanimelist.net/manga/78425/Zetsumetsu_Kigu_Megami__Threatened_Goddess
    @SerializedName("image_url")
    var imageUrl: String = "", // https://cdn.myanimelist.net/images/manga/2/135679.jpg?s=61d07bfb1a1d4b5dbf673f2d17cdce86
    @SerializedName("title")
    var title: String = "", // Zetsumetsu Kigu Megami: Threatened Goddess
    @SerializedName("publishing")
    var publishing: Boolean = false, // false
    @SerializedName("synopsis")
    var synopsis: String = "", // 1. Threatened Goddess 2. Lunatic Festa 3. Cultured Beast 4. An Estray Report 5. Apostle of Sin 6. A Life with No Lifes 7. Witch the Witch 8. Wicked Bible 9. Private Master 10. Goddess Willing
    @SerializedName("type")
    var type: String = "", // Manga
    @SerializedName("chapters")
    var chapters: Int = 0, // 10
    @SerializedName("volumes")
    var volumes: Int = 0, // 1
    @SerializedName("score")
    var score: Float = 0f, // 0
    @SerializedName("start_date")
    var startDate: String = "", // 2006-04-21T00:00:00+00:00
    @SerializedName("end_date")
    var endDate: String = "", // 2007-10-23T00:00:00+00:00
    @SerializedName("members")
    var members: Int = 0 // 39
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readInt(),
        source.readString(),
        source.readString(),
        source.readString(),
        1 == source.readInt(),
        source.readString(),
        source.readString(),
        source.readInt(),
        source.readInt(),
        source.readFloat(),
        source.readString(),
        source.readString(),
        source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(malId)
        writeString(url)
        writeString(imageUrl)
        writeString(title)
        writeInt((if (publishing) 1 else 0))
        writeString(synopsis)
        writeString(type)
        writeInt(chapters)
        writeInt(volumes)
        writeFloat(score)
        writeString(startDate)
        writeString(endDate)
        writeInt(members)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Manga> = object : Parcelable.Creator<Manga> {
            override fun createFromParcel(source: Parcel): Manga = Manga(source)
            override fun newArray(size: Int): Array<Manga?> = arrayOfNulls(size)
        }
    }
}