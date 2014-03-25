package grails.plugin.iugu

import groovyx.net.http.ContentType


class IuguService {

    def transactional = false

    def create(def method, def attributes) {
        return apiRequest("post", method, null, attributes)
    }

    def fetch(def method, def key) {
        return apiRequest("get", method, key, null)
    }

    def save(def method, def key, def attributes) {
        return apiRequest("put", method, key, attributes)
    }

    def delete(def method, def key) {
        return apiRequest("detele", method, key, null)
    }

    def search(def method, def options) {
        return apiRequest("get", method, null, options)
    }

    def apiRequest(def verb, def method, def key, def attributes) {
        def result

        try {
            withRest(uri: Iugu.endpoint, contentType: ContentType.JSON) {
                handler.success = { resp, results ->
                    result = results
                }

                handler.failure = { resp ->
                    result = resp.statusLine
                }

                "${verb}"(
                    path: "/${Iugu.apiVersion}/${method}" + (key ? "/${key}" : ""),
                    headers: ["Authorization": "Basic " + new String("${Iugu.apiKey}:".encodeAsBase64())],
                    body: attributes
                )
            }

            log.info("${verb.toUppercase()}: ${Iugu.endpoint}/${Iugu.apiVersion}/${method}")
        }
        catch(Exception e) {
            log.error("${verb.toUppercase()}: ${Iugu.endpoint}/${Iugu.apiVersion}/${method}", e)
        }
        finally {
            return result
        }
    }

}
