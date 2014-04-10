package grails.plugin.iugu

import static org.junit.Assert.*
import org.junit.*

import grails.plugin.iugu.api.IuguApi
import grails.plugin.iugu.api.IuguInvoiceApi


class IuguInvoiceApiTests extends GroovyTestCase {

    static invoiceTest

    @Before
    void setUp() {
        IuguApi.apiKey = "98f7ca6cc1b969430492d0c8378fc4ce"
        IuguApi.test = true
    }

    @Test
    void "Create an IuguInvoiceApi with invalid attributes"() {
        def invoice = IuguInvoiceApi.create([
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
    void "Create an IuguInvoiceApi with valid attributes"() {
        def invoice = IuguInvoiceApi.create([
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
    void "Fetch an IuguInvoiceApi"() {
        if (invoiceTest?.id) {
            def invoice = IuguInvoiceApi.fetch(invoiceTest?.id)

            assertNotNull "There was a problem with the Rest call", invoice
            assertNull "${invoice.errors}", invoice.errors
            assertNotNull "Missing propertie: Id", invoice.id
        }
        else {
            fail "CreateInvoice failed!"
        }
    }

    @Test
    void "Save an IuguInvoiceApi"() {
        if (invoiceTest?.id) {
            def invoice = invoiceTest

            invoice.status = "expired"
            invoice = IuguInvoiceApi.save(invoice.id, invoice)

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
    void "Cancel an IuguInvoiceApi"() {
        if (invoiceTest?.id) {
            def invoice = invoiceTest

            invoice.status = "pending"
            IuguInvoiceApi.save(invoice.id, invoice)

            invoice = IuguInvoiceApi.cancel(invoiceTest?.id)

            assertNotNull "There was a problem with the Rest call", invoice
            assertNull "${invoice.errors}", invoice.errors
            assertEquals "Invoice not canceled!", "canceled", invoice.status
        }
        else {
            fail "CreateInvoice failed!"
        }
    }

    @Test
    void "Refund an IuguInvoiceApi"() {
        if (invoiceTest?.id) {
            def invoice = invoiceTest

            invoice.status = "paid"
            IuguInvoiceApi.save(invoice.id, invoice)

            invoice = IuguInvoiceApi.refund(invoiceTest?.id)

            assertNotNull "There was a problem with the Rest call", invoice
            assertNull "${invoice.errors}", invoice.errors
        }
        else {
            fail "CreateInvoice failed!"
        }
    }

    @Test
    void "Search for an IuguInvoiceApi without filter options"() {
        def invoices = IuguInvoiceApi.search()

        assertNotNull "There was a problem with the Rest call", invoices
        assertNull "${invoices.errors}", invoices.errors
    }

    @Test
    void "Search for an IuguInvoiceApi and limit to 5 results"() {
        def invoices = IuguInvoiceApi.search([
            limit: 5
        ])

        assertNotNull "There was a problem with the Rest call", invoices
        assertNull "${invoices.errors}", invoices.errors
        assertTrue "Filter not working!", invoices?.items?.size() <= 5
    }

    @Test
    void "Delete an IuguInvoiceApi"() {
        if (invoiceTest?.id) {
            def invoice = IuguInvoiceApi.delete(invoiceTest?.id)

            assertNotNull "There was a problem with the Rest call", invoice
            assertNull "${invoice.errors}", invoice.errors
        }
        else {
            fail "CreateInvoice failed!"
        }
    }

}
