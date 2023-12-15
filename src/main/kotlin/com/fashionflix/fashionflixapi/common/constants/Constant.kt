package com.fashionflix.fashionflixapi.common.constants

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun generatedUniqueId(): String {
    val now = LocalDateTime.now()

    val isoDate = now.format(DateTimeFormatter.BASIC_ISO_DATE)
    val isoTime = now.format(DateTimeFormatter.ISO_LOCAL_TIME)

    val parsedTime = isoTime.replace(":","")
        .replace(".", "")

    return "${isoDate}-${parsedTime}"
}