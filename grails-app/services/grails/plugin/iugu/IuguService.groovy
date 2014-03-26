package grails.plugin.iugu

import groovyx.net.http.ContentType


class IuguService {

    def transactional = false

    def create(def method, def attributes) {
        return apiRequest("post", method, null, attributes, null)
    }

    def fetch(def method, def key) {
        return apiRequest("get", method, key, null, null)
    }

    def save(def method, def key, def attributes) {
        return apiRequest("put", method, key, attributes, null)
    }

    def delete(def method, def key) {
        return apiRequest("delete", method, key, null, null)
    }

    def search(def method, def options) {
        return apiRequest("get", method, null, null, options)
    }

    def apiRequest(def verb, def method, def key, def attributes, def options) {
        def result

        try {
            withRest(uri: Iugu.endpoint, contentType: ContentType.JSON) {
                handler.success = { resp, results ->
                    result = results
                }

                handler.failure = { resp, results ->
                    result = results
                }

                "${verb}"(
                    path: "/${Iugu.apiVersion}/${method}" + (key ? "/${key}" : ""),
                    headers: ["Authorization": "Basic " + new String("${Iugu.apiKey}:".encodeAsBase64())],
                    query: options,
                    body: attributes
                )
            }

            println("${verb.toUpperCase()}: ${Iugu.endpoint}/${Iugu.apiVersion}/${method}" + (key ? "/${key}" : "") + (attributes ? "\nBODY: ${attributes}" : "") + (result ? "\nRESULT: ${result}" : ""))
        }
        catch(Exception e) {
            log.error("${verb.toUpperCase()}: ${Iugu.endpoint}/${Iugu.apiVersion}/${method}" + (key ? "/${key}" : "") + (attributes ? "\nBODY: ${attributes}" : ""), e)
        }
        finally {
            return result
        }
    }

}
