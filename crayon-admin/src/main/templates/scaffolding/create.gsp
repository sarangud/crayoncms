<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="crayoncms_main" />
        <g:set var="entityName" value="\${message(code: '${propertyName}.label', default: '${className}')}" />
        <title><g:message code="default.new.label" args="[entityName]" /></title>
    </head>
    <body>
        <content tag="header">
            <g:message code="default.new.label" args="[entityName]" />
        </content>
        <content class="right-menu">
            
        </content>
    
        <div id="create-${propertyName}" class="content scaffold-create" role="main">
            <g:if test="\${flash.message}">
            	<div class="alert alert-\${flash.outcome} alert-dismissible" role="status">
                	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                	\${flash.message}
                </div>
            </g:if>
            <g:hasErrors bean="\${this.${propertyName}}">
            <ul class="errors" role="alert">
                <g:eachError bean="\${this.${propertyName}}" var="error">
                <li <g:if test="\${error in org.springframework.validation.FieldError}">data-field-id="\${error.field}"</g:if>><g:message error="\${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form action="save">
                <f:all bean="${propertyName}"/>
                <g:submitButton name="create" class="btn btn-success" value="\${message(code: 'default.button.save.label', default: 'Save')}" />
                <g:link class="btn btn-default" action="index"><g:message code="default.button.cancel.label" /></g:link>
            </g:form>
        </div>
    </body>
</html>
