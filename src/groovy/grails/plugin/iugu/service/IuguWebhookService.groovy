package grails.plugin.iugu.service

import grails.converters.JSON

import grails.plugin.iugu.IuguWebhook


abstract class IuguWebhookService {

    // TODO: Use your IuguService
    /** Dependency injection for the iuguService. */
    // def iuguService

    /**
     * Manage Iugu Webhook transactions
     * @param webhook
     * @return
     */
    def manage(IuguWebhook webhook) {
        def data = JSON.parse(webhook?.data)

        switch (webhook?.event) {
            case "invoice.status_changed":
                return invoiceStatusChanged(data)
            break

            case "subscription.suspended":
                return subscriptionSuspended(data)
            break

            case "subscription.activated":
                return subscriptionActivated(data)
            break

            case "subscription.created":
                return subscriptionCreated(data)
            break
        }

        return false
    }

    /**
     * Update Iugu Invoice status
     * @param data
     * {
     *     "status": "Estado da Fatura (pending, paid, canceled, payment_in_progress, expired)",
     *     "id": "ID da Assinatura"
     * }
     * @return
     */
    private invoiceStatusChanged(def data) {
        // IuguInvoice invoice = IuguInvoice.findByIuguId(data?.id)
        def invoice // TODO: Use your IuguInvoice

        if (invoice && data?.status) {
            invoice.iuguStatus = data.status

            if (invoice.save(failOnError: true)) {
                manageInvoiceStatusChanged(invoice)

                return true
            }
        }

        return false
    }

    /**
     * Suspend Iugu Subscription
     * @param data
     * {
     *     "id": "ID da Assinatura"
     * }
     * @return
     */
    private subscriptionSuspended(def data) {
        // IuguSubscription subscription = IuguSubscription.findByIuguId(data?.id)
        def invoice // TODO: Use your IuguInvoice

        if (subscription) {
            subscription.iuguSuspended = "true"

            if (subscription.save(failOnError: true)) {
                manageSubscriptionStatusChanged(subscription)

                return true
            }
        }

        return false
    }

    /**
     * Activate Iugu Subscription
     * @param data
     * {
     *     "id": "ID da Assinatura"
     * }
     * @return
     */
    private subscriptionActivated(def data) {
        // IuguSubscription subscription = IuguSubscription.findByIuguId(data?.id)
        def subscription // TODO: Use your IuguSubscription

        if (subscription) {
            subscription.iuguSuspended = "false"

            if (subscription.save(failOnError: true)) {
                manageSubscriptionStatusChanged(subscription)

                return true
            }
        }

        return false
    }

    /**
     * Confirm Iugu Subscription creating
     * @param data
     * {
     *     "id": "ID da Assinatura"
     *     "customer_name": "Nome do Cliente",
     *     "customer_email": "email@email.com",
     * }
     * @return
     */
    private subscriptionCreated(def data) {
        // if (IuguSubscription.findByIuguId(data?.id)) {
        if (true) { // TODO: Use your IuguSubscription
            return true
        }

        return false
    }

    /**
     * Update Invoice Status and manage Application
     * @param invoice
     * @return
     */
    private manageInvoiceStatusChanged(def invoice) {
        switch(invoice.iuguStatus) {
            case "paid": // TODO: Use your IuguService
                // iuguService.invoicePaid(invoice)
            break

            case "canceled": // TODO: Use your IuguService
                // iuguService.invoiceCanceled(invoice)
            break

            case "expired": // TODO: Use your IuguService
                // iuguService.invoiceExpired(invoice)
            break

            case "pending":
            case "payment_in_progress":
                // Do nothing
            break
        }
    }

    /**
     * Update Subscription Status and manage Application
     * @param subscription
     * @return
     */
    private manageSubscriptionStatusChanged(def subscription) {
        switch(subscription.iuguSuspended) {
            case "false": // TODO: Use your IuguService
                // iuguService.subscriptionActivated(subscription)
            break

            case "true": // TODO: Use your IuguService
                // iuguService.subscriptionSuspended(subscription)
            break
        }
    }

}

// \x4A\x6F\x68\x6E\x20\x33\x3A\x31\x36
