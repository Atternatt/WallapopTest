package com.m2f.wallapop.data.comics

import com.google.gson.annotations.SerializedName

/**
 * @author Marc Moreno
 * *
 * @version 1
 */

class ComicDTO(
        @SerializedName("resourceURI") val resourceURI: String,
        @SerializedName("name") val name: String)
