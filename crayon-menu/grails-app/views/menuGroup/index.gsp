<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="crayoncms_main" />
        <g:set var="entityName" value="${message(code: 'menu.label', default: 'Menu Group')}" />
        <title><g:message code="default.lists.label" args="[entityName]" /></title>
    </head>
    <body>
        <content tag="header">
        	<g:message code="default.lists.label" args="[entityName]" /></h1>
        </content>
        <content tag="right-menu">
       		<g:link class="btn btn-info" action="create" data-toggle="modal" data-target=".modal"><g:message code="default.new.label" args="[entityName]"/></g:link>
            <g:link class="btn btn-info" controller="menu" action="create"><g:message code="default.new.label" args="['Menu']" /></g:link>
        </content>
        
        <div id="list-menuGroup" class="content scaffold-list" role="main">
			
			<g:if test="${menuGroupList}">
				<g:each in="${menuGroupList}" var="menuGroup">
					<div class="panel panel-default">
  						<div class="panel-heading">
  							<div class="row">
  								<span class="col-md-8"><h3 class="panel-title">${menuGroup.name}</h3></span>
  								<span class="col-md-4 text-right">
  									<g:form resource="${menuGroup}" method="DELETE">
        								<g:link class="btn btn-warning btn-small" action="edit" resource="${menuGroup}" data-toggle="modal" data-target=".modal"><g:message code="default.button.edit.label" default="Edit" /></g:link>       
                						<input class="btn btn-danger btn-small" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
            						</g:form>
            					</span>
            				</div>
  						</div>
  						<div class="panel-body">
  							<ol class="menu ui-sortable">
  								<crayoncms:adminMenu groupName="${menuGroup.name}" />
    						</ol>
  						</div>
					</div>
				</g:each>
			</g:if>
			
        </div>
    </body>
</html>