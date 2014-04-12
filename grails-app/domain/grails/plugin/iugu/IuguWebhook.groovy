package grails.plugin.iugu


class IuguWebhook {

	Date dateCreated
	Date lastUpdated

	String iuguEvent
	String iuguData

	static mapping = {
		iuguData sqlType: 'text'
	}

	static constraints = {
		iuguEvent nullable: false, blank: false
		iuguData nullable: false, blank: false
	}

	def beforeInsert() {
		dateCreated = new Date()
	}

	def beforeUpdate() {
		lastUpdated = new Date()
	}

}

// \x4A\x6F\x68\x6E\x20\x33\x3A\x31\x36
