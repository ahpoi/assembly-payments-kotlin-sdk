package com.ahpoi.commons.assemblypayments.util

import java.nio.charset.StandardCharsets
import java.util.*

fun encodeString(value: String): String {
    return encodeByte(value.toByteArray(StandardCharsets.UTF_8))
}

fun encodeByte(bytes: ByteArray): String {
    return Base64.getEncoder().encodeToString(bytes)
}

fun decodeString(encodedValue: String): ByteArray {
    return Base64.getDecoder().decode(encodedValue)
}


