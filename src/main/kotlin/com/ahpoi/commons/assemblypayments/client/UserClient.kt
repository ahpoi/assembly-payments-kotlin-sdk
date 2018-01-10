package com.ahpoi.commons.assemblypayments.client

import com.ahpoi.commons.assemblypayments.api.AssemblyPaymentsApi
import com.ahpoi.commons.assemblypayments.client.base.ClientConfig
import com.ahpoi.commons.assemblypayments.model.CreateUserRequest
import com.ahpoi.commons.assemblypayments.model.CreateUserResponse
import com.ahpoi.commons.assemblypayments.model.FindUserRequest
import com.ahpoi.commons.assemblypayments.model.FindUserResponse
import com.ahpoi.commons.assemblypayments.util.handleBody
import retrofit2.Response

class UserClient(private val config: ClientConfig,
                 private val api: AssemblyPaymentsApi) {

    fun createUser(auth: String = config.basicAuth(), req: CreateUserRequest): CreateUserResponse {
        val execute: Response<CreateUserResponse> = api.createUser(auth, req).execute()
        return handleBody(execute)
    }

    fun findUser(auth: String = config.basicAuth(), req: FindUserRequest): FindUserResponse {
        val execute: Response<FindUserResponse> = api.findUser(auth, offset = req.offset, limit = req.limit, search = req.query).execute()
        return handleBody(execute)
    }


}