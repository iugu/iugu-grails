package grails.plugin.iugu


class IuguController {

    /** Dependency injection for the grailsApplication. */
    def grailsApplication

    def index() {

    }

    def testApi() {
        def customer

        Iugu.apiKey = "98f7ca6cc1b969430492d0c8378fc4ce"
        Iugu.test = "true"

        chargeTests()
        customer = customerTests()
        paymentMethodTests(customer)
    }

    private chargeTests() {
        def charge

        println("\n\n!TEST createCharge(CartaoCredito)")
        charge = IuguCharge.create([
            token: "123AEAE123EA0kEIEIJAEI",
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
        println(asserted(charge && charge?.errors?.isEmpty() && charge?.success && !charge?.invoice_id?.isEmpty()))

        println("\n\n!TEST createCharge(Boleto)")
        charge = IuguCharge.create([
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
        println(asserted(charge && charge?.errors?.isEmpty() && charge?.success && !charge?.invoice_id?.isEmpty()))
    }

    private customerTests() {
        def customer
        def customers

        println("\n\n!TEST createCustomer")
        customer = IuguCustomer.create([
            email: "email@email.com",
            name: "Nome do Cliente",
            notes: "Anotações Gerais"
        ])
        println(asserted(!customer?.id?.isEmpty()))

        println("\n\n!TEST fetchCustomer")
        customer = IuguCustomer.fetch(customer.id)
        println(asserted(!customer?.id?.isEmpty()))

        println("\n\n!TEST saveCustomer")
        customer.name = "Novo Nome do Cliente"
        customer.notes = "Novas Anotações Gerais"
        customer = IuguCustomer.save(customer.id, customer)
        println(asserted(!customer?.id?.isEmpty()))

        println("\n\n!TEST searchCustomers")
        customers = IuguCustomer.search()
        println(asserted(customers))

        println("\n\n!TEST deleteCustomer")
        customer = IuguCustomer.delete(customer.id)
        println(asserted(!customer?.id?.isEmpty()))

        println("\n\n!TEST searchCustomers(Limit to 5)")
        customers = IuguCustomer.search([
            limit: 5
        ])
        println(asserted(customers))

        return customers?.items?.first()
    }

    def paymentMethodTests(def customer) {
        def paymentMethod
        def paymentMethods

        customer = customer ?: [id: "77C2565F6F064A26ABED4255894224F0"]

        println("\n\n!TEST createPaymentMethod")
        paymentMethod = IuguPaymentMethod.create(customer.id, [
            description: "Primeiro Cartão",
            item_type: "credit_card",
            data: [
                number: "4111111111111111",
                verification_value: "123",
                first_name: "Nome",
                last_name: "Sobrenome",
                month: "12",
                year: "2014"
            ]
        ])
        println(asserted(!paymentMethod?.id?.isEmpty()))

        println("\n\n!TEST fetchPaymentMethod")
        paymentMethod = IuguPaymentMethod.fetch(customer.id, paymentMethod.id)
        println(asserted(!paymentMethod?.id?.isEmpty()))

        println("\n\n!TEST savePaymentMethod")
        paymentMethod.description = "Segundo Cartão"
        paymentMethod = IuguPaymentMethod.save(customer.id, paymentMethod.id, paymentMethod)
        println(asserted(!paymentMethod?.id?.isEmpty()))

        println("\n\n!TEST searchPaymentMethods")
        paymentMethods = IuguPaymentMethod.search(customer.id)
        println(asserted(paymentMethods))

        println("\n\n!TEST deletePaymentMethods")
        paymentMethod = IuguPaymentMethods.delete(customer.id, paymentMethod.id)
        println(asserted(!paymentMethod?.id?.isEmpty()))
    }

    private asserted(def assertion) {
        return assertion ? ">>> Success!" : "<<< FAIL"
    }

}
