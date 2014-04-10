package grails.plugin.iugu.api

import grails.plugin.iugu.IuguApiService


class IuguMarketPlaceApi {

    static iuguApiService

    // POST https://api.iugu.com/v1/marketplace/create_account
    static create_account(def attributes) {
        if (!attributes) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.apiRequest("post", "marketplace", "create_account", attributes, null)
    }

    // POST https://api.iugu.com/v1/accounts/ID_DA_CONTA/request_verification
    static request_verification(def key) {
        if (!key) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.apiRequest("post", "accounts", "${key}/request_verification", null, null)
    }

    // GET https://api.iugu.com/v1/accounts/ID_DA_SUBCONTA
    static fetch(def key) {
        if (!key) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.fetch("accounts", key)
    }

}

// \x4A\x6F\x68\x6E\x20\x33\x3A\x31\x36
