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

    static search() {
        return IuguTransfer.search(null)
    }

    // GET https://api.iugu.com/v1/transfers
    static search(def options) {
        iuguService = iuguService ?: new IuguService()

        return iuguService.search("transfers", options)
    }

}

// Transfer.create
// [
//     receiver_id: "77C2565F6F064A26ABED4255894224F0",
//     amount_cents: 1000,
// ]
