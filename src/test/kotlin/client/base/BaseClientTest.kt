package client.base

import com.ahpoi.commons.assemblypayments.client.base.ClientConfig
import com.ahpoi.commons.assemblypayments.client.base.AssemblyPaymentsClient
import org.junit.Before

open class BaseClientTest {

    lateinit var client: AssemblyPaymentsClient

    @Before
    fun setup() {
        val config = ClientConfig(
                rootUrl = "https://test.api.promisepay.com",
                username = System.getProperties().getProperty("assemblyPayments.username"),
                password = System.getProperties().getProperty("assemblyPayments.password"))
        this.client = AssemblyPaymentsClient(config)
    }

}

