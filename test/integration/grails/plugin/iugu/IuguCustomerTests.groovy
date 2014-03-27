package grails.plugin.iugu

import static org.junit.Assert.*
import org.junit.*


class IuguCustomerTests extends GroovyTestCase {

    static customerTest

    @Before
    void setUp() {
        Iugu.apiKey = "98f7ca6cc1b969430492d0c8378fc4ce"
        Iugu.test = true
    }

    @Test
    void "Create an IuguCustomer with invalid attributes"() {
        def customer = IuguCustomer.create([
            email: "email",
            name: "Nome do Cliente",
            notes: "Anotações Gerais"
        ])

        assertNotNull "There was a problem with the Rest call", customer
        assertNotNull "${customer.errors}", customer.errors
    }

    @Test
    void "Create an IuguCustomer with valid attributes"() {
        def customer = IuguCustomer.create([
            email: "email@email.com",
            name: "Nome do Cliente",
            notes: "Anotações Gerais"
        ])

        assertNotNull "There was a problem with the Rest call", customer
        assertNull "${customer.errors}", customer.errors
        assertNotNull "Missing propertie: Id", customer.id

        customerTest = customer
    }

    @Test
    void "Fetch an IuguCustomer"() {
        if (customerTest?.id) {
            def customer = IuguCustomer.fetch(customerTest?.id)

            assertNotNull "There was a problem with the Rest call", customer
            assertNull "${customer.errors}", customer.errors
            assertNotNull "Missing propertie: Id", customer.id
        }
        else {
            fail "CreateCustomer failed!"
        }
    }

    @Test
    void "Save an IuguCustomer"() {
        if (customerTest?.id) {
            def customer = customerTest

            customer.name = "Novo Nome do Cliente"
            customer.notes = "Novas Anotações Gerais"
            customer = IuguCustomer.save(customer.id, customer)

            assertNotNull "There was a problem with the Rest call", customer
            assertNull "${customer.errors}", customer.errors
            assertNotNull "Missing propertie: Id", customer.id
            assertEquals "Name not changed!", "Novo Nome do Cliente", customer.name
        }
        else {
            fail "CreateCustomer failed!"
        }
    }

    @Test
    void "Search for an IuguCustomer without filter options"() {
        def customers = IuguCustomer.search()

        assertNotNull "There was a problem with the Rest call", customers
        assertNull "${customers.errors}", customers.errors
    }

    @Test
    void "Search for an IuguCustomer and limit to 5 results"() {
        def customers = IuguCustomer.search([
            limit: 5
        ])

        assertNotNull "There was a problem with the Rest call", customers
        assertNull "${customers.errors}", customers.errors
        assertTrue "Filter not working!", customers.items.size() <= 5
    }

    @Test
    void "Delete an IuguCustomer"() {
        if (customerTest?.id) {
            def customer = IuguCustomer.delete(customerTest?.id)

            assertNotNull "There was a problem with the Rest call", customer
            assertNull "${customer.errors}", customer.errors
        }
        else {
            fail "CreateCustomer failed!"
        }
    }

}
