package grails.plugin.iugu.model


abstract class IuguPaymentMethod {

    Date dateCreated
    Date lastUpdated

    String iuguId
    String iuguDescription
    String iuguItemType
    String iuguDataToken
    String iuguDataHolderName
    String iuguDataDisplayNumber
    String iuguDataBrand

    // static belongsTo = [iuguCustomer: IuguCustomer]

    static constraints = {
        iuguId nullable: true, blank: false
        iuguDescription nullable: true, blank: false
        iuguItemType nullable: true, blank: false
        iuguDataToken nullable: true, blank: false
        iuguDataHolderName nullable: true, blank: false
        iuguDataDisplayNumber nullable: true, blank: false
        iuguDataBrand nullable: true, blank: false
    }

    def beforeInsert() {
        dateCreated = new Date()
    }

    def beforeUpdate() {
        lastUpdated = new Date()
    }

}

// \x4A\x6F\x68\x6E\x20\x33\x3A\x31\x36
