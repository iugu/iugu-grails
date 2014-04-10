package grails.plugin.iugu

import static org.junit.Assert.*
import org.junit.*

import grails.plugin.iugu.api.IuguApi
import grails.plugin.iugu.api.IuguChargeApi
import grails.plugin.iugu.api.IuguPaymentTokenApi


class IuguChargeApiTests extends GroovyTestCase {

    @Before
    void setUp() {
        IuguApi.apiKey = "98f7ca6cc1b969430492d0c8378fc4ce"
        IuguApi.test = true
    }

    @Test
    void "Create a IuguChargeApi with CartaoCredito"() {
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

        def charge = IuguChargeApi.create([
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
        assertNotNull "Missing propertie: Errors[]", charge.errors
        assertTrue "${charge.errors}", charge.errors.size() == 0
    }

    @Test
    void "Create a IuguChargeApi with Boleto"() {
        def charge = IuguChargeApi.create([
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
        assertNotNull "Missing propertie: Errors[]", charge.errors
        assertTrue "${charge.errors}", charge.errors.size() == 0
    }

}
