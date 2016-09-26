<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Crayon CMS"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
	<link href="https://fonts.googleapis.com/css?family=Grand+Hotel" rel="stylesheet">
    <asset:stylesheet src="crayoncms.css"/>

    <g:layoutHead/>
</head>
<body>

    <div class="navbar navbar-default navbar-static-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <g:link class="navbar-brand logo" controller="dashboard">Crayon</g:link>
            </div>
            <div class="navbar-collapse collapse" aria-expanded="false">
                <ul class="nav navbar-nav">
                    <sec:ifLoggedIn>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Content <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><g:link controller="page">Pages</g:link></li>
                            <li><g:link controller="block">Blocks</g:link></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Structure <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><g:link controller="menuGroup">Menu Group</g:link></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Users <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><g:link controller="roleGroup">Groups & Roles</g:link></li>
                            <li><g:link controller="user">Users</g:link></li>
                        </ul>
                    </li>
                    <li><g:link controller="plugin">Plugins</g:link></li>
                    <li><g:link controller="blog">Settings</g:link></li>
                    </sec:ifLoggedIn>
                    
                </ul>

                 <ul class="nav navbar-nav navbar-right">
                    <sec:ifLoggedIn>
                        <li class="right"><a href="/" target="_blank">View Site</a></li>
                        <li class="right dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><sec:username /> <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><g:link controller="user" action="changepwd" >Change Password</g:link></li>
                                <li><g:link controller="logout">Logout</g:link></li>
                            </ul>
                        </li>
                    </sec:ifLoggedIn>
                 </ul>
                 

            </div>
        </div>
    </div>

    <div class="container">
    	<div class="vertical-align margin-10-30">
            <div class="text-left">
                <h1><g:pageProperty name="page.header" /></h1>
            </div>
            <div class="text-right">
            	<g:pageProperty name="page.right-menu" />
            </div>
        </div>
        
        <g:if test="${flash.message}">
            <div class="alert alert-${flash.outcome} alert-dismissible" role="status">
            	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
            		<span aria-hidden="true">&times;</span>
            	</button>
            	${flash.message}
            </div>
        </g:if>
        
        <g:layoutBody/>

        <div class="footer" role="contentinfo">
            <div>CrayonCMS was made by Gogula Rajaprabhu / &copy 2016 Crayon - version ${applicationContext.getBean('pluginManager')?.getGrailsPlugin("crayon-core")?.version}</div>
            <div>Environment: ${grails.util.Environment.current.name},
                 Grails: <g:meta name="info.app.grailsVersion"/>,
                 Groovy: ${GroovySystem.getVersion()},
                 JVM: ${System.getProperty('java.version')},
                 Reloading: ${grails.util.Environment.reloadingAgentEnabled}
           </div>
        </div>
    </div>

    <div id="spinner" class="spinner" style="display:none;">
        <g:message code="spinner.alt" default="Loading&hellip;"/>
    </div>
    
    <div class="modal fade" tabindex="-1" role="dialog">
 		<div class="modal-dialog modal-lg" role="document">
   			<div class="modal-content">
     			Loading...
   			</div>
		</div>
	</div>

    <asset:javascript src="crayoncms.js"/>

</body>
</html>
