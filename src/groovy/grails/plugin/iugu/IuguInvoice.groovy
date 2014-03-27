package grails.plugin.iugu


class IuguInvoice {

    static iuguService

    // POST https://api.iugu.com/v1/invoices
    static create(def attributes) {
        if (!attributes) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.create("invoices", attributes)
    }

    // GET https://api.iugu.com/v1/invoices/ID_DA_FATURA
    static fetch(def key) {
        if (!key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.fetch("invoices", key)
    }

    // PUT https://api.iugu.com/v1/invoices/ID_DA_FATURA
    static save(def key, def attributes) {
        if (!key || !attributes) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.save("invoices", key, attributes)
    }

    // PUT https://api.iugu.com/v1/invoices/ID_DA_FATURA/cancel
    static cancel(def key) {
        if (!key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.apiRequest("put", "invoices", "${key}/cancel", null, null)
    }

    // POST https://api.iugu.com/v1/invoices/ID_DA_FATURA/refund
    static refund(def key) {
        if (!key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.apiRequest("post", "invoices", "${key}/refund", null, null)
    }

    static search() {
        return IuguCustomer.search(null)
    }

    // GET https://api.iugu.com/v1/invoices
    static search(def options) {
        iuguService = iuguService ?: new IuguService()

        return iuguService.search("invoices", options)
    }

    // DELETE https://api.iugu.com/v1/invoices/ID_DA_FATURA
    static delete(def key) {
        if (!key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.delete("invoices", key)
    }

}

// POST https://api.iugu.com/v1/invoices
// [
//     email: "teste@teste.com",
//     due_date: "30/11/2041",
//     items: [
//         [
//             description: "Item Um",
//             quantity: "1",
//             price_cents: "1000"
//         ]
//     ],
//     return_url: "", // Optional
//     expired_url: "", // Optional
//     notification_url: "", // Optional
//     tax_cents: "", // Optional
//     discount_cents: "", // Optional
//     customer_id: "", // Optional
//     ignore_due_email: "", // Optional
//     subscription_id: "", // Optional
//     credits: "", // Optional
//     logs: [
//         [
//             description: "",
//             notes: ""
//         ]
//     ]
// ]
