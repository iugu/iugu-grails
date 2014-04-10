package grails.plugin.iugu

import static org.junit.Assert.*
import org.junit.*

import grails.plugin.iugu.api.IuguApi
import grails.plugin.iugu.api.IuguSubscriptionApi
import grails.plugin.iugu.api.IuguCustomerApi


class IuguSubscriptionApiTests extends GroovyTestCase {

    static subscriptionTest

    @Before
    void setUp() {
        IuguApi.apiKey = "98f7ca6cc1b969430492d0c8378fc4ce"
        IuguApi.test = true
    }

    @Test
    void "Create an IuguSubscriptionApi with invalid attributes"() {
        def subscription = IuguSubscriptionApi.create([
            plan_identifier: "plano_basico",
            customer_id: "123",
            expires_at: (new Date() + 365).format("dd/MM/yyyy"),
            subitems: [
                [
                    description: "Item 1",
                    price_cents: 1000,
                    quantity: 1,
                    recurrent: true
                ]
            ]
        ])

        assertNotNull "There was a problem with the Rest call", subscription
        assertNotNull "${subscription.errors}", subscription.errors
    }

    @Test
    void "Create an IuguSubscriptionApi with valid attributes"() {
        def customer = IuguCustomerApi.create([
            email: "email@email.com",
            name: "Nome do Cliente",
            notes: "Anotações Gerais"
        ])

        def subscription = IuguSubscriptionApi.create([
            plan_identifier: "emotionme_basic",
            customer_id: customer.id,
            expires_at: (new Date() + 365).format("dd/MM/yyyy"),
            subitems: [
                [
                    description: "Item 1",
                    price_cents: 1000,
                    quantity: 1,
                    recurrent: true
                ]
            ]
        ])

        assertNotNull "There was a problem with the Rest call", subscription
        assertNull "${subscription.errors}", subscription.errors
        assertNotNull "Missing propertie: Id", subscription.id

        subscriptionTest = subscription
    }

    @Test
    void "Fetch an IuguSubscriptionApi"() {
        if (subscriptionTest?.id) {
            def subscription = IuguSubscriptionApi.fetch(subscriptionTest?.id)

            assertNotNull "There was a problem with the Rest call", subscription
            assertNull "${subscription.errors}", subscription.errors
            assertNotNull "Missing propertie: Id", subscription.id
        }
        else {
            fail "CreateSubscription failed!"
        }
    }

    @Test
    void "Save an IuguSubscriptionApi"() {
        if (subscriptionTest?.id) {
            def subscription = subscriptionTest

            subscription.suspended = true
            subscription = IuguSubscriptionApi.save(subscription.id, subscription)

            assertNotNull "There was a problem with the Rest call", subscription
            assertNull "${subscription.errors}", subscription.errors
            assertNotNull "Missing propertie: Id", subscription.id
            assertEquals "Suspended not changed!", true, subscription.suspended
        }
        else {
            fail "CreateSubscription failed!"
        }
    }

    @Test
    void "Activate an IuguSubscriptionApi"() {
        if (subscriptionTest?.id) {
            def subscription = subscriptionTest

            subscription = IuguSubscriptionApi.activate(subscriptionTest?.id)

            assertNotNull "There was a problem with the Rest call", subscription
            assertNull "${subscription.errors}", subscription.errors
            assertEquals "Subscription not activated!", false, subscription.suspended
        }
        else {
            fail "CreateSubscription failed!"
        }
    }

    @Test
    void "Suspend an IuguSubscriptionApi"() {
        if (subscriptionTest?.id) {
            def subscription = subscriptionTest

            subscription = IuguSubscriptionApi.suspend(subscriptionTest?.id)

            assertNotNull "There was a problem with the Rest call", subscription
            assertNull "${subscription.errors}", subscription.errors
            assertEquals "Subscription not suspended!", true, subscription.suspended
        }
        else {
            fail "CreateSubscription failed!"
        }
    }

    @Test
    void "Change the Plan of an IuguSubscriptionApi"() {
        if (subscriptionTest?.id) {
            def subscription = subscriptionTest

            subscription = IuguSubscriptionApi.change_plan("emotionme_premium", subscriptionTest?.id)

            assertNotNull "There was a problem with the Rest call", subscription
            assertNull "${subscription.errors}", subscription.errors
            assertEquals "Plan not changed!", "emotionme_premium", subscription.plan_identifier
        }
        else {
            fail "CreateSubscription failed!"
        }
    }

    @Test
    void "Add Credits to an IuguSubscriptionApi"() {
        if (subscriptionTest?.id) {
            def subscription = subscriptionTest

            subscription = IuguSubscriptionApi.add_credits(subscriptionTest?.id, [
                quantity: 12300
            ])

            assertNotNull "There was a problem with the Rest call", subscription
            assertNull "${subscription.errors}", subscription.errors
            assertEquals "Credits not added!", 12300, subscription.credits
        }
        else {
            fail "CreateSubscription failed!"
        }
    }

    @Test
    void "Remove Credits from an IuguSubscriptionApi"() {
        if (subscriptionTest?.id) {
            def subscription = subscriptionTest

            subscription = IuguSubscriptionApi.remove_credits(subscriptionTest?.id, [
                quantity: 12300
            ])

            assertNotNull "There was a problem with the Rest call", subscription
            assertNull "${subscription.errors}", subscription.errors
            assertEquals "Credits not removed!", 0, subscription.credits
        }
        else {
            fail "CreateSubscription failed!"
        }
    }

    @Test
    void "Search for an IuguSubscriptionApi without filter options"() {
        def subscriptions = IuguSubscriptionApi.search()

        assertNotNull "There was a problem with the Rest call", subscriptions
        assertNull "${subscriptions.errors}", subscriptions.errors
    }

    @Test
    void "Search for an IuguSubscriptionApi and limit to 5 results"() {
        def subscriptions = IuguSubscriptionApi.search([
            limit: 5
        ])

        assertNotNull "There was a problem with the Rest call", subscriptions
        assertNull "${subscriptions.errors}", subscriptions.errors
        assertTrue "Filter not working!", subscriptions?.items?.size() <= 5
    }

    @Test
    void "Delete an IuguSubscriptionApi"() {
        if (subscriptionTest?.id) {
            def subscription = IuguSubscriptionApi.delete(subscriptionTest?.id)

            IuguCustomerApi.delete(subscription.customer_id)

            assertNotNull "There was a problem with the Rest call", subscription
            assertNull "${subscription.errors}", subscription.errors
        }
        else {
            fail "CreateSubscription failed!"
        }
    }

}
