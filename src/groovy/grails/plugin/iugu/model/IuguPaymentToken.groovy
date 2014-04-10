package grails.plugin.iugu.model


abstract class IuguPaymentToken {

    Date dateCreated
    Date lastUpdated

    String iuguId
    String iuguMethod

    static constraints = {
        iuguId nullable: true, blank: false
        iuguMethod nullable: true, blank: false
    }

    def beforeInsert() {
        dateCreated = new Date()
    }

    def beforeUpdate() {
        lastUpdated = new Date()
    }

}

// \x4A\x6F\x68\x6E\x20\x33\x3A\x31\x36
