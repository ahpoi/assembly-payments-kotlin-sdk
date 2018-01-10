package com.ahpoi.commons.assemblypayments.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CreateCardAccountRequest(@field:JsonProperty("user_id") val userId: String,
                                    @field:JsonProperty("full_name") val fullName: String,
                                    @field:JsonProperty("number") val number: String,
                                    @field:JsonProperty("expiry_month") val expiryMonth: String,
                                    @field:JsonProperty("expiry_year") val expiryYear: String,
                                    @field:JsonProperty("cvv") val cvv: String)

data class CreateCardAccountResponse(@field:JsonProperty("card_accounts") val cardAccount: CardAccount)

data class CardAccount(@JsonProperty("created_at") val createdAt: String,
                       @JsonProperty("updated_at") val updatedAt: String,
                       @JsonProperty("id") val id: String,
                       @JsonProperty("active") val active: Boolean,
                       @JsonProperty("currency") val currency: String)