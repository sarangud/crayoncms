package com.crayoncms

import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_ADMIN")
class PluginController {
	
	def pluginManager

    def index() {
		def crayonPlugins = []
		def grailsPlugins = []
		pluginManager.allPlugins.each { it ->

			def crayonMeta = it.getProperties()?.crayonMeta

			if(crayonMeta && (crayonMeta?.addonType.equalsIgnoreCase("plugin")
					|| crayonMeta?.addonType.equalsIgnoreCase("theme"))) {
				def pluginProps = it.getProperties()
				crayonPlugins << [
						"title": pluginProps?.title,
						"author": pluginProps?.author,
						"description": pluginProps?.description,
						"version": pluginProps?.version]
			}  else {
				grailsPlugins << [
						"title": it?.name,
						"author": it?.getProperties()?.author,
						"description": it?.getProperties()?.description,
						"version": it?.version
				]
			}
			
		}

		render view:"index", model: [crayonPlugins: crayonPlugins, grailsPlugins: grailsPlugins]
	}
}
