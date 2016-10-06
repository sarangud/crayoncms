<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="crayoncms_main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="default.lists.label" args="[entityName]" /></title>
    </head>
    <body>
        
	    <content tag="header">
	        <g:message code="default.lists.label" args="[entityName]" />
		</content>
	    <content tag="right-menu">
	        <g:link class="btn btn-info" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link>
	    </content>

        <div id="list-user" class="content scaffold-list" role="main">
        
            <f:table collection="${userList}" properties="['username', 'email', 'firstName', 'lastName', 'authorities']"/>

			<g:if test="${userCount > 20 }">
            	<div class="pagination">
                	<g:paginate total="${userCount ?: 0}" />
            	</div>
            </g:if>
        </div>
    </body>
</html>