package com.m2f.wallapop.data.comics.model

import com.google.gson.annotations.SerializedName

/**
 * @author Marc Moreno
 * @version 1
 */
class ComicListDTO(
        @SerializedName("available") val available: Int,
        @SerializedName("collectionURI") val collectionUri: String,
        @SerializedName("items") val items: List<ComicDTO>
)