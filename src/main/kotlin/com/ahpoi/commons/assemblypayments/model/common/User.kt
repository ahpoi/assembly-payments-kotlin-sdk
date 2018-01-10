package com.ahpoi.commons.assemblypayments.model.common

import com.fasterxml.jackson.annotation.JsonProperty

class User(@JsonProperty("id") val id: String,
           @JsonProperty("created_at") val createdAt: String,
           @JsonProperty("updated_at") val updatedAt: String,
           @JsonProperty("full_name") val fullName: String,
           @JsonProperty("first_name") val firstName: String,
           @JsonProperty("last_name") val lastName: String?,
           @JsonProperty("email") val email: String?,
           @JsonProperty("mobile") val mobile: String?,
           @JsonProperty("phone") val phone: String?,
           @JsonProperty("verification_state") val verificationState: String?)