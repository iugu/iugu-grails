package grails.plugin.iugu


class IuguApiRequest {

	Date dateCreated
	Date lastUpdated

	String iuguResquest
	String iuguQuery
	String iuguBody
	String iuguResult

	static mapping = {
		iuguQuery sqlType: 'text'
		iuguBody sqlType: 'text'
		iuguResult sqlType: 'text'
	}

	static constraints = {
		iuguResquest nullable: true, blank: false, size: 0..1024
		iuguQuery nullable: true, blank: false
		iuguBody nullable: true, blank: false
		iuguResult nullable: true, blank: false
	}

	def beforeInsert() {
		dateCreated = new Date()
	}

	def beforeUpdate() {
		lastUpdated = new Date()
	}

}

// \x4A\x6F\x68\x6E\x20\x33\x3A\x31\x36
