package grails.plugin.iugu


class IuguPaymentMethod {

    static iuguService

    // POST https://api.iugu.com/v1/customers/ID_DO_CLIENTE/payment_methods
    static create(def attributes) {
        if (!attributes || !attributes?.customer_id) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.create("customers/${attributes.customer_id}/payment_methods", attributes)
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
    static save(def key, def attributes) {
        if (!key || !attributes || !attributes?.customer_id) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.save("customers/${attributes.customer_id}/payment_methods", key, attributes)
    }

    // DELETE https://api.iugu.com/v1/customers/ID_DO_CLIENTE/payment_methods/ID_DA_FORMA_PAGAMENTO
    static delete(def customer_id, def key) {
        if (!customer_id || !key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.delete("customers/${customer_id}/payment_methods", key)
    }

    static search(def customer_id) {
        if (!customer_id) {
            return false
        }

        return IuguCustomer.search(customer_id)
    }

    // GET https://api.iugu.com/v1/customers/ID_DO_CLIENTE/payment_methods
    static search(def customer_id, def options) {
        if (!customer_id) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.search("customers/${customer_id}/payment_methods", options)
    }

}
