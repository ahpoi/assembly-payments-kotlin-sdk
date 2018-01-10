package com.ahpoi.commons.assemblypayments.api

import com.ahpoi.commons.assemblypayments.model.CreateCardAccountRequest
import com.ahpoi.commons.assemblypayments.model.CreateCardAccountResponse
import com.ahpoi.commons.assemblypayments.model.CreateItemRequest
import com.ahpoi.commons.assemblypayments.model.CreateItemResponse
import com.ahpoi.commons.assemblypayments.model.CreateUserRequest
import com.ahpoi.commons.assemblypayments.model.CreateUserResponse
import com.ahpoi.commons.assemblypayments.model.FindUserResponse
import com.ahpoi.commons.assemblypayments.model.GenerateTokenRequest
import com.ahpoi.commons.assemblypayments.model.GenerateTokenResponse
import com.ahpoi.commons.assemblypayments.model.MakePaymentRequest
import com.ahpoi.commons.assemblypayments.model.MakePaymentResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface AssemblyPaymentsApi {

    @POST("/users")
    fun createUser(@Header("Authorization") auth: String, @Body request: CreateUserRequest): Call<CreateUserResponse>

    @GET("/users")
    fun findUser(@Header("Authorization") auth: String,
                 @Query("limit") limit: String?,
                 @Query("search") offset: String?,
                 @Query("search") search: String?): Call<FindUserResponse>

    @POST("/token_auths")
    fun generateToken(@Header("Authorization") auth: String, @Body request: GenerateTokenRequest): Call<GenerateTokenResponse>

    @POST("/card_accounts")
    fun createCardAccount(@Header("Authorization") auth: String, @Body request: CreateCardAccountRequest): Call<CreateCardAccountResponse>

    @POST("/items")
    fun createItem(@Header("Authorization") auth: String, @Body request: CreateItemRequest): Call<CreateItemResponse>

    @PATCH("/items/{itemId}/make_payment")
    fun makePayment(@Header("Authorization") auth: String, @Path("itemId") itemId: String, @Body request: MakePaymentRequest): Call<MakePaymentResponse>

}
