<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="admin" />
        <g:set var="entityName" value="${message(code: 'block.label', default: 'Block')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
    	<content tag="header">
       		<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
       	</content>
        <content tag="right-menu">
	        <g:form resource="${this.block}" method="DELETE">
	        	<input class="btn btn-danger" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
	        </g:form>
        </content>
        <div id="edit-block" class="content scaffold-edit" role="main">
            <g:hasErrors bean="${this.block}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.block}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.block}" method="PUT">
                <g:hiddenField name="version" value="${this.block?.version}" />
                <f:all bean="block"/>
                <input class="btn btn-success" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                <g:link class="btn btn-default" action="index"><g:message code="default.button.cancel.label" /></g:link>
            </g:form>
        </div>
    </body>
</html>
