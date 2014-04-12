package grails.plugin.iugu.api

import grails.plugin.iugu.IuguApiService
import grails.plugin.iugu.api.IuguApi


class IuguPaymentMethodApi {

    static iuguApiService

    // POST https://api.iugu.com/v1/customers/ID_DO_CLIENTE/payment_methods
    static create(def customer_id, def attributes) {
        if (!customer_id || !attributes) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.create("customers/${customer_id}/payment_methods", attributes)
    }

    // GET https://api.iugu.com/v1/customers/ID_DO_CLIENTE/payment_methods/ID_DA_FORMA_PAGAMENTO
    static fetch(def customer_id, def key) {
        if (!customer_id || !key) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.fetch("customers/${customer_id}/payment_methods", key)
    }

    // PUT https://api.iugu.com/v1/customers/ID_DO_CLIENTE/payment_methods/ID_DA_FORMA_PAGAMENTO
    static save(def customer_id, def key, def attributes) {
        if (!customer_id || !key || !attributes) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.save("customers/${customer_id}/payment_methods", key, attributes)
    }

    // GET https://api.iugu.com/v1/customers/ID_DO_CLIENTE/payment_methods
    static search(def customer_id) {
        if (!customer_id) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.search("customers/${customer_id}/payment_methods", null)
    }

    // DELETE https://api.iugu.com/v1/customers/ID_DO_CLIENTE/payment_methods/ID_DA_FORMA_PAGAMENTO
    static delete(def customer_id, def key) {
        if (!customer_id || !key) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.delete("customers/${customer_id}/payment_methods", key)
    }

    /**
     * Format PaymentMethod object to model
     * @param paymentMethod
     * @return
     */
    static formatPaymentMethod(def paymentMethod) {
        def formatedPaymentMethod

        if (paymentMethod && !paymentMethod.errors && paymentMethod.id) {
            formatedPaymentMethod = [
                iuguId: paymentMethod.id,
                iuguDescription: paymentMethod.description,
                iuguItemType: paymentMethod.item_type,
                iuguDataToken: paymentMethod?.data?.token,
                iuguDataDisplayNumber: paymentMethod?.data?.display_number,
                iuguDataBrand: paymentMethod?.data?.brand
            ]
        }

        return formatedPaymentMethod
    }

}

// PaymentMethod.create
// [
//     description: "Primeiro Cartão",
//     item_type: "credit_card",
//     data: [
//         number: "4111111111111111",
//         verification_value: "123",
//         first_name: "Nome",
//         last_name: "Sobrenome",
//         month: "12",
//         year: "2014"
//     ]
// ]

// \x4A\x6F\x68\x6E\x20\x33\x3A\x31\x36
