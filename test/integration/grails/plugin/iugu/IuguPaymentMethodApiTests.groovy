package grails.plugin.iugu

import static org.junit.Assert.*
import org.junit.*


class IuguPaymentMethodApiTests extends GroovyTestCase {

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
    void testSomething() {
        // fail "Implement me"
    }
}

        // def paymentMethod
        // def paymentMethods

        // customer = [id: "77C2565F6F064A26ABED4255894224F0"]

        // println("\n\n!TEST createPaymentMethod")
        // paymentMethod = IuguPaymentMethodApi.create(customer.id, [
        //     description: "Primeiro Cartão",
        //     item_type: "credit_card",
        //     data: [
        //         number: "4111111111111111",
        //         verification_value: "123",
        //         first_name: "Nome",
        //         last_name: "Sobrenome",
        //         month: "12",
        //         year: "2014"
        //     ]
        // ])
        // println(asserted(!paymentMethod?.id?.isEmpty()))

        // println("\n\n!TEST fetchPaymentMethod")
        // paymentMethod = IuguPaymentMethodApi.fetch(customer.id, paymentMethod.id)
        // println(asserted(!paymentMethod?.id?.isEmpty()))

        // println("\n\n!TEST savePaymentMethod")
        // paymentMethod.description = "Segundo Cartão"
        // paymentMethod = IuguPaymentMethodApi.save(customer.id, paymentMethod.id, paymentMethod)
        // println(asserted(!paymentMethod?.id?.isEmpty()))

        // println("\n\n!TEST searchPaymentMethods")
        // paymentMethods = IuguPaymentMethodApi.search(customer.id)
        // println(asserted(paymentMethods))

        // println("\n\n!TEST deletePaymentMethods")
        // paymentMethod = IuguPaymentMethodApi.delete(customer.id, paymentMethod.id)
        // println(asserted(!paymentMethod?.id?.isEmpty()))
