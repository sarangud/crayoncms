<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="crayoncms_main" />
        <g:set var="entityName" value="${message(code: 'page.label', default: 'Page')}" />
        <title><g:message code="default.lists.label" args="[entityName]" /></title>
    </head>
    <body>
       	<content tag="header">
        	<g:message code="default.lists.label" args="[entityName]" />
        </content>
        <content tag="right-menu">
        	<sec:link class="btn btn-info" action="create" expression="hasRole('ROLE_CRAYONCMS_PAGE_CREATE')">
        	    <g:message code="default.new.label" args="[entityName]" />
        	</sec:link>
        </content>
        <div id="list-page" class="content scaffold-list" role="main">
            
            <f:table collection="${pageList}" properties="['name', 'slug', 'status', 'access']" />

			<g:if test="${pageCount > 20 }">
            	<div class="pagination">
                	<g:paginate total="${pageCount ?: 0}" />
            	</div>
            </g:if>
        </div>
    </body>
</html>