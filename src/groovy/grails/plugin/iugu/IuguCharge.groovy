package grails.plugin.iugu


class IuguCharge {

    static iuguService

    // POST https://api.iugu.com/v1/charge
    static create(def attributes) {
        if (!attributes) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.create("charge", attributes)
    }

}
