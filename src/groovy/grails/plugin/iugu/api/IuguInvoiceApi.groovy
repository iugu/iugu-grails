package grails.plugin.iugu.api

import grails.plugin.iugu.IuguApiService


class IuguInvoiceApi {

    static iuguApiService

    // POST https://api.iugu.com/v1/invoices
    static create(def attributes) {
        if (!attributes) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.create("invoices", attributes)
    }

    // GET https://api.iugu.com/v1/invoices/ID_DA_FATURA
    static fetch(def key) {
        if (!key) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.fetch("invoices", key)
    }

    // PUT https://api.iugu.com/v1/invoices/ID_DA_FATURA
    static save(def key, def attributes) {
        if (!key || !attributes) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.save("invoices", key, attributes)
    }

    // PUT https://api.iugu.com/v1/invoices/ID_DA_FATURA/cancel
    static cancel(def key) {
        if (!key) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.apiRequest("put", "invoices", "${key}/cancel", null, null)
    }

    // POST https://api.iugu.com/v1/invoices/ID_DA_FATURA/refund
    static refund(def key) {
        if (!key) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.apiRequest("post", "invoices", "${key}/refund", null, null)
    }

    static search() {
        return IuguInvoiceApi.search(null)
    }

    // GET https://api.iugu.com/v1/invoices
    static search(def options) {
        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.search("invoices", options)
    }

    // DELETE https://api.iugu.com/v1/invoices/ID_DA_FATURA
    static delete(def key) {
        if (!key) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.delete("invoices", key)
    }

    /**
     * Format Invoice object to model
     * @param invoice
     * @return
     */
    static formatInvoice(def invoice) {
        def formatedInvoice

        if (invoice && !invoice.errors && invoice.id) {
            formatedInvoice = [
                // iuguCreatedAt: IuguApi.formatDate(invoice.created_at),
                iuguUpdatedAt: IuguApi.formatDate(invoice.updated_at),
                iuguId: invoice.id,
                iuguDueDate: invoice.due_date,
                iuguCurrency: invoice.currency,
                iuguCustomerId: invoice.customer_id,
                iuguDiscountCents: invoice.discount_cents,
                iuguEmail: invoice.email,
                iuguExpirationUrl: invoice.expiration_url,
                iuguItemsTotalCents: invoice.items_total_cents,
                iuguNotificationUrl: invoice.notification_url,
                iuguReturnUrl: invoice.return_url,
                iuguStatus: invoice.status,
                iuguTaxCents: invoice.tax_cents,
                iuguTotalCents: invoice.total_cents,
                iuguSecureId: invoice.secure_id,
                iuguSecureUrl: invoice.secure_url,
                iuguUserId: invoice.user_id,
                iuguTotal: invoice.total
                // TODO: format Invoice Item and Variable and Log
            ]
        }

        return formatedInvoice
    }

}

// Invoice.create
// [
//     email: "teste@teste.com",
//     due_date: "30/11/2041",
//     items: [
//         [
//             description: "Item Um",
//             quantity: "1",
//             price_cents: "1000"
//         ]
//     ],
//     return_url: "", // Optional
//     expired_url: "", // Optional
//     notification_url: "", // Optional
//     tax_cents: "", // Optional
//     discount_cents: "", // Optional
//     customer_id: "", // Optional
//     ignore_due_email: "", // Optional
//     subscription_id: "", // Optional
//     credits: "", // Optional
//     logs: [
//         [
//             description: "",
//             notes: ""
//         ]
//     ]
// ]

// Invoice.search
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
