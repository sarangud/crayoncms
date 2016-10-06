<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="crayoncms_main" />
        <g:set var="entityName" value="${message(code: 'block.label', default: 'Block')}" />
        <title><g:message code="default.lists.label" args="[entityName]" /></title>
    </head>
    <body>
        <content tag="header">
            <h1><g:message code="default.lists.label" args="[entityName]" /></h1>
        </content>
        <content tag="right-menu">
            <g:link class="btn btn-info" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link>
        </content>
    
        <div id="list-block" class="content scaffold-list" role="main">
            
            <f:table collection="${blockList}" properties="['name', 'slug', 'dateCreated', 'lastUpdated']" />

			<g:if test="${blockCount > 20 }">
            	<div class="pagination">
                	<g:paginate total="${blockCount ?: 0}" />
            	</div>
            </g:if>
        </div>
    </body>
</html>