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

    // DELETE https://api.iugu.com/v1/invoices/ID_DA_FATURA
    static delete(def key) {
        if (!key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.delete("invoices", key)
    }

    static search() {
        return IuguCustomer.search(null)
    }

    // GET https://api.iugu.com/v1/invoices
    static search(def options) {
        iuguService = iuguService ?: new IuguService()

        return iuguService.search("invoices", options)
    }

    // PUT https://api.iugu.com/v1/invoices/ID_DA_FATURA/cancel
    static cancel(def key) {
        if (!key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.apiRequest("put", "invoices", "${key}/cancel", null)
    }

    // POST https://api.iugu.com/v1/invoices/ID_DA_FATURA/refund
    static refund(def key) {
        if (!key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.apiRequest("post", "invoices", "${key}/refund", null)
    }

}
