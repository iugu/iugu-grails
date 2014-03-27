package grails.plugin.iugu

import static org.junit.Assert.*
import org.junit.*


class IuguChargeTests extends GroovyTestCase {

    @Before
    void setUp() {
        Iugu.apiKey = "98f7ca6cc1b969430492d0c8378fc4ce"
        Iugu.test = "true"
    }

    @Test
    void testChargeCartaoCredito() {
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

        def charge = IuguCharge.create([
            token: paymentToken.id,
            email: "teste@teste.com",
            items: [
                description: "Item Um",
                quantity: "1",
                price_cents: "1000"
            ],
            payer: [
                name: "Nome do Cliente",
                phone_prefix: "11",
                phone: "12121212",
                email: "teste@teste.com",
                address: [
                    street: "Rua Tal",
                    number: "700",
                    city: "São Paulo",
                    state: "SP",
                    country: "Brasil",
                    zip_code: "12122-00"
                ]
            ]
        ])

        assertNotNull "There was a problem with the Rest call", charge
        assertTrue "${charge.errors}", charge.errors.size() == 0
    }

    @Test
    void testChargeBoleto() {
        def charge = IuguCharge.create([
            method: "bank_slip",
            email: "teste@teste.com",
            items: [
                description: "Item Um",
                quantity: "1",
                price_cents: "1000"
            ],
            payer: [
                cpf_cnpj: "12312312312",
                name: "Nome do Cliente",
                phone_prefix: "11",
                phone: "12121212",
                email: "teste@teste.com",
                address: [
                    street: "Rua Tal",
                    number: "700",
                    city: "São Paulo",
                    state: "SP",
                    country: "Brasil",
                    zip_code: "12122-00"
                ]
            ]
        ])

        assertNotNull "There was a problem with the Rest call", charge
        assertTrue "${charge.errors}", charge.errors.size() == 0
    }

}
