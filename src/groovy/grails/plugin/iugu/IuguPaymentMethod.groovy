package grails.plugin.iugu


class IuguPaymentMethod {

    static iuguService

    // POST https://api.iugu.com/v1/customers/ID_DO_CLIENTE/payment_methods
    static create(def customer_id, def attributes) {
        if (!customer_id || !attributes) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.create("customers/${customer_id}/payment_methods", attributes)
    }

    // GET https://api.iugu.com/v1/customers/ID_DO_CLIENTE/payment_methods/ID_DA_FORMA_PAGAMENTO
    static fetch(def customer_id, def key) {
        if (!customer_id || !key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.fetch("customers/${customer_id}/payment_methods", key)
    }

    // PUT https://api.iugu.com/v1/customers/ID_DO_CLIENTE/payment_methods/ID_DA_FORMA_PAGAMENTO
    static save(def customer_id, def key, def attributes) {
        if (!customer_id || !key || !attributes) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.save("customers/${customer_id}/payment_methods", key, attributes)
    }

    // DELETE https://api.iugu.com/v1/customers/ID_DO_CLIENTE/payment_methods/ID_DA_FORMA_PAGAMENTO
    static delete(def customer_id, def key) {
        if (!customer_id || !key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.delete("customers/${customer_id}/payment_methods", key)
    }

    // GET https://api.iugu.com/v1/customers/ID_DO_CLIENTE/payment_methods
    static search(def customer_id) {
        if (!customer_id) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.search("customers/${customer_id}/payment_methods", null)
    }

}

// PaymentMethod.create
// [
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
// ]
