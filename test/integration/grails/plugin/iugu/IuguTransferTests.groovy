package grails.plugin.iugu

import static org.junit.Assert.*
import org.junit.*


class IuguTransferTests {

    @Before
    void setUp() {
        Iugu.apiKey = "98f7ca6cc1b969430492d0c8378fc4ce"
        Iugu.test = true
    }

    @Test
    void "Create an IuguTransfer with valid attributes"() {
        def customer = IuguCustomer.create([
            email: "email@email.com",
            name: "Nome do Cliente",
            notes: "Anotações Gerais"
        ])

        def transfer = IuguTransfer.create([
            receiver_id: customer.id,
            amount_cents: 12300,
        ])

        assertNotNull "There was a problem with the Rest call", transfer
        assertNull "${transfer.errors}", transfer.errors
        assertEquals "Values not transfered!", 12300, transfer.amount_cents
    }

    @Test
    void "Search an IuguTransfer"() {
        def transfer = IuguTransfer.search()

        assertNotNull "There was a problem with the Rest call", transfer
        assertNull "${transfer.errors}", transfer.errors
    }

}
