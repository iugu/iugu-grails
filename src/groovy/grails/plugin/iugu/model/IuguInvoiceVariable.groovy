package grails.plugin.iugu.model

// import grails.plugin.iugu.model.IuguInvoice


abstract class IuguInvoiceVariable {

    Date dateCreated
    Date lastUpdated

    String iuguId
    String iuguDescription
    String iuguNotes

    // static belongsTo = [iuguInvoice: IuguInvoice]

    static constraints = {
        iuguId nullable: true, blank: false
        iuguDescription nullable: true, blank: false
        iuguNotes nullable: true, blank: false
    }

    def beforeInsert() {
        dateCreated = new Date()
    }

    def beforeUpdate() {
        lastUpdated = new Date()
    }

}

// \x4A\x6F\x68\x6E\x20\x33\x3A\x31\x36
