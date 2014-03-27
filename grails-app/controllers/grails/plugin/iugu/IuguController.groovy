package grails.plugin.iugu


class IuguController {

    def index() {

    }

    def testApi() {
        def customer

        Iugu.apiKey = "98f7ca6cc1b969430492d0c8378fc4ce"
        Iugu.test = "true"

        customer = customerTests()
        paymentMethodTests(customer)
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
