package grails.plugin.iugu.model

// import grails.plugin.iugu.model.IuguInvoice


abstract class IuguInvoiceItem {

    Date dateCreated
    Date lastUpdated
    Date iuguCreatedAt
    Date iuguUpdatedAt

    String iuguId
    String iuguDescription
    String iuguPriceCents
    String iuguQuantity
    String iuguPrice

    // static belongsTo = [iuguInvoice: IuguInvoice]

    static constraints = {
        iuguCreatedAt nullable: true, blank: false
        iuguUpdatedAt nullable: true, blank: false

        iuguId nullable: true, blank: false
        iuguDescription nullable: true, blank: false
        iuguPriceCents nullable: true, blank: false
        iuguQuantity nullable: true, blank: false
        iuguPrice nullable: true, blank: false
    }

    def beforeInsert() {
        dateCreated = new Date()
    }

    def beforeUpdate() {
        lastUpdated = new Date()
    }

}

// \x4A\x6F\x68\x6E\x20\x33\x3A\x31\x36
