package com.ahpoi.commons.assemblypayments.client

import com.ahpoi.commons.assemblypayments.api.AssemblyPaymentsApi
import com.ahpoi.commons.assemblypayments.model.GenerateTokenRequest
import com.ahpoi.commons.assemblypayments.model.GenerateTokenResponse
import com.ahpoi.commons.assemblypayments.client.base.ClientConfig
import com.ahpoi.commons.assemblypayments.util.handleBody
import retrofit2.Response

class TokenAuthClient(private val config: ClientConfig,
                      private val api: AssemblyPaymentsApi) {

    fun generateToken(auth: String = config.basicAuth(), req: GenerateTokenRequest): GenerateTokenResponse {
        val execute: Response<GenerateTokenResponse> = api.generateToken(auth, req).execute()
        return handleBody(execute)
    }

}