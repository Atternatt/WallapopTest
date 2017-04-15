package com.m2f.wallapop.data.comics.model

import com.google.gson.annotations.SerializedName
import com.m2f.wallapop.data.comics.model.ComicListDTO
import retrofit2.http.Path

/**
 * @author Marc Moreno
 * @version 1
 */
class ComicResultDTO(
        @SerializedName("resourceURI") val resourceURI: String,
        @SerializedName("thumbnail") val thumbnail: ThumbnailDTO,
        @SerializedName("comics") val comics: ComicListDTO) {


}