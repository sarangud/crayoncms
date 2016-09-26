package com.crayoncms

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_MANAGE_USERS")
@Transactional(readOnly = true)
class RoleGroupController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 20, 100)
		def roleGroupList = 
        respond RoleGroup.list(params), model:[roleGroupCount: RoleGroup.count()]
    }

    def show(RoleGroup roleGroup) {
        respond roleGroup
    }

    def create() {
        respond new RoleGroup(params)
    }

    @Transactional
    def save(RoleGroup roleGroup) {
        if (roleGroup == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (roleGroup.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond roleGroup.errors, view:'/roleGroupRole/index'
            return
        }

        roleGroup.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'roleGroup.label', default: 'RoleGroup'), roleGroup.name])
                flash.outcome = "success"
                redirect action: "index"
            }
            '*' { respond roleGroup, [status: CREATED] }
        }
    }

    def edit(RoleGroup roleGroup) {
        respond roleGroup
    }

    @Transactional
    def update(RoleGroup roleGroup) {
        if (roleGroup == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (roleGroup.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond roleGroup.errors, view:'/roleGroupRole/index'
            return
        }

        roleGroup.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'roleGroup.label', default: 'RoleGroup'), roleGroup.name])
                flash.outcome = "success"
                redirect action: "index"
            }
            '*'{ respond roleGroup, [status: OK] }
        }
    }

    @Transactional
    def delete(RoleGroup roleGroup) {

        if (roleGroup == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        roleGroup.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'roleGroup.label', default: 'RoleGroup'), roleGroup.name])
                flash.outcome = "success"
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'roleGroup.label', default: 'RoleGroup'), params.id])
                redirect acontroller: "roleGroupRole", ction: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
