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

    // DELETE https://api.iugu.com/v1/subscriptions/ID_DA_ASSINATURA
    static delete(def key) {
        if (!key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.delete("subscriptions", key)
    }

    static search() {
        return IuguCustomer.search(null)
    }

    // GET https://api.iugu.com/v1/subscriptions
    static search(def options) {
        iuguService = iuguService ?: new IuguService()

        return iuguService.search("subscriptions", options)
    }

    // POST https://api.iugu.com/v1/subscriptions/ID_DA_ASSINATURA/suspend
    static suspend(def key) {
        if (!key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.apiRequest("post", "subscriptions", "${key}/suspend", null)
    }

    // POST https://api.iugu.com/v1/subscriptions/ID_DA_ASSINATURA/activate
    static activate(def key) {
        if (!key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.apiRequest("post", "subscriptions", "${key}/activate", null)
    }

    // POST https://api.iugu.com/v1/subscriptions/ID_DA_ASSINATURA/change_plan/PLAN_IDENTIFIER
    static change_plan(def plan_id, def key) {
        if (!plan_id || !key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.apiRequest("post", "subscriptions", "${key}/change_plan/${plan_id}", null)
    }

    // PUT https://api.iugu.com/v1/subscriptions/ID_DA_ASSINATURA/add_credits
    static add_credits(def key) {
        if (!key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.apiRequest("put", "subscriptions", "${key}/add_credits", null)
    }

    // PUT https://api.iugu.com/v1/subscriptions/ID_DA_ASSINATURA/remove_credits
    static remove_credits(def key) {
        if (!key) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.apiRequest("put", "subscriptions", "${key}/remove_credits", null)
    }

}
