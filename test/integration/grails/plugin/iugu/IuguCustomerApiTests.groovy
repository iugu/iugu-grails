package grails.plugin.iugu

import static org.junit.Assert.*
import org.junit.*

import grails.plugin.iugu.api.IuguApi
import grails.plugin.iugu.api.IuguCustomerApi


class IuguCustomerApiTests extends GroovyTestCase {

    static customerTest

    @Before
    void setUp() {
        IuguApi.apiKey = "98f7ca6cc1b969430492d0c8378fc4ce"
        IuguApi.test = true
    }

    @Test
    void "Create an IuguCustomerApi with invalid attributes"() {
        def customer = IuguCustomerApi.create([
            email: "email",
            name: "Nome do Cliente",
            notes: "Anotações Gerais"
        ])

        assertNotNull "There was a problem with the Rest call", customer
        assertNotNull "${customer.errors}", customer.errors
    }

    @Test
    void "Create an IuguCustomerApi with valid attributes"() {
        def customer = IuguCustomerApi.create([
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
    void "Fetch an IuguCustomerApi"() {
        if (customerTest?.id) {
            def customer = IuguCustomerApi.fetch(customerTest?.id)

            assertNotNull "There was a problem with the Rest call", customer
            assertNull "${customer.errors}", customer.errors
            assertNotNull "Missing propertie: Id", customer.id
        }
        else {
            fail "CreateCustomer failed!"
        }
    }

    @Test
    void "Save an IuguCustomerApi"() {
        if (customerTest?.id) {
            def customer = customerTest

            customer.name = "Novo Nome do Cliente"
            customer.notes = "Novas Anotações Gerais"
            customer = IuguCustomerApi.save(customer.id, customer)

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
    void "Search for an IuguCustomerApi without filter options"() {
        def customers = IuguCustomerApi.search()

        assertNotNull "There was a problem with the Rest call", customers
        assertNull "${customers.errors}", customers.errors
    }

    @Test
    void "Search for an IuguCustomerApi and limit to 5 results"() {
        def customers = IuguCustomerApi.search([
            limit: 5
        ])

        assertNotNull "There was a problem with the Rest call", customers
        assertNull "${customers.errors}", customers.errors
        assertTrue "Filter not working!", customers.items.size() <= 5
    }

    @Test
    void "Delete an IuguCustomerApi"() {
        if (customerTest?.id) {
            def customer = IuguCustomerApi.delete(customerTest?.id)

            assertNotNull "There was a problem with the Rest call", customer
            assertNull "${customer.errors}", customer.errors
        }
        else {
            fail "CreateCustomer failed!"
        }
    }

}
