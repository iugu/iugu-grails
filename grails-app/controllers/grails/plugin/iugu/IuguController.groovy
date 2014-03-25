package grails.plugin.iugu


class IuguController {

    /** Dependency injection for the grailsApplication. */
    def grailsApplication

    def index() {

    }

    def testApi() {
        Iugu.apiKey = "98f7ca6cc1b969430492d0c8378fc4ce"
        Iugu.test = "true"

        def charge = IuguCharge.create([
            "method": "bank_slip",
            "email": "teste@teste.com",
            "items": [
                "description": "Item Um",
                "quantity": "1",
                "price_cents": "1000"
            ],
            "payer": [
                "name": "Nome do Cliente",
                "phone_prefix": "11",
                "phone": "12121212",
                "email": "teste@teste.com",
                "address": [
                    "street": "Rua Tal",
                    "number": "700",
                    "city": "São Paulo",
                    "state": "SP",
                    "country": "Brasil",
                    "zip_code": "12122-00"
                ]
            ]
        ])
        println "!TEST createCharge\n${charge}\n\n"

        def customer = IuguCustomer.create([
            "email": "email@email.com",
            "name": "Nome do Cliente",
            "notes": "Anotações Gerais"
        ])
        println "!TEST createCustomer\n${customer}\n\n"

        customer = IuguCustomer.fetch(customer.id)
        println "!TEST fetchCustomer\n${customer}\n\n"

        customer.name = "Novo Nome do Cliente"
        customer = IuguCustomer.save(customer.id, customer)
        println "!TEST saveCustomer\n${customer}\n\n"

        customer = IuguCustomer.delete(customer.id)
        println "!TEST deleteCustomer\n${customer}\n\n"

        def customers = IuguCustomer.search()
        println "!TEST searchCustomers\n${customers}\n\n"
    }

}
