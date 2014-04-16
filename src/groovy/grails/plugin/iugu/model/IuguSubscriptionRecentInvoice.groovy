package grails.plugin.iugu.model

// import grails.plugin.iugu.IuguSubscription


abstract class IuguSubscriptionRecentInvoice {

    Date dateCreated
    Date lastUpdated
    Date iuguDueDate

    String iuguId
    String iuguTotal
    String iuguStatus

    // static belongsTo = [iuguSubscription: IuguSubscription]

    static constraints = {
        iuguDueDate nullable: true, blank: false

        iuguId nullable: true, blank: false
        iuguTotal nullable: true, blank: false
        iuguStatus nullable: true, blank: false
    }

    def beforeInsert() {
        dateCreated = new Date()
    }

    def beforeUpdate() {
        lastUpdated = new Date()
    }

}

// \x4A\x6F\x68\x6E\x20\x33\x3A\x31\x36
