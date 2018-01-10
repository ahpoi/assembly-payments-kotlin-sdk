package com.ahpoi.commons.assemblypayments.client.exception

class AssemblyPaymentsRestClientException : RuntimeException {

    private val responseCode: Int

    private val errorBody: String

    constructor(responseCode: Int, errorBody: String) : super() {
        this.responseCode = responseCode
        this.errorBody = errorBody
    }

    constructor(message: String, responseCode: Int, errorBody: String) : super(message) {
        this.responseCode = responseCode
        this.errorBody = errorBody
    }

    constructor(message: String, cause: Throwable, responseCode: Int, errorBody: String) : super(message, cause) {
        this.responseCode = responseCode
        this.errorBody = errorBody
    }

    constructor(cause: Throwable, responseCode: Int, errorBody: String) : super(cause) {
        this.responseCode = responseCode
        this.errorBody = errorBody
    }

    constructor(message: String, cause: Throwable, enableSuppression: Boolean, writableStackTrace: Boolean, responseCode: Int, error: String) : super(message, cause, enableSuppression, writableStackTrace) {
        this.responseCode = responseCode
        this.errorBody = error
    }

    override fun toString(): String {
        return "AssemblyPaymentsRestClientException(responseCode=$responseCode, errorBody='$errorBody')"
    }

}
