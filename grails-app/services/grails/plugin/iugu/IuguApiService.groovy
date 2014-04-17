package grails.plugin.iugu

import grails.util.Environment
import groovyx.net.http.ContentType

import grails.plugin.iugu.IuguApiRequest
import grails.plugin.iugu.api.IuguApi


class IuguApiService {

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
        def logMessage = "${verb.toUpperCase()}: ${IuguApi.endpoint}/${IuguApi.apiVersion}/${method}" +
            (key ? "/${key}" : "") +
            (options ? "\nQUERY: ${options}" : "") +
            (attributes ? "\nBODY: ${attributes}" : "")

        try {
            withRest(uri: IuguApi.endpoint, contentType: ContentType.JSON) {
                handler.success = { resp, results ->
                    result = results
                }

                handler.failure = { resp, results ->
                    result = results
                }

                "${verb}"(
                    path: "/${IuguApi.apiVersion}/${method}" + (key ? "/${key}" : ""),
                    headers: ["Authorization": "Basic " + new String("${IuguApi.apiKey}:".encodeAsBase64())],
                    query: options,
                    body: attributes
                )
            }

            logMessage = logMessage + (result ? "\nRESULT: ${result}" : "")

            if (Environment.current != Environment.TEST) {
                log.info(logMessage)
            }
            else {
                println("\n" + logMessage)
            }
        }
        catch(Exception e) {
            log.error(logMessage, e)
        }
        finally {
            new IuguApiRequest(
                iuguResquest: "${verb.toUpperCase()}: ${IuguApi.endpoint}/${IuguApi.apiVersion}/${method}" + (key ? "/${key}" : ""),
                iuguQuery: options ? "${options}" : null,
                iuguBody: attributes ? "${attributes}" : null,
                iuguResult: result ? "${result}" : null
            ).save()

            return result
        }
    }

}

// \x4A\x6F\x68\x6E\x20\x33\x3A\x31\x36
