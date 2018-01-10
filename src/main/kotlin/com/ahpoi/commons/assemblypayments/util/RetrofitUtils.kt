package com.ahpoi.commons.assemblypayments.util

import com.ahpoi.commons.assemblypayments.client.exception.AssemblyPaymentsRestClientException
import retrofit2.Response

const val UNKNOWN_ERROR = "{\"errors\":{\"body\":[\"Unknown Error\"]}}"
const val HTTP_INTERNAL_ERROR = 500

fun <T> handleBody(execute: Response<T>): T =
        handleResponse(execute).body()?.let { it } ?: throw AssemblyPaymentsRestClientException(HTTP_INTERNAL_ERROR, UNKNOWN_ERROR)

private fun <T : Response<*>> handleResponse(response: T): T = when {
    response.isSuccessful -> response
    else -> {
        val errorBody = response.errorBody()?.string().let { it } ?: UNKNOWN_ERROR
        throw AssemblyPaymentsRestClientException(response.code(), errorBody)
    }
}