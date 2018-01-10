package com.ahpoi.commons.assemblypayments.client

import com.ahpoi.commons.assemblypayments.api.AssemblyPaymentsApi
import com.ahpoi.commons.assemblypayments.client.base.ClientConfig
import com.ahpoi.commons.assemblypayments.model.CreateCardAccountRequest
import com.ahpoi.commons.assemblypayments.model.CreateCardAccountResponse
import com.ahpoi.commons.assemblypayments.util.handleBody
import retrofit2.Response

class CardAccountClient(private val config: ClientConfig,
                        private val api: AssemblyPaymentsApi) {

    fun createCardAccount(auth: String = config.basicAuth(), req: CreateCardAccountRequest): CreateCardAccountResponse {
        val execute: Response<CreateCardAccountResponse> = api.createCardAccount(auth, req).execute()
        return handleBody(execute)
    }

}