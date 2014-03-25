grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

grails.project.dependency.resolution = {
    inherits("global") { }
    log "error"
    legacyResolve false
    repositories {
        grailsCentral()
        mavenCentral()
        mavenLocal()
        mavenRepo "http://snapshots.repository.codehaus.org"
        mavenRepo "http://repository.codehaus.org"
        mavenRepo "http://download.java.net/maven/2/"
        mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies { }
    plugins {
        compile(
            ":rest:0.8"
        ) {
            export = false
        }
        build(
            ":release:2.2.1",
            ":rest-client-builder:1.0.3",
            ":tomcat:$grailsVersion"
        ) {
            export = false
        }
    }
}
