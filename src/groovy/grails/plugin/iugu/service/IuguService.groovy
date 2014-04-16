package grails.plugin.iugu.service


abstract class IuguService {

	/**
	 * Check Subscription Plan and update Application with New Subscription
	 * @param subscription
	 * @return
	 */
	def subscriptionCreated(def subscription) {
		// TODO: Check Subscription Plan and update Application with New Subscription
	}

	/**
	 * Check Subscription Plan and update Application with Activated Subscription
	 * @param subscription
	 * @return
	 */
	def subscriptionActivated(def subscription) {
		// TODO: Check Subscription Plan and update Application with Activated Subscription
	}

	/**
	 * Check Subscription Plan and update Application with Suspended Subscription
	 * @param subscription
	 * @return
	 */
	def subscriptionSuspended(def subscription) {
		// TODO: Check Subscription Plan and update Application with Suspended Subscription
	}

	/**
	 * Update Subscription with Paid Invoice
	 * @param invoice
	 * @return
	 */
	def invoicePaid(def invoice) {
		// TODO: Update Subscription with Paid Invoice
	}

	/**
	 * Update Subscription with Canceled Invoice
	 * @param invoice
	 * @return
	 */
	def invoiceCanceled(def invoice) {
		// TODO: Update Subscription with Canceled Invoice
	}

	/**
	 * Update Subscription with Expired Invoice
	 * @param invoice
	 * @return
	 */
	def invoiceExpired(def invoice) {
		// TODO: Update Subscription with Expired Invoice
	}

}
