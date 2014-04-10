package grails.plugin.iugu.api

import grails.plugin.iugu.IuguApiService


class IuguTransferApi {

    static iuguApiService

    // POST https://api.iugu.com/v1/transfers
    static create(def attributes) {
        if (!attributes) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.create("transfers", attributes)
    }

    static search() {
        return IuguTransferApi.search(null)
    }

    // GET https://api.iugu.com/v1/transfers
    static search(def options) {
        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.search("transfers", options)
    }

}

// Transfer.create
// [
//     receiver_id: "77C2565F6F064A26ABED4255894224F0",
//     amount_cents: 1000,
// ]

// \x4A\x6F\x68\x6E\x20\x33\x3A\x31\x36
