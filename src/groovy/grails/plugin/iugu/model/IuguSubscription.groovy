package grails.plugin.iugu.model

// import grails.plugin.iugu.model.IuguSubscriptionFeature
// import grails.plugin.iugu.model.IuguSubscriptionLog
// import grails.plugin.iugu.model.IuguSubscriptionRecentInvoice
// import grails.plugin.iugu.model.IuguSubscriptionSubitem


abstract class IuguSubscription {

    Date dateCreated
    Date lastUpdated
    Date iuguCreatedAt
    Date iuguUpdatedAt
    Date iuguExpiresAt
    Date iuguCycledAt
    Date iuguTrialExpiresAt

    String iuguId
    String iuguSuspended
    String iuguPlanIdentifier
    String iuguPriceCents
    String iuguCurrency
    String iuguCustomerName
    String iuguCustomerEmail
    String iuguCreditsMin
    String iuguCreditsCycle
    String iuguPlanName
    String iuguCustomerRef
    String iuguPlanRef
    String iuguActive
    String iuguInTrial
    String iuguCredits
    String iuguCreditsBased

    // static hasMany = [
    //     iuguFeatures: IuguSubscriptionFeature,
    //     iuguSubitems: IuguSubscriptionSubitem,
    //     iuguRecentInvoices: IuguSubscriptionRecentInvoice,
    //     iuguLogs: IuguSubscriptionLog
    // ]

    static constraints = {
        iuguCreatedAt nullable: true, blank: false
        iuguUpdatedAt nullable: true, blank: false
        iuguExpiresAt nullable: true, blank: false
        iuguCycledAt nullable: true, blank: false
        iuguTrialExpiresAt nullable: true, blank: false

        iuguId nullable: true, blank: false
        iuguSuspended nullable: true, blank: false
        iuguPlanIdentifier nullable: true, blank: false
        iuguPriceCents nullable: true, blank: false
        iuguCurrency nullable: true, blank: false
        iuguCustomerName nullable: true, blank: false
        iuguCustomerEmail nullable: true, blank: false
        iuguCreditsMin nullable: true, blank: false
        iuguCreditsCycle nullable: true, blank: false
        iuguPlanName nullable: true, blank: false
        iuguCustomerRef nullable: true, blank: false
        iuguPlanRef nullable: true, blank: false
        iuguActive nullable: true, blank: false
        iuguInTrial nullable: true, blank: false
        iuguCredits nullable: true, blank: false
        iuguCreditsBased nullable: true, blank: false
    }

    def beforeInsert() {
        dateCreated = new Date()
    }

    def beforeUpdate() {
        lastUpdated = new Date()
    }

}

// \x4A\x6F\x68\x6E\x20\x33\x3A\x31\x36
