package grails.plugin.iugu

import static org.junit.Assert.*
import org.junit.*

import grails.plugin.iugu.api.IuguApi
import grails.plugin.iugu.api.IuguTransferApi
import grails.plugin.iugu.api.IuguCustomerApi


class IuguTransferApiTests extends GroovyTestCase {

    @Before
    void setUp() {
        IuguApi.apiKey = "98f7ca6cc1b969430492d0c8378fc4ce"
        IuguApi.test = true
    }

    @Test
    void "Create an IuguTransferApi with valid attributes"() {
        def customer = IuguCustomerApi.create([
            email: "email@email.com",
            name: "Nome do Cliente",
            notes: "Anotações Gerais"
        ])

        def transfer = IuguTransferApi.create([
            receiver_id: customer.id,
            amount_cents: 12300,
        ])

        assertNotNull "There was a problem with the Rest call", transfer
        assertNull "${transfer.errors}", transfer.errors
        assertEquals "Values not transfered!", 12300, transfer.amount_cents
    }

    @Test
    void "Search an IuguTransferApi"() {
        def transfer = IuguTransferApi.search()

        assertNotNull "There was a problem with the Rest call", transfer
        assertNull "${transfer.errors}", transfer.errors
    }

}
