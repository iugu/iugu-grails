package grails.plugin.iugu


class IuguTransfer {

    static iuguService

    // POST https://api.iugu.com/v1/transfers
    static create(def attributes) {
        if (!attributes) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.create("transfers", attributes)
    }

    // GET https://api.iugu.com/v1/transfers
    static fetch(def key) {
        if (!key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.fetch("transfers", key)
    }

}
