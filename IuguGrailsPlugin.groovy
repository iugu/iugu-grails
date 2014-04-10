import grails.util.Environment

import org.codehaus.groovy.grails.commons.GrailsApplication


class IuguGrailsPlugin {

    def version = "0.1"
    def grailsVersion = "2.2 > *"
    def title = "Iugu grails plugin"
    def author = "Alexandre Ferreira"
    def authorEmail = "alexandref@gmail.com"
    def organization = [ name: "emotion.me", url: "http://emotion.me/" ]
    // def developers = [ [ name: "Joe Bloggs", email: "joe@bloggs.net" ]]
    def description = "Iugu Grails Plugin - https://iugu.com"
    def documentation = "http://grails.org/plugin/iugu"
    // def issueManagement = [ system: "JIRA", url: "http://jira.grails.org/browse/GPMYPLUGIN" ]
    // def scm = [ url: "http://svn.codehaus.org/grails-plugins/" ]
    // def license = "APACHE"

    def observe = [
        "controllers",
        "services",
        "filters"
    ]

    def pluginExcludes = [
        "grails-app/conf/IuguConfig.groovy",
        "grails-app/conf/IuguUrlMappings.groovy"
    ]

    def doWithSpring = {
        loadIuguConfig(application)
    }

    private ConfigObject loadIuguConfig(GrailsApplication grailsApplication) {
        def config = grailsApplication.config
        GroovyClassLoader classLoader = new GroovyClassLoader(getClass().classLoader)

        // Merging default Iugu config into main application config
        config.merge(new ConfigSlurper(Environment.current.name).parse(classLoader.loadClass('IuguConfig')))

        // Merging user-defined Iugu config into main application config if provided
        try {
            config.merge(new ConfigSlurper(Environment.current.name).parse(classLoader.loadClass('IuguConfig')))
        } catch (Exception ignored) {
            // ignore, just use the defaults
        }

        return config
    }

}

// \x4A\x6F\x68\x6E\x20\x33\x3A\x31\x36
