package grails.plugin.iugu

import static org.junit.Assert.*
import org.junit.*


class IuguInvoiceTests {

    static invoiceTest

    @Before
    void setUp() {
        Iugu.apiKey = "98f7ca6cc1b969430492d0c8378fc4ce"
        Iugu.test = true
    }

    @Test
    void "Create IuguInvoice with invalid attributes"() {
        def invoice = IuguInvoice.create([
            email: "teste",
            due_date: (new Date() + 5).format("dd/MM/yyyy"),
            items: [
                [
                    description: "Item Um",
                    quantity: "1",
                    price_cents: "1000"
                ]
            ]
        ])

        assertNotNull "There was a problem with the Rest call", invoice
        assertNotNull "${invoice.errors}", invoice.errors
    }

    @Test
    void "Create IuguInvoice with valid attributes"() {
        def invoice = IuguInvoice.create([
            email: "teste@teste.com",
            due_date: (new Date() + 5).format("dd/MM/yyyy"),
            items: [
                [
                    description: "Item Um",
                    quantity: "1",
                    price_cents: "1000"
                ]
            ]
        ])

        assertNotNull "There was a problem with the Rest call", invoice
        assertNull "${invoice.errors}", invoice.errors
        assertNotNull "Missing propertie: Id", invoice.id

        invoiceTest = invoice
    }

    @Test
    void "Fetch IuguInvoice"() {
        if (invoiceTest?.id) {
            def invoice = IuguInvoice.fetch(invoiceTest?.id)

            assertNotNull "There was a problem with the Rest call", invoice
            assertNull "${invoice.errors}", invoice.errors
            assertNotNull "Missing propertie: Id", invoice.id
        }
        else {
            fail "CreateInvoice failed!"
        }
    }

    @Test
    void "Save IuguInvoice"() {
        if (invoiceTest?.id) {
            def invoice = invoiceTest

            invoice.status = "expired"
            invoice = IuguInvoice.save(invoice.id, invoice)

            assertNotNull "There was a problem with the Rest call", invoice
            assertNull "${invoice.errors}", invoice.errors
            assertNotNull "Missing propertie: Id", invoice.id
            assertEquals "Status not changed!", "expired", invoice.status
        }
        else {
            fail "CreateInvoice failed!"
        }
    }

    @Test
    void "Cancel IuguInvoice"() {
        if (invoiceTest?.id) {
            def invoice = invoiceTest

            invoice.status = "pending"
            IuguInvoice.save(invoice.id, invoice)

            invoice = IuguInvoice.cancel(invoiceTest?.id)

            assertNotNull "There was a problem with the Rest call", invoice
            assertNull "${invoice.errors}", invoice.errors
            assertEquals "Invoice not canceled!", "canceled", invoice.status
        }
        else {
            fail "CreateInvoice failed!"
        }
    }

    @Test
    void "Refund IuguInvoice"() {
        if (invoiceTest?.id) {
            def invoice = invoiceTest

            invoice.status = "paid"
            IuguInvoice.save(invoice.id, invoice)

            invoice = IuguInvoice.refund(invoiceTest?.id)

            assertNotNull "There was a problem with the Rest call", invoice
            assertNull "${invoice.errors}", invoice.errors
            // assertEquals "Invoice not canceled!", "canceled", invoice.status
        }
        else {
            fail "CreateInvoice failed!"
        }
    }

    @Test
    void "Search IuguInvoice without filter options"() {
        def invoices = IuguInvoice.search()

        assertNotNull "There was a problem with the Rest call", invoices
        assertNull "${invoices.errors}", invoices.errors
    }

    @Test
    void "Search IuguInvoice and limit to 5 results"() {
        def invoices = IuguInvoice.search([
            limit: 5
        ])

        assertNotNull "There was a problem with the Rest call", invoices
        assertNull "${invoices.errors}", invoices.errors
        assertTrue "Filter not working!", invoices?.items?.size() <= 5
    }

    @Test
    void "Delete IuguInvoice"() {
        if (invoiceTest?.id) {
            def invoice = IuguInvoice.delete(invoiceTest?.id)

            assertNotNull "There was a problem with the Rest call", invoice
            assertNull "${invoice.errors}", invoice.errors
        }
        else {
            fail "CreateInvoice failed!"
        }
    }

}
