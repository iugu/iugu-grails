package grails.plugin.iugu.controller

import grails.converters.JSON

import grails.plugin.iugu.IuguWebhook


abstract class IuguController {

    def index() {
        response.sendError(404)
    }

    /**
     * Iugu Webhook
     * @return
     */
    def webhook() {
        def json = JSON.parse(request?.reader?.text)
        IuguWebhook webhook

        if (!json) {
            response.sendError(500)
            return false
        }

        webhook = new IuguWebhook(
            iuguEvent: json?.event,
            iuguData: json?.data?.toString()
        )

        if (webhook.save(failOnError: true)) {
            // TODO: Use your IuguWebhookService extended from Abstract IuguWebhookService
            if (true) { // iuguWebhookService.manage(webhook)
                render "John 3:16"
            }
        }
        else {
            response.sendError(418)
        }
    }

}

// \x4A\x6F\x68\x6E\x20\x33\x3A\x31\x36
