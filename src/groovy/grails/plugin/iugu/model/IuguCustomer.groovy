package grails.plugin.iugu.model


abstract class IuguCustomer {

    Date dateCreated
    Date lastUpdated
    Date iuguCreatedAt
    Date iuguUpdatedAt

    String iuguId
    String iuguEmail
    String iuguName
    String iuguNotes
    String iuguDefaultPaymentMethodId

    // static hasMany = [iuguPaymentMethods: IuguPaymentMethod]

    static constraints = {
        iuguCreatedAt nullable: true, blank: false
        iuguUpdatedAt nullable: true, blank: false

        iuguId nullable: true, blank: false
        iuguEmail nullable: true, blank: false
        iuguName nullable: true, blank: false
        iuguNotes nullable: true, blank: false
        iuguDefaultPaymentMethodId nullable: true, blank: false
    }

    def beforeInsert() {
        dateCreated = new Date()
    }

    def beforeUpdate() {
        lastUpdated = new Date()
    }

}

// \x4A\x6F\x68\x6E\x20\x33\x3A\x31\x36
