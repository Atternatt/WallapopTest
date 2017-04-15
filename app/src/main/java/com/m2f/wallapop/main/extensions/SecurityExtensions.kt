package com.m2f.wallapop.main.extensions

import java.math.BigInteger
import java.security.MessageDigest

/**
 * @author Marc Moreno
 * @version 1
 */

fun String.md5(): String {
    val messageDiggest = MessageDigest.getInstance("MD5").let {
        it.update(this@md5.toByteArray())
        it.digest()
    }
    return BigInteger(1, messageDiggest).toString(16)
}