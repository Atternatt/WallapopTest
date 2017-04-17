package com.m2f.wallapop.data.comics.model

import com.google.gson.annotations.SerializedName

/**
 * @author Marc Moreno
 * @version 1
 */
class ComicsDataDTO(@SerializedName("results") val results: List<ComicDTO>)