package grails.plugin.iugu


class IuguMarketPlace {

    static iuguService

    // POST https://api.iugu.com/v1/marketplace/create_account
    static create_account(def attributes) {
        if (!attributes) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.apiRequest("post", "marketplace", "create_account", attributes)
    }

    // POST https://api.iugu.com/v1/accounts/ID_DA_CONTA/request_verification
    static request_verification(def key) {
        if (!key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.apiRequest("post", "accounts", "${key}/request_verification", null)
    }

    // GET https://api.iugu.com/v1/accounts/ID_DA_SUBCONTA
    static fetch(def key) {
        if (!key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.fetch("accounts", key)
    }

}
