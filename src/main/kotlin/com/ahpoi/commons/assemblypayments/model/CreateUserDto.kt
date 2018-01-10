package com.ahpoi.commons.assemblypayments.model

import com.ahpoi.commons.assemblypayments.model.common.User
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class CreateUserRequest(@field:JsonProperty("id") val id: String = UUID.randomUUID().toString(),
                             @field:JsonProperty("first_name") val firstName: String,
                             @field:JsonProperty("last_name") val lastName: String? = null,
                             @field:JsonProperty("email") val email: String,
                             @field:JsonProperty("mobile") val mobile: String? = null,
                             @field:JsonProperty("address_line1") val addressLine1: String? = null,
                             @field:JsonProperty("address_line2") val addressLine2: String? = null,
                             @field:JsonProperty("country") val country: String = "AUS",
                             @field:JsonProperty("dob") val dob: String? = null,
                             @field:JsonProperty("government_number") val governmentNumber: String? = null,
                             @field:JsonProperty("drivers_license_number") val driversLicenseNumber: String? = null,
                             @field:JsonProperty("drivers_license_state") val driversLicenseState: String? = null,
                             @field:JsonProperty("ip_address") val ipAddress: String? = null,
                             @field:JsonProperty("logo_url") val logoUrl: String? = null,
                             @field:JsonProperty("color_1") val color: String? = null,
                             @field:JsonProperty("color_2") val color2: String? = null,
                             @field:JsonProperty("custom_descriptor") val customDescriptor: String? = null)

data class CreateUserResponse(@field:JsonProperty("users") val user: User)