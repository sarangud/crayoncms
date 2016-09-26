package com.crayoncms

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
class BlockController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	@Secured("ROLE_VIEW_BLOCK")
    def index(Integer max) {
        params.max = Math.min(max ?: 20, 100)
        respond Block.list(params), model:[blockCount: Block.count()]
    }

	@Secured("ROLE_CREATE_BLOCK")
    def create() {
        respond new Block(params)
    }

	@Secured("ROLE_CREATE_BLOCK")
    @Transactional
    def save(Block block) {
        if (block == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (block.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond block.errors, view:'create'
            return
        }

        block.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'block.label', default: 'Block'), block.name])
                flash.outcome = "success"
                //redirect block
                redirect action: "index"
            }
            '*' { respond block, [status: CREATED] }
        }
    }

	@Secured("ROLE_EDIT_BLOCK")
    def edit(Block block) {
        respond block
    }

	@Secured("ROLE_EDIT_BLOCK")
    @Transactional
    def update(Block block) {
        if (block == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (block.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond block.errors, view:'edit'
            return
        }

        block.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'block.label', default: 'Block'), block.name])
                flash.outcome = "success"
                //redirect block
                redirect action: "index"
            }
            '*'{ respond block, [status: OK] }
        }
    }

	@Secured("ROLE_DELETE_BLOCK")
    @Transactional
    def delete(Block block) {

        if (block == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        block.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'block.label', default: 'Block'), block.name])
                flash.outcome = "success"
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'block.label', default: 'Block'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
