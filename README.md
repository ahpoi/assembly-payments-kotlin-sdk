# Assembly-Payments-Kotlin-SDK 

This is a Kotlin library for Assembly Payments APIs: 

Currently the following apis are supported: 

    - CreateUser
    - SearchUser
    - GenerateTokenAuth
    - CreateItem
    - MakePayment
    
For full list of the apis visit the: [Official documentation](https://reference.assemblypayments.com/)

## Include in project

This sdk is published by JitPackTo include in your project : 

	allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
	
	dependencies {
    	compile 'com.github.ahpoi:assembly-payments-kotlin-sdk:{{version}}'
    }

## Demo client

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
        }
    
        /**
         * Overriding the default auth that was configured by the client per request
         */
        fun createUser(auth: String) {
            val req = CreateUserRequest(firstName = "John Doe", email = "john.doe@gmail.com")
            val res = this.client.userClient().createUser(auth = auth, req = req)
        }
    
    }

## Tests
To run tests you need to have your assembly-payments username and password: 

    ./gradlew clean test -DassemblyPayments.username=test@email.com -DassemblyPayments.password=Qwerty123$

