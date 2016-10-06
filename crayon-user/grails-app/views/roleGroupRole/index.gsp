<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="crayoncms_main" />
        <g:set var="entityName" value="${message(code: 'roleGroupRole.label', default: 'Groups & Role')}" />
        <title><g:message code="default.lists.label" args="[entityName]" /></title>
    </head>
    <body>
        <content tag="header">
        	<g:message code="default.lists.label" args="[entityName]" /></h1>
        </content>
        <content tag="right-menu">
        	<g:link class="btn btn-info" controller="roleGroup" action="create" data-toggle="modal" data-target=".modal">
        		<g:message code="default.new.label" args="['Group']" />
        	</g:link>
        </content>
        
        <div id="list-roleGroupRole" class="content scaffold-list" role="main">

            <f:table collection="${roleGroupRoleList}" />

			<g:if test="${roleGroupRoleCount > 20 }">
            	<div class="pagination">
                	<g:paginate total="${roleGroupRoleCount ?: 0}" />
            	</div>
            </g:if>
        </div>
    </body>
</html>