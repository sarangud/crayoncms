package com.crayoncms

import org.grails.plugins.BinaryGrailsPlugin

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
class PageController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def pluginManager

	@Secured("ROLE_CRAYONCMS_PAGE_VIEW")
    def index(Integer max) {
        params.max = Math.min(max ?: 20, 100)
        respond Page.list(params), model:[pageCount: Page.count()]
    }

	@Secured(["ROLE_CRAYONCMS_PAGE_VIEW", "ROLE_ANONYMOUS"])
    def show(String slug) {
		Page page = Page.findBySlug(slug ?: "home")
        if(page) {
            respond page, [view: "/" + page.layout]
        } else {
            notFound()
        }
    }

	@Secured("ROLE_CRAYONCMS_PAGE_CREATE")
    def create() {
        def page = new Page(params)

        def activeTheme = pluginManager.getGrailsPlugin("helios-theme")
        if(activeTheme instanceof BinaryGrailsPlugin) {
            def files = new File(activeTheme.getProjectDirectory(), "grails-app/views").list()
            page.layout = files as List
        }

        respond page
    }

	@Secured("ROLE_CRAYONCMS_PAGE_CREATE")
    @Transactional
    def save(Page page) {
        if (page == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (page.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond page.errors, view:'create'
            return
        }

        page.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'page.label', default: 'Page'), page.name])
				flash.outcome = "success"
                //redirect page
				redirect action: "index"
            }
            '*' { respond page, [status: CREATED, view: "index"] }
        }
    }

	@Secured("ROLE_CRAYONCMS_PAGE_EDIT")
    def edit(Page page) {
        respond page
    }

	@Secured("ROLE_CRAYONCMS_PAGE_EDIT")
    @Transactional
    def update(Page page) {
        if (page == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (page.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond page.errors, view:'edit'
            return
        }

        page.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'page.label', default: 'Page'), page.name])
				flash.outcome = "success"
                //redirect page
				redirect action: "index"
            }
            '*'{ respond page, [status: OK] }
        }
    }

	@Secured("ROLE_CRAYONCMS_PAGE_DELETE")
    @Transactional
    def delete(Page page) {

        if (page == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        page.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'page.label', default: 'Page'), page.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'page.label', default: 'Page'), params.id])
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
