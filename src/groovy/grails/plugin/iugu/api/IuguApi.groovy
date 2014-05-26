package grails.plugin.iugu.api


class IuguApi {

    static endpoint = "https://api.iugu.com"
    static apiVersion = "v1"
    static test = false
    static apiKey

    /**
     * Translate string date "2013-11-18T14:58:30-02:00" / "2013-11-18" to Groovy Date Object
     * @param date
     * @return
     */
    static formatDate(String date) {
        if (date) {
            if (date.matches(/\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}-\d{2}:\d{2}/)) { // "2013-11-18T14:58:30-02:00"
                return Date.parse("yyyy-MM-dd HH:mm:ssZ", date[0..-7].replace("T", " ") + date[-6..-1].replace(":", ""))
            }
            else if (date.matches(/\d{4}-\d{2}-\d{2}/)) { // "2013-11-18"
                return Date.parse("yyyy-MM-dd", date)
            }
            else if (date.matches(/\d{2}\/\d{2}, \d{2}:\d{2} h/)) { // "23/04, 13:21 h"
                return Date.parse("dd/MM/yyyy HH:mm", date[0..-10] + "/" + (new Date().year + 1900) + date[-8..-3])
            }
        }

        return null
    }

}

// \x4A\x6F\x68\x6E\x20\x33\x3A\x31\x36
