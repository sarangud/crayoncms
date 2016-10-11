<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="crayoncms_main" />
        <g:set var="entityName" value="${message(code: 'page.label', default: 'Page')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
    	<content tag="header">
       		<h1>
       		    <sec:ifAllGranted roles="ROLE_CRAYONCMS_PAGE_EDIT">
       		        <g:message code="default.edit.label" args="[entityName]" /></h1>
       		    </sec:ifAllGranted>
       		    <sec:ifNotGranted roles="ROLE_CRAYONCMS_PAGE_EDIT">
                    <g:message code="default.view.label" args="[entityName]" /></h1>
       		    </sec:ifNotGranted>
       	</content>
        <content tag="right-menu">
            <sec:ifAllGranted roles="ROLE_CRAYONCMS_PAGE_DELETE">
	            <g:form resource="${this.page}" method="DELETE">
	        	    <input class="btn btn-danger" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
	            </g:form>
	        </sec:ifAllGranted>
        </content>
        <div id="edit-page" class="content scaffold-edit" role="main">
            <g:hasErrors bean="${this.page}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.page}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.page}" method="PUT">
                <g:hiddenField name="version" value="${this.page?.version}" />

               	<div class="row">
            		<div class="col-md-9">
            			<f:field bean="page" property="name" />
						<f:field bean="page" property="slug" />
						<f:field bean="page" property="status" />
						<f:field bean="page" property="content" />
            		</div>
            		<div class="col-md-3">
            			<f:field bean="page" property="description" />
						<f:field bean="page" property="keywords" />
						<f:field bean="page" property="access" />
						<f:field bean="page" property="layout" />
	            	</div>
               </div>

                <sec:ifAllGranted roles="ROLE_CRAYONCMS_PAGE_EDIT">
                    <input class="btn btn-success" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                    <g:link class="btn btn-default" action="index"><g:message code="default.button.cancel.label" /></g:link>
                </sec:ifAllGranted>
            </g:form>
        </div>
    </body>
</html>
