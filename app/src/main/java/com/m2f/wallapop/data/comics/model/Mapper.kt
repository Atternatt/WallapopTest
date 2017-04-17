package com.m2f.wallapop.data.comics.model

import com.m2f.wallapop.domain.comic.model.Comic
import com.m2f.wallapop.domain.comic.model.Thumbnail

/**
 * @author Marc Moreno
 * @version 1
 */

fun ComicDTO.toBO(): Comic {
    return Comic(description,
            title,
            thumbnail.toBO())
}

fun ThumbnailDTO.toBO(): Thumbnail {
    return Thumbnail(
            path,
            extension
    )
}