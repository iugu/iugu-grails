package grails.plugin.iugu.model

import grails.plugin.iugu.model.IuguInvoice


abstract class IuguCharge {

    Date dateCreated
    Date lastUpdated

    String iuguSuccess
    String iuguMessage
    String iuguUrl

    IuguInvoice iuguInvoice

    static constraints = {
        iuguSuccess nullable: true, blank: false
        iuguMessage nullable: true, blank: false
        iuguUrl nullable: true, blank: false

        iuguInvoice nullable: true, blank: false
    }

    def beforeInsert() {
        dateCreated = new Date()
    }

    def beforeUpdate() {
        lastUpdated = new Date()
    }

}

// \x4A\x6F\x68\x6E\x20\x33\x3A\x31\x36
