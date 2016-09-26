package com.crayoncms

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_MANAGE_USERS")
@Transactional(readOnly = true)
class RoleGroupRoleController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 20, 100)
        respond RoleGroupRole.list(params), model:[roleGroupRoleCount: RoleGroupRole.count()]
    }

    def show(RoleGroupRole roleGroupRole) {
        respond roleGroupRole
    }

    def create() {
        respond new RoleGroupRole(params)
    }

    @Transactional
    def save(RoleGroupRole roleGroupRole) {
        if (roleGroupRole == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (roleGroupRole.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond roleGroupRole.errors, view:'create'
            return
        }

        roleGroupRole.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'roleGroupRole.label', default: 'RoleGroupRole'), roleGroupRole.role])
                flash.outcome = "success"
                redirect controller: "roleGroup", action: "index"
            }
            '*' { respond roleGroupRole, [status: CREATED] }
        }
    }

    def edit(RoleGroupRole roleGroupRole) {
        respond roleGroupRole
    }

    @Transactional
    def update(RoleGroupRole roleGroupRole) {
        if (roleGroupRole == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (roleGroupRole.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond roleGroupRole.errors, view:'edit'
            return
        }

        roleGroupRole.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'roleGroupRole.label', default: 'RoleGroupRole'), roleGroupRole.role])
                flash.outcome = "success"
                redirect controller: "roleGroup", action: "index"
            }
            '*'{ respond roleGroupRole, [status: OK] }
        }
    }

    @Transactional
    def delete(RoleGroupRole roleGroupRole) {

        if (roleGroupRole == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        roleGroupRole.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'roleGroupRole.label', default: 'RoleGroupRole'), roleGroupRole.role])
                flash.outcome = "success"
                redirect controller: "roleGroup", action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'roleGroupRole.label', default: 'RoleGroupRole'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
