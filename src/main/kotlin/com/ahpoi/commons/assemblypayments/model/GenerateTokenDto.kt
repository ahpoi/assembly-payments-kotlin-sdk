package com.ahpoi.commons.assemblypayments.model

import com.fasterxml.jackson.annotation.JsonProperty

const val TOKEN_TYPE_CARD = "card"
const val TOKEN_TYPE_BANK = "bank"

data class GenerateTokenRequest(@field:JsonProperty("token_type") val tokenType: String,
                                @field:JsonProperty("user_id") val userId: String)

data class GenerateTokenResponse(@field:JsonProperty("token_auth") val tokenAuth: TokenAuth)

data class TokenAuth(@field:JsonProperty("token_type") val tokenType: String,
                     @field:JsonProperty("token") val token: String,
                     @field:JsonProperty("user_id") val userId: String)