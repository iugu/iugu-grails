package grails.plugin.iugu.model

// import grails.plugin.iugu.IuguSubscription


abstract class IuguSubscriptionFeature {

    Date dateCreated
    Date lastUpdated

    String iuguName
    String iuguValue

    // static belongsTo = [iuguSubscription: IuguSubscription]

    static constraints = {
        iuguName nullable: true, blank: false
        iuguValue nullable: true, blank: false
    }

    def beforeInsert() {
        dateCreated = new Date()
    }

    def beforeUpdate() {
        lastUpdated = new Date()
    }

}

// \x4A\x6F\x68\x6E\x20\x33\x3A\x31\x36
