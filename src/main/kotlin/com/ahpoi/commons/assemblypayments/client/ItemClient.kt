package com.ahpoi.commons.assemblypayments.client

import com.ahpoi.commons.assemblypayments.api.AssemblyPaymentsApi
import com.ahpoi.commons.assemblypayments.model.CreateItemRequest
import com.ahpoi.commons.assemblypayments.model.CreateItemResponse
import com.ahpoi.commons.assemblypayments.model.MakePaymentRequest
import com.ahpoi.commons.assemblypayments.model.MakePaymentResponse
import com.ahpoi.commons.assemblypayments.client.base.ClientConfig
import com.ahpoi.commons.assemblypayments.util.handleBody
import retrofit2.Response

class ItemClient(private val config: ClientConfig,
                 private val api: AssemblyPaymentsApi) {

    fun createItem(auth: String = config.basicAuth(), req: CreateItemRequest): CreateItemResponse {
        val execute: Response<CreateItemResponse> = api.createItem(auth, req).execute()
        return handleBody(execute)
    }

    fun makePayment(auth: String = config.basicAuth(), itemId: String, req: MakePaymentRequest): MakePaymentResponse {
        val execute: Response<MakePaymentResponse> = api.makePayment(auth, itemId, req).execute()
        return handleBody(execute)
    }

}