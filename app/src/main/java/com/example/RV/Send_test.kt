package com.example.RV/*package com.example.RV


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Requested_Data(
    val responce: String,
    val objectivity: String,

    @SerializedName("Precedent_title") var PrecedentTitle: ArrayList<String>,
    @SerializedName("Precedent_content") var PrecedentContent: ArrayList<String>,
    @SerializedName("Law_title") var LawTitle: ArrayList<String>,
    @SerializedName("Law_content") var LawTContent: ArrayList<String>,
    @SerializedName("Keyword_title") var KeywordTitle: ArrayList<String>,
    @SerializedName("Keyword_content") var KeywordContent: ArrayList<String>
) : Parcelable

*/