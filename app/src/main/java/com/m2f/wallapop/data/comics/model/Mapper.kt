package com.m2f.wallapop.data.comics.model

import com.m2f.wallapop.domain.comic.model.Comic
import com.m2f.wallapop.domain.comic.model.ComicList
import com.m2f.wallapop.domain.comic.model.ComicResult
import com.m2f.wallapop.domain.comic.model.Thumbnail

/**
 * @author Marc Moreno
 * @version 1
 */

fun ComicDTO.toBO(): Comic {
    return Comic(
            resourceURI,
            name)
}

fun ComicListDTO.toBO(): ComicList {
    return ComicList(
            available,
            collectionUri,
            items.map { it.toBO() })
}

fun ThumbnailDTO.toBO(): Thumbnail {
    return Thumbnail(
            path,
            extension
    )
}

fun ComicResultDTO.toBO(): ComicResult {
    return ComicResult(
            resourceURI,
            thumbnail.toBO(),
            comics.toBO()
    )
}