<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="admin" />
        <g:set var="entityName" value="${message(code: 'roleGroup.label', default: 'Role Group')}" />
        <title><g:message code="default.lists.label" args="[entityName]" /></title>
    </head>
    <body>
        <content tag="header">
        	<g:message code="default.lists.label" args="[entityName]" /></h1>
        </content>
        <content tag="right-menu">
        	<g:link class="btn btn-info" action="create" data-toggle="modal" data-target=".modal">
        		<g:message code="default.new.label" args="[entityName]" />
        	</g:link>
        </content>
        
        <div id="list-roleGroup" class="content scaffold-list" role="main">

			<g:if test="${roleGroupList}">
				<div class="row">
				<div class="col-md-3 col-sm-3">
				
				<ul class="">
					<g:each in="${roleGroupList}" var="roleGroup">
						<li class="list"><g:link resource="roleGroup">${roleGroup.name}</g:link></li>
					</g:each>
					</ul>
				
				</div>
				<div class="col-md-9 col-sm-9">
				<g:each in="${roleGroupList}" var="roleGroup">
					<div class="panel panel-default">
  						<div class="panel-heading">
  							<div class="row">
  								<span class="col-md-8"><h3 class="panel-title">${roleGroup.name}</h3></span>
  								<span class="col-md-4 text-right">
  									<g:form resource="${roleGroup}" method="DELETE">
  										<g:link class="btn btn-info btn-small" controller="roleGroupRole" action="create" params="['roleGroup': roleGroup]" data-toggle="modal" data-target=".modal"><g:message code="default.button.add.label" args="['Role']" /></g:link>
        								<g:link class="btn btn-warning btn-small" controller="roleGroup" action="edit" resource="${roleGroup}" data-toggle="modal" data-target=".modal"><g:message code="default.button.edit.label" default="Edit" /></g:link>       
                						<input class="btn btn-danger btn-small" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
            						</g:form>
            					</span>
            				</div>
  						</div>
  						<div class="panel-body">
  							<ul>
  								<g:each in="${roleGroup.authorities}" var="role">
  								<li class="list">
  									${role}
  									<!-- span class="text-right">
  										<g:form resource="${role}" method="DELETE">
  											<input class="btn btn-danger btn-small" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
  										</g:form>
  									</span -->
  								</li>
  								</g:each>
    						</ul>
  						</div>
					</div>
				</g:each>
				</div>
				</div>
			</g:if>
		</div>
    </body>
</html>