<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="admin" />
        <g:set var="entityName" value="${message(code: 'page.label', default: 'Page')}" />
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
        <div id="create-page" class="content scaffold-create" role="main">
            <g:if test="${flash.message}">
            	<div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.page}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.page}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form action="save">
            	<div class="row">
            		<div class="col-md-9">
            			<f:field bean="page" property="name" />
						<f:field bean="page" property="slug" />
						<f:field bean="page" property="status" />
						<div class="form-group">
							<label class="control-label" for="content">Content</label>
							<textarea class="form-control" name="content" id="content"></textarea>
						</div>
            		</div>
            		<div class="col-md-3">
            			<f:field bean="page" property="description" />
						<f:field bean="page" property="keywords" />
						<f:field bean="page" property="access" />
						<f:field bean="page" property="layout" />
	            	</div>
               </div>
				<g:hiddenField name="content" value="" />
                <g:submitButton name="create" class="btn btn-success" value="${message(code: 'default.button.save.label', default: 'Save')}" />
                <g:link class="btn btn-default" action="index"><g:message code="default.button.cancel.label" /></g:link>
            </g:form>
        </div>
    </body>
</html>
