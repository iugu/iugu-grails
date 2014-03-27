package grails.plugin.iugu

import static org.junit.Assert.*
import org.junit.*


class IuguCustomerTests extends GroovyTestCase {

    static customerTest

    @Before
    void setUp() {
        Iugu.apiKey = "98f7ca6cc1b969430492d0c8378fc4ce"
        Iugu.test = "true"
    }

    @Test
    void "Create IuguCustomer with invalid attributes"() {
        def customer = IuguCustomer.create([
            email: "email",
            name: "Nome do Cliente",
            notes: "Anotações Gerais"
        ])

        assertNotNull "There was a problem with the Rest call", customer
        assertTrue "${customer?.errors}", customer?.errors?.size() > 0
    }

    @Test
    void "Create IuguCustomer with valid attributes"() {
        def customer = IuguCustomer.create([
            email: "email@email.com",
            name: "Nome do Cliente",
            notes: "Anotações Gerais"
        ])

        assertNotNull "There was a problem with the Rest call", customer
        assertTrue "Missing propertie: CustomerId", !customer?.id?.isEmpty()

        customerTest = customer
    }

    @Test
    void "Fetch IuguCustomer"() {
        if (customerTest?.id) {
            def customer = IuguCustomer.fetch(customerTest?.id)

            assertNotNull "There was a problem with the Rest call", customer
            assertFalse "${customer?.errors}", customer?.errors?.size() > 0
            assertTrue "Missing propertie: CustomerId", !customer?.id?.isEmpty()
        }
        else {
            fail "CreateCustomer failed!"
        }
    }

    @Test
    void "Save IuguCustomer"() {
        if (customerTest?.id) {
            def customer = customerTest

            customer.name = "Novo Nome do Cliente"
            customer.notes = "Novas Anotações Gerais"
            customer = IuguCustomer.save(customer.id, customer)

            assertNotNull "There was a problem with the Rest call", customer
            assertFalse "${customer?.errors}", customer?.errors?.size() > 0
            assertTrue "Missing propertie: CustomerId", !customer?.id?.isEmpty()
            assertEquals "Name not changed!", "Novo Nome do Cliente", customer.name
        }
        else {
            fail "CreateCustomer failed!"
        }
    }

    @Test
    void "Search IuguCustomer without filter options"() {
        def customers = IuguCustomer.search()

        assertNotNull "There was a problem with the Rest call", customers
        assertFalse "${customers?.errors}", customers?.errors?.size() > 0
    }

    @Test
    void "Search IuguCustomer and limit to 5 results"() {
        def customers = IuguCustomer.search([
            limit: 5
        ])

        assertNotNull "There was a problem with the Rest call", customers
        assertFalse "${customers?.errors}", customers?.errors?.size() > 0
        assertFalse "Filter not working!", customers?.items?.size() > 5
    }

    @Test
    void "Delete IuguCustomer"() {
        if (customerTest?.id) {
            def customer = IuguCustomer.delete(customerTest?.id)

            assertNotNull "There was a problem with the Rest call", customer
            assertFalse "${customer?.errors}", customer?.errors?.size() > 0
        }
        else {
            fail "CreateCustomer failed!"
        }
    }

}
