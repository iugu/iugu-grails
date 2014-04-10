package grails.plugin.iugu.model


abstract class IuguTransfer {

    Date dateCreated
    Date lastUpdated

    String iuguId
    String iuguAmountCents
    String iuguAmountLocalized
    String iuguReceiverId
    String iuguReceiverName

    static constraints = {
        iuguId nullable: true, blank: false
        iuguAmountCents nullable: true, blank: false
        iuguAmountLocalized nullable: true, blank: false
        iuguReceiverId nullable: true, blank: false
        iuguReceiverName nullable: true, blank: false
    }

    def beforeInsert() {
        dateCreated = new Date()
    }

    def beforeUpdate() {
        lastUpdated = new Date()
    }

}

// \x4A\x6F\x68\x6E\x20\x33\x3A\x31\x36
