package com.m2f.wallapop.data.comics.model

import com.google.gson.annotations.SerializedName

/**
 * @author Marc Moreno
 * *
 * @version 1
 */

class ComicDTO(
        @SerializedName("description") val description: String?,
        @SerializedName("title") val title: String,
        @SerializedName("thumbnail") val thumbnail: ThumbnailDTO)
