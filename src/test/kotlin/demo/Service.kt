package demo

import com.ahpoi.commons.assemblypayments.client.base.AssemblyPaymentsClient
import com.ahpoi.commons.assemblypayments.client.base.ClientConfig
import com.ahpoi.commons.assemblypayments.client.base.LogLevel
import com.ahpoi.commons.assemblypayments.model.CreateUserRequest

class Service {

    /**
     * Configure the rootUrl and credentials
     * The different log levels are: NONE, BASIC, HEADERS, FULL
     */
    private val client: AssemblyPaymentsClient = AssemblyPaymentsClient(ClientConfig(
            rootUrl = "https://test.api.promisepay.com",
            username = "test@gmail.com",
            password = "Qwerty123$",
            logLevel = LogLevel.BASIC))

    /**
     * Create a user
     */
    fun createUser() {
        val req = CreateUserRequest(firstName = "John Doe", email = "john.doe@gmail.com")
        val res = this.client.userClient().createUser(req = req)
        print(res)
    }

    /**
     * Overriding the default auth that was configured by the client per request
     */
    fun createUser(auth: String) {
        val req = CreateUserRequest(firstName = "John Doe", email = "john.doe@gmail.com")
        val res = this.client.userClient().createUser(auth = auth, req = req)
        print(res)
    }

}