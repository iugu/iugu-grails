package grails.plugin.iugu.api

import grails.plugin.iugu.IuguApiService


class IuguCustomerApi {

    static iuguApiService

    // POST https://api.iugu.com/v1/customers
    static create(def attributes) {
        if (!attributes) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.create("customers", attributes)
    }

    // GET https://api.iugu.com/v1/customers/ID_DO_CLIENTE
    static fetch(def key) {
        if (!key) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.fetch("customers", key)
    }

    // PUT https://api.iugu.com/v1/customers/ID_DO_CLIENTE
    static save(def key, def attributes) {
        if (!key || !attributes) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.save("customers", key, attributes)
    }

    static search() {
        return IuguCustomerApi.search(null)
    }

    // GET https://api.iugu.com/v1/customers
    static search(def options) {
        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.search("customers", options)
    }

    // DELETE https://api.iugu.com/v1/customers/ID_DO_CLIENTE
    static delete(def key) {
        if (!key) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.delete("customers", key)
    }

}

// Customer.create
// [
//     email: "email@email.com",
//     name: "Nome do Cliente",
//     notes: "Anotações Gerais"
// ]

// Customer.search
// [
//     limit: 5,
//     start: 0,
//     created_at_from: "31/12/2013",
//     created_at_to: "31/12/2014",
//     query: "email@email.com",
//     updated_since: "31/12/2013",
//     sortBy: [
//         email: "DESC"
//     ]
// ]

// \x4A\x6F\x68\x6E\x20\x33\x3A\x31\x36
