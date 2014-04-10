package grails.plugin.iugu

import static org.junit.Assert.*
import org.junit.*

import grails.plugin.iugu.api.IuguApi
import grails.plugin.iugu.api.IuguPaymentTokenApi


class IuguPaymentTokenApiTests extends GroovyTestCase {

    @Before
    void setUp() {
        IuguApi.apiKey = "98f7ca6cc1b969430492d0c8378fc4ce"
        IuguApi.test = true
    }

    @Test
    void "Create a Payment Token with invalid attributes"() {
        def paymentToken = IuguPaymentTokenApi.create([
            method: "credit_card",
            data: [
                number: "4",
                verification_value: "123",
                first_name: "Joao",
                last_name: "Silva",
                month: "12",
                year: "2013"
            ]
        ])

        assertNotNull "There was a problem with the Rest call", paymentToken
        assertNotNull "${paymentToken.errors}", paymentToken.errors
    }

    @Test
    void "Create a Payment Token with valid attributes"() {
        def paymentToken = IuguPaymentTokenApi.create([
            method: "credit_card",
            data: [
                number: "4111111111111111",
                verification_value: "123",
                first_name: "Joao",
                last_name: "Silva",
                month: "12",
                year: "2013"
            ]
        ])

        assertNotNull "There was a problem with the Rest call", paymentToken
        assertNull "${paymentToken.errors}", paymentToken.errors
        assertNotNull "Missing propertie: Id", paymentToken.id
    }

}
