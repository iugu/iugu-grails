package grails.plugin.iugu


class IuguPaymentToken {

    static iuguService

    // POST https://api.iugu.com/v1/payment_token
    static create(def attributes) {
        if (!attributes) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        if (Iugu.test) {
            attributes.test = true
        }

        return iuguService.create("payment_token", attributes)
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
