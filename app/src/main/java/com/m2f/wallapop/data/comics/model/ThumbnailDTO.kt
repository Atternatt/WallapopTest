package com.m2f.wallapop.data.comics.model

import com.google.gson.annotations.SerializedName

class ThumbnailDTO(
        @SerializedName("path") val path: String,
        @SerializedName("extension") val extension: String
)