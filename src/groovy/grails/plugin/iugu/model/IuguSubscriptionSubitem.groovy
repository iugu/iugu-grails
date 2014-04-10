package grails.plugin.iugu.model

// import grails.plugin.iugu.IuguSubscription


abstract class IuguSubscriptionSubitem {

    Date dateCreated
    Date lastUpdated

    String iuguId
    String iuguDescription
    String iuguQuantity
    String iuguPriceCents
    String iuguPrice
    String iuguTotal

    // static belongsTo = [iuguSubscription: IuguSubscription]

    static constraints = {
        iuguId nullable: true, blank: false
        iuguDescription nullable: true, blank: false
        iuguQuantity nullable: true, blank: false
        iuguPriceCents nullable: true, blank: false
        iuguPrice nullable: true, blank: false
        iuguTotal nullable: true, blank: false
    }

    def beforeInsert() {
        dateCreated = new Date()
    }

    def beforeUpdate() {
        lastUpdated = new Date()
    }

}

// \x4A\x6F\x68\x6E\x20\x33\x3A\x31\x36
