package grails.plugin.iugu.model


abstract class IuguMarketPlace {

    Date dateCreated
    Date lastUpdated

    String iuguAccountId
    String iuguName
    String iuguLiveApiToken
    String iuguTestApiToken
    String iuguUserToken

    static constraints = {
        iuguAccountId nullable: true, blank: false
        iuguName nullable: true, blank: false
        iuguLiveApiToken nullable: true, blank: false
        iuguTestApiToken nullable: true, blank: false
        iuguUserToken nullable: true, blank: false
    }

    def beforeInsert() {
        dateCreated = new Date()
    }

    def beforeUpdate() {
        lastUpdated = new Date()
    }

}

// \x4A\x6F\x68\x6E\x20\x33\x3A\x31\x36
