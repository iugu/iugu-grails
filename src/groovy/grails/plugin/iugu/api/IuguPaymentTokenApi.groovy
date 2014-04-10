package grails.plugin.iugu.api

import grails.plugin.iugu.IuguApiService


class IuguPaymentTokenApi {

    static iuguApiService

    // POST https://api.iugu.com/v1/payment_token
    static create(def attributes) {
        if (!attributes) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        if (IuguApi.test) {
            attributes.test = true
        }

        return iuguApiService.create("payment_token", attributes)
    }

}

// PaymentToken.create
// [
//     method: "credit_card",
//     test: true, // Optional
//     data: [
//         number: "4111111111111111",
//         verification_value: "123",
//         first_name: "Joao",
//         last_name: "Silva",
//         month: "12",
//         year: "2013"
//     ]
// ]

// \x4A\x6F\x68\x6E\x20\x33\x3A\x31\x36
