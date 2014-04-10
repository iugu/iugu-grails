package grails.plugin.iugu.model

// import grails.plugin.iugu.model.IuguInvoiceItem
// import grails.plugin.iugu.model.IuguInvoiceVariable
// import grails.plugin.iugu.model.IuguInvoiceLog


abstract class IuguInvoice {

    Date dateCreated
    Date lastUpdated
    Date iuguCreatedAt
    Date iuguUpdatedAt

    String iuguId
    String iuguDueDate
    String iuguCurrency
    String iuguCustomerId
    String iuguDiscountCents
    String iuguEmail
    String iuguExpirationUrl
    String iuguItemsTotalCents
    String iuguNotificationUrl
    String iuguReturnUrl
    String iuguStatus
    String iuguTaxCents
    String iuguTotalCents
    String iuguSecureId
    String iuguSecureUrl
    String iuguUserId
    String iuguTotal

    // static hasMany = [
    //     iuguItems: IuguInvoiceItem, 
    //     iuguVariables: IuguInvoiceVariable, 
    //     iuguLogs: IuguInvoiceLog, 
    // ]

    static constraints = {
        iuguCreatedAt nullable: true, blank: false
        iuguUpdatedAt nullable: true, blank: false

        iuguId nullable: true, blank: false
        iuguDueDate nullable: true, blank: false
        iuguCurrency nullable: true, blank: false
        iuguCustomerId nullable: true, blank: false
        iuguDiscountCents nullable: true, blank: false
        iuguEmail nullable: true, blank: false
        iuguExpirationUrl nullable: true, blank: false
        iuguItemsTotalCents nullable: true, blank: false
        iuguNotificationUrl nullable: true, blank: false
        iuguReturnUrl nullable: true, blank: false
        iuguStatus nullable: true, blank: false
        iuguTaxCents nullable: true, blank: false
        iuguTotalCents nullable: true, blank: false
        iuguSecureId nullable: true, blank: false
        iuguSecureUrl nullable: true, blank: false
        iuguUserId nullable: true, blank: false
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
