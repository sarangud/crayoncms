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

			<g:if test="${allRoleGroups}">
				<div class="row">

                    <div class="col-md-3 col-sm-3">
                        <ul class="">
                            <g:each in="${allRoleGroups}" var="roleGroup">
                                <li class="list">
                                    <div class="row">
                                        <div class="col-md-9">
                                            <g:link action="show" resource="${roleGroup}">${roleGroup.name}</g:link>
                                        </div>
                                        <g:if test="${roleGroup.name != 'Administrator' && roleGroup.name != 'Authenticated'}">
                                            <div class="col-md-1">
                                                <g:link action="edit" resource="${roleGroup}" data-toggle="modal" data-target=".modal"><i class="fa fa-pencil"></i></g:link>
                                            </div>
                                            <div class="col-md-1">
                                                <g:form resource="${roleGroup}" method="DELETE">
                                                    <input type="submit" class="fa fa-trash" value="&#xf1f8;" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                                                </g:form>
                                            </div>
                                         </g:if>
                                    </div>
                                </li>
                            </g:each>
                        </ul>
                    </div>

                    <div class="col-md-9 col-sm-9">
                        <g:each in="${allRoles}" var="plugin">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">${plugin.key}</h3>
                                </div>
                                <div class="panel-body">
                                    <ul>
                                    <g:each in="${plugin.value}" var="role">
                                        <li class="list">
                                            <div class="row">
                                                <div class="col-md-11">
                                                    ${role}
                                                </div>
                                                <div class="col-md-1 text-center">
                                                    <g:if test="${ authoritiesGrouped.find { it.key == plugin.key}?.value?.contains(role) }">
                                                        <input type="checkbox" name="${role}" checked="checked" />
                                                    </g:if>
                                                    <g:else>
                                                        <input type="checkbox" name="${role}" />
                                                    </g:else>
                                                </div>
                                            </div>
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