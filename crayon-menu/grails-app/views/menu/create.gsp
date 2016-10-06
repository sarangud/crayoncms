<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="crayoncms_main" />
        <g:set var="entityName" value="${message(code: 'menu.label', default: 'Menu')}" />
        <title><g:message code="default.new.label" args="[entityName]" /></title>
    </head>
    <body>
    	<content tag="header">
        	<g:message code="default.new.label" args="[entityName]" />
        </content>
          
        <content class="right-menu">
                
        </content>
        
        <div id="create-menu" class="content scaffold-create" role="main">
            
            <g:hasErrors bean="${this.menu}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.menu}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form action="save">
                <f:all bean="menu"/>
                <g:submitButton name="create" class="btn btn-success" value="${message(code: 'default.button.save.label', default: 'Save')}" />
                <g:link class="btn btn-default" controller="menuGroup" action="index"><g:message code="default.button.cancel.label" /></g:link>
            </g:form>
        </div>
    </body>
</html>
