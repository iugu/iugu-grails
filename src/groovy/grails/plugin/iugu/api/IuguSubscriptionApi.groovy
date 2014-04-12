package grails.plugin.iugu.api

import grails.plugin.iugu.IuguApiService
import grails.plugin.iugu.api.IuguApi


class IuguSubscriptionApi {

    static iuguApiService

    // POST https://api.iugu.com/v1/subscriptions
    static create(def attributes) {
        if (!attributes) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.create("subscriptions", attributes)
    }

    // GET https://api.iugu.com/v1/subscriptions/ID_DA_ASSINATURA
    static fetch(def key) {
        if (!key) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.fetch("subscriptions", key)
    }

    // PUT https://api.iugu.com/v1/subscriptions/ID_DA_ASSINATURA
    static save(def key, def attributes) {
        if (!key || !attributes) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.save("subscriptions", key, attributes)
    }

    // POST https://api.iugu.com/v1/subscriptions/ID_DA_ASSINATURA/suspend
    static suspend(def key) {
        if (!key) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.apiRequest("post", "subscriptions", "${key}/suspend", null, null)
    }

    // POST https://api.iugu.com/v1/subscriptions/ID_DA_ASSINATURA/activate
    static activate(def key) {
        if (!key) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.apiRequest("post", "subscriptions", "${key}/activate", null, null)
    }

    // POST https://api.iugu.com/v1/subscriptions/ID_DA_ASSINATURA/change_plan/PLAN_IDENTIFIER
    static change_plan(def plan_id, def key) {
        if (!plan_id || !key) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.apiRequest("post", "subscriptions", "${key}/change_plan/${plan_id}", null, null)
    }

    // PUT https://api.iugu.com/v1/subscriptions/ID_DA_ASSINATURA/add_credits
    static add_credits(def key, def attributes) {
        if (!key || !attributes) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.apiRequest("put", "subscriptions", "${key}/add_credits", attributes, null)
    }

    // PUT https://api.iugu.com/v1/subscriptions/ID_DA_ASSINATURA/remove_credits
    static remove_credits(def key, def attributes) {
        if (!key || !attributes) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.apiRequest("put", "subscriptions", "${key}/remove_credits", attributes, null)
    }

    static search() {
        return IuguSubscriptionApi.search(null)
    }

    // GET https://api.iugu.com/v1/subscriptions
    static search(def options) {
        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.search("subscriptions", options)
    }

    // DELETE https://api.iugu.com/v1/subscriptions/ID_DA_ASSINATURA
    static delete(def key) {
        if (!key) {
            return false
        }

        iuguApiService = iuguApiService ?: new IuguApiService()

        return iuguApiService.delete("subscriptions", key)
    }

    /**
     * Format Subscription object to model
     * @param subscription
     * @return
     */
    static formatSubscription(def subscription) {
        def formatedSubscription

        if (subscription && !subscription.errors && subscription.id) {
            formatedSubscription = [
                iuguCreatedAt: IuguApi.formatDate(subscription.created_at),
                iuguUpdatedAt: IuguApi.formatDate(subscription.updated_at),
                iuguExpiresAt: IuguApi.formatDate(subscription.expires_at),
                iuguCycledAt: IuguApi.formatDate(subscription.cycled_at),
                iuguTrialExpiresAt: IuguApi.formatDate(subscription.trial_expires_at),
                iuguId: subscription.id,
                iuguSuspended: subscription.suspended,
                iuguPlanIdentifier: subscription.plan_identifier,
                iuguPriceCents: subscription.price_cents,
                iuguCurrency: subscription.currency,
                iuguFeaturesFeatName: subscription.features?.feat?.name,
                iuguFeaturesFeatValue: subscription.features?.feat?.value,
                iuguCustomerName: subscription.customer_name,
                iuguCustomerEmail: subscription.customer_email,
                iuguCreditsMin: subscription.credits_min,
                iuguCreditsCycle: subscription.credits_cycle,
                iuguCustomerId: subscription.customer_id,
                iuguPlanName: subscription.plan_name,
                iuguCustomerRef: subscription.customer_ref,
                iuguPlanRef: subscription.plan_ref,
                iuguActive: subscription.active,
                iuguInTrial: subscription.in_trial,
                iuguCredits: subscription.credits,
                iuguCreditsBased: subscription.credits_based
                // iuguRecentInvoices: subscription.recent_invoices
                // TODO: format Subscription Subitem and Log
            ]
        }

        return formatedSubscription
    }

}

// Subscription.create
// [
//     plan_identifier: "plano_basico", // Optional
//     customer_id: "FF3149CE52CB4A789925F154B489BFDD",
//     expires_at: "DD/MM/AAAA", // Optional
//     only_on_charge_success: false, // Optional
//     skip_charge: false, // Optional
//     credits_based: true, // Optional
//     price_cents: 1000, // Optional
//     credits_cycle: 100, // Optional
//     credits_min: 100, // Optional
//     subitems: [ // Optional
//         [
//             description: "Item um",
//             price_cents: 1000,
//             quantity: 1,
//             recurrent: false // Optional
//         ]
//     ]
// ]

// Subscription.search
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
