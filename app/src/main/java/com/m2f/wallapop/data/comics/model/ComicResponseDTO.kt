package com.m2f.wallapop.data.comics.model

import com.google.gson.annotations.SerializedName

/**
 * @author Marc Moreno
 * @version 1
 */
class ComicResponseDTO(@SerializedName("data") val data: ComicsDataDTO)