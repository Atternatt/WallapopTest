package com.m2f.wallapop.domain.comic.model

/**
 * @author Marc Moreno
 * @version 1
 */
class ComicList(
        val available: Int,
        val collectionUri: String,
        val items: List<Comic>
)