/**
 * Create config file for Iugu
 */

target(installIuguConfig: 'Create config files for iugu grails plugin') {
    ant.copy(
        file: "${iuguPluginDir}/grails-app/conf/IuguConfig.groovy",
        tofile: "${basedir}/grails-app/conf/IuguConfig.groovy",
        overwrite: false
    )

    ant.copy(
        file: "${iuguPluginDir}/grails-app/conf/IuguUrlMappings.groovy",
        tofile: "${basedir}/grails-app/conf/IuguUrlMappings.groovy",
        overwrite: false
    )
}

setDefaultTarget 'installIuguConfig'
