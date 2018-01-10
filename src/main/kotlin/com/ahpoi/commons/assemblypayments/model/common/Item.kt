package com.ahpoi.commons.assemblypayments.model.common

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Item(@field:JsonProperty("id") val id: String,
                @field:JsonProperty("created_at") val createdAt: String,
                @field:JsonProperty("updated_at") val updatedAt: String,
                @field:JsonProperty("name") val name: String,
                @field:JsonProperty("description") val description: String?,
                @field:JsonProperty("custom_descriptor") val customDescription: String?,
                @field:JsonProperty("state") val state: String,
                @field:JsonProperty("net_amount") val netAmount: Long,
                @field:JsonProperty("chargeback_amount") val chargebackAmount: Long,
                @field:JsonProperty("refunded_amount") val refundedAmount: Long,
                @field:JsonProperty("released_amount") val releasedAmount: Long,
                @field:JsonProperty("buyer_fees") val buyerFees: Long,
                @field:JsonProperty("seller_fees") val sellerFees: Long,
                @field:JsonProperty("credit_card_fees") val creditCardFee: Long,
                @field:JsonProperty("paypal_fee") val paypalFee: Long,
                @field:JsonProperty("direct_debit_fee") val directDebitFee: Long,
                @field:JsonProperty("status") val status: Long,
                @field:JsonProperty("amount") val amount: Long,
                @field:JsonProperty("payment_type_id") val paymentTypeId: Int,
                @field:JsonProperty("due_date") val dueDate: String?,
                @field:JsonProperty("pending_release_amount") val pendingReleaseAmount: Long,
                @field:JsonProperty("dynamic_descriptor") val dynamicDescriptor: String?,
                @field:JsonProperty("deposit_reference") val depositReference: String,
                @field:JsonProperty("promisepay_fee") val promisepayFee: Long,
                @field:JsonProperty("total_outstanding") val totalOutstanding: Long,
                @field:JsonProperty("total_amount") val totalAmount: Long,
                @field:JsonProperty("payment_method") val paymentMethod: String,
                @field:JsonProperty("currency") val currency: String,
                @field:JsonProperty("buyer_name") val buyerName: String,
                @field:JsonProperty("buyer_email") val buyerEmail: String,
                @field:JsonProperty("buyer_country") val buyerCountry: String,
                @field:JsonProperty("seller_name") val sellerName: String,
                @field:JsonProperty("seller_email") val sellerEmail: String,
                @field:JsonProperty("seller_country") val sellerCountry: String,
                @field:JsonProperty("payment_credit_card_enabled") val paymentCreditCardEnabled: Boolean,
                @field:JsonProperty("payment_direct_debit_enabled") val paymentDirectDebitEnabled: Boolean)

