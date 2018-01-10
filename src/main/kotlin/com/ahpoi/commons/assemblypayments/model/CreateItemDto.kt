package com.ahpoi.commons.assemblypayments.model

import com.ahpoi.commons.assemblypayments.model.common.Item
import com.ahpoi.commons.assemblypayments.model.constant.CURRENCY_AUD
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class CreateItemRequest(@field:JsonProperty("id") val id: String = UUID.randomUUID().toString(),
                             @field:JsonProperty("name") val name: String,
                             @field:JsonProperty("amount") val amount: Long,
                             @field:JsonProperty("currency") val currency: String? = CURRENCY_AUD,
                             @field:JsonProperty("payment_type") val paymentType: Int,
                             @field:JsonProperty("buyer_id") val buyerId: String,
                             @field:JsonProperty("seller_id") val sellerId: String,
                             @field:JsonProperty("fee_ids") val feeIds: String? = null,
                             @field:JsonProperty("description") val description: String? = null,
                             @field:JsonProperty("buyer_url") val buyerUrl: String? = null,
                             @field:JsonProperty("seller_url") val sellerUrl: String? = null,
                             @field:JsonProperty("tax_invoice") val taxInvoice: Boolean? = null,
                             @field:JsonProperty("due_date") val dueDate: String? = null,
                             @field:JsonProperty("custom_descriptor") val customDescription: String? = null)

@JsonIgnoreProperties(ignoreUnknown = true)
data class CreateItemResponse(@field:JsonProperty("items") val item: Item)