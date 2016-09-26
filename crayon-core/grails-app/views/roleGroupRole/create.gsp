<g:set var="entityName" value="${message(code: 'default.button.role.label', default: 'Role')}" />

<div class="modal-header"> 
	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		<span aria-hidden="true">x</span>
	</button> 
	<h4 class="modal-title" id="myLargeModalLabel"><g:message code="default.add.label" args="[entityName]" /></h4> 
</div> 
<div class="modal-body">	
	<g:form action="save">
		<f:all bean="roleGroupRole" />
		<g:submitButton name="create" class="btn btn-success" value="${message(code: 'default.button.save.label', default: 'Save')}" />
		<g:link class="btn btn-default" data-dismiss="modal" aria-label="Cancel">
			<g:message code="default.button.cancel.label" />
		</g:link>
	</g:form>
</div> 
