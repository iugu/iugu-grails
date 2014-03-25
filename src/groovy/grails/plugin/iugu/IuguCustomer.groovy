package grails.plugin.iugu


class IuguCustomer {

    static iuguService

    // POST https://api.iugu.com/v1/customers
    static create(def attributes) {
        if (!attributes) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.create("customers", attributes)
    }

    // GET https://api.iugu.com/v1/customers/ID_DO_CLIENTE
    static fetch(def key) {
        if (!key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.fetch("customers", key)
    }

    // PUT https://api.iugu.com/v1/customers/ID_DO_CLIENTE
    static save(def key, def attributes) {
        if (!key || !attributes) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.save("customers", key, attributes)
    }

    // DELETE https://api.iugu.com/v1/customers/ID_DO_CLIENTE
    static delete(def key) {
        if (!key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.delete("customers", key)
    }

    static search() {
        return IuguCustomer.search(null)
    }

    // GET https://api.iugu.com/v1/customers
    static search(def options) {
        iuguService = iuguService ?: new IuguService()

        return iuguService.search("customers", options)
    }

}
