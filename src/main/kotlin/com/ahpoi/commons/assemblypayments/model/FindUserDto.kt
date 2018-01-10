package com.ahpoi.commons.assemblypayments.model

import com.ahpoi.commons.assemblypayments.model.common.User
import com.fasterxml.jackson.annotation.JsonProperty

data class FindUserRequest(
        val limit: String? = null,
        val offset: String? = null,
        val query: String? = null)

data class FindUserResponse(@field:JsonProperty("users") val users: List<User> = listOf())