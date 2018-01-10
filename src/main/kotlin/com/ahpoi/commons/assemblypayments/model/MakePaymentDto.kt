package com.ahpoi.commons.assemblypayments.model

import com.ahpoi.commons.assemblypayments.model.common.Item
import com.fasterxml.jackson.annotation.JsonProperty

class MakePaymentRequest(@field:JsonProperty("id") val itemId: String,
                         @field:JsonProperty("account_id") val accountId: String,
                         @field:JsonProperty("ip_address") val ipAddress: String,
                         @field:JsonProperty("device_id") val deviceId: String)

class MakePaymentResponse(@field:JsonProperty("items") val item: Item)
