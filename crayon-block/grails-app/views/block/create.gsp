<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="crayoncms_main" />
        <g:set var="entityName" value="${message(code: 'block.label', default: 'Block')}" />
        <title><g:message code="default.new.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="vertical-align margin-10-30">
            <div class="text-left">
                <h1><g:message code="default.new.label" args="[entityName]" /></h1>
            </div>
            <div class="text-right">
                
            </div>
        </div>
        <div id="create-block" class="content scaffold-create" role="main">
            <g:if test="${flash.message}">
            	<div class="alert alert-${flash.outcome} alert-dismissible" role="status">
                	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                	${flash.message}
                </div>
            </g:if>
            <g:hasErrors bean="${this.block}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.block}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form action="save">
                <f:all bean="block"/>
                <g:submitButton name="create" class="btn btn-success" value="${message(code: 'default.button.save.label', default: 'Save')}" />
                <g:link class="btn btn-default" action="index"><g:message code="default.button.cancel.label" /></g:link>
            </g:form>
        </div>
    </body>
</html>
