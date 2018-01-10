package client

import client.base.BaseClientTest
import com.ahpoi.commons.assemblypayments.model.CreateCardAccountRequest
import com.ahpoi.commons.assemblypayments.model.CreateItemRequest
import com.ahpoi.commons.assemblypayments.model.CreateUserRequest
import com.ahpoi.commons.assemblypayments.model.FindUserRequest
import com.ahpoi.commons.assemblypayments.model.GenerateTokenRequest
import com.ahpoi.commons.assemblypayments.model.MakePaymentRequest
import com.ahpoi.commons.assemblypayments.model.TOKEN_TYPE_CARD
import com.ahpoi.commons.assemblypayments.model.constant.PAYMENT_TYPE_EXPRESS
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.*

fun createUserRequest() = CreateUserRequest(
        firstName = "John Integration Test",
        email = "${UUID.randomUUID()}@test.com")

fun createItemRequest() = CreateItemRequest(
        name = "Test item from sdk",
        amount = 10000,
        paymentType = PAYMENT_TYPE_EXPRESS,
        buyerId = "1464081541419237380",
        sellerId = "5d4d9700485bd13c417b336a61ff40c6")

val createCardAccountRequest = CreateCardAccountRequest(userId = "dummy-id",
        fullName = "John Doe",
        number = "4111111111111111",
        expiryMonth = "10",
        expiryYear = "2021",
        cvv = "123")

class ClientTest : BaseClientTest() {

    @Test
    fun `should create user`() {
        val res = this.client.userClient().createUser(req = createUserRequest())
        assertThat(res.user.id).isNotNull()
    }

    @Test
    fun `should find user`() {
        val userResp = this.client.userClient().createUser(req = createUserRequest())
        val req = FindUserRequest(query = userResp.user.email, offset = "1", limit = "1")
        val res = this.client.userClient().findUser(req = req)
        assertThat(res.users.size).isEqualTo(1)
    }

    @Test
    fun `should create card account`() {
        val userResp = this.client.userClient().createUser(req = createUserRequest())
        val req = createCardAccountRequest.copy(userId = userResp.user.id)
        val res = this.client.cardAccountClient().createCardAccount(req = req)
        assertThat(res.cardAccount.id).isNotNull()
        assertThat(res.cardAccount.active).isEqualTo(true)
    }

    @Test
    fun `should generate token auth`() {
        val userResp = this.client.userClient().createUser(req = createUserRequest())

        val res = this.client.tokenAuthClient().generateToken(req = GenerateTokenRequest(userId = userResp.user.id, tokenType = TOKEN_TYPE_CARD))

        assertThat(res.tokenAuth.tokenType).isEqualTo(TOKEN_TYPE_CARD)
        assertThat(res.tokenAuth.userId).isEqualTo(userResp.user.id)
        assertThat(res.tokenAuth.token).isNotNull()
    }

    @Test
    fun `should create item`() {
        val res = this.client.itemClient().createItem(req = createItemRequest())
        assertThat(res.item.id).isNotNull()
    }

    @Test
    fun `should make payment against item`() {
        //Create a seller
        val sellerRes = this.client.userClient().createUser(req = createUserRequest())

        //Create a buyer
        val buyerRes = this.client.userClient().createUser(req = createUserRequest())
        val buyerCardAccount = this.client.cardAccountClient().createCardAccount(req = createCardAccountRequest.copy(userId = buyerRes.user.id))

        //Create an item
        val itemRes = this.client.itemClient().createItem(req = createItemRequest().copy(buyerId = buyerRes.user.id, sellerId = sellerRes.user.id))
        assertThat(itemRes.item.state).isEqualTo("pending")

        val makePaymentRequest = MakePaymentRequest(itemId = itemRes.item.id,
                accountId = buyerCardAccount.cardAccount.id,
                ipAddress = "175.88.100.88",
                deviceId = "device-id-123")

        val res = this.client.itemClient().makePayment(itemId = itemRes.item.id, req = makePaymentRequest)
        assertThat(res.item.state).isEqualTo("completed")
    }

}
