package grails.plugin.iugu

import static org.junit.Assert.*
import org.junit.*


class IuguPaymentTokenTests extends GroovyTestCase {

    @Before
    void setUp() {
        Iugu.apiKey = "98f7ca6cc1b969430492d0c8378fc4ce"
        Iugu.test = "true"
    }

    @Test
    void testPaymentToken() {
        def paymentToken = IuguPaymentToken.create([
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
        assertTrue "${paymentToken}", !paymentToken?.id.isEmpty()
    }

}
