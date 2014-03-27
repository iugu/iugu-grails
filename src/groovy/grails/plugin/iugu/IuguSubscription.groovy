package grails.plugin.iugu


class IuguSubscription {

    static iuguService

    // POST https://api.iugu.com/v1/subscriptions
    static create(def attributes) {
        if (!attributes) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.create("subscriptions", attributes)
    }

    // GET https://api.iugu.com/v1/subscriptions/ID_DA_ASSINATURA
    static fetch(def key) {
        if (!key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.fetch("subscriptions", key)
    }

    // PUT https://api.iugu.com/v1/subscriptions/ID_DA_ASSINATURA
    static save(def key, def attributes) {
        if (!key || !attributes) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.save("subscriptions", key, attributes)
    }

    // POST https://api.iugu.com/v1/subscriptions/ID_DA_ASSINATURA/suspend
    static suspend(def key) {
        if (!key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.apiRequest("post", "subscriptions", "${key}/suspend", null, null)
    }

    // POST https://api.iugu.com/v1/subscriptions/ID_DA_ASSINATURA/activate
    static activate(def key) {
        if (!key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.apiRequest("post", "subscriptions", "${key}/activate", null, null)
    }

    // POST https://api.iugu.com/v1/subscriptions/ID_DA_ASSINATURA/change_plan/PLAN_IDENTIFIER
    static change_plan(def plan_id, def key) {
        if (!plan_id || !key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.apiRequest("post", "subscriptions", "${key}/change_plan/${plan_id}", null, null)
    }

    // PUT https://api.iugu.com/v1/subscriptions/ID_DA_ASSINATURA/add_credits
    static add_credits(def key) {
        if (!key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.apiRequest("put", "subscriptions", "${key}/add_credits", null, null)
    }

    // PUT https://api.iugu.com/v1/subscriptions/ID_DA_ASSINATURA/remove_credits
    static remove_credits(def key) {
        if (!key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.apiRequest("put", "subscriptions", "${key}/remove_credits", null, null)
    }

    static search() {
        return IuguCustomer.search(null)
    }

    // GET https://api.iugu.com/v1/subscriptions
    static search(def options) {
        iuguService = iuguService ?: new IuguService()

        return iuguService.search("subscriptions", options)
    }

    // DELETE https://api.iugu.com/v1/subscriptions/ID_DA_ASSINATURA
    static delete(def key) {
        if (!key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.delete("subscriptions", key)
    }

}

// Subscription.create
// [
//     plan_identifier: "", // Optional
//     customer_id: "",
//     expires_at: "", // Optional
//     only_on_charge_success: "", // Optional
//     skip_charge: "", // Optional
//     credits_based: "", // Optional
//     price_cents: "", // Optional
//     credits_cycle: "", // Optional
//     credits_min: "", // Optional
//     subitems: [ // Optional
//         [
//             description: "",
//             price_cents: "",
//             quantity: "",
//             recurrent: "" // Optional
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
