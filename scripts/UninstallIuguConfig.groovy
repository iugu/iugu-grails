/**
 * Delete config file for Iugu
 */

target(uninstallIuguConfig: 'Delete config files for iugu grails plugin') {
    ant.delete(
        file: "${basedir}/grails-app/conf/IuguConfig.groovy",
        failonerror: false
    )

    ant.delete(
        file: "${basedir}/grails-app/conf/IuguUrlMappings.groovy",
        failonerror: false
    )
}

setDefaultTarget 'uninstallIuguConfig'
