import com.crayoncms.Role
import com.crayoncms.RoleGroup
import com.crayoncms.RoleGroupRole
import com.crayoncms.User
import com.crayoncms.UserRoleGroup

class CrayonUserBootStrap {

	def pluginManager
	
    def init = { servletContext ->
        
		try {
			
			// By default, these 2 groups will exist
			def adminGroup = RoleGroup.findOrSaveWhere(name: "Administrator")
			def authenticatedGroup = RoleGroup.findOrSaveWhere(name: "Authenticated")
			
			def adminUser = new User(username: 'admin', password: 'password').save()
            def authenticatedUser = new User(username: "authenticated", password: "password").save()
			
			// Lets load the roles given in each plugin into the table
			pluginManager.allPlugins.each { plugin -> 
				def roles = plugin.getProperties()?.crayonMeta?.roles
				if(roles) {
					roles.each { key, value ->
						def role = Role.findOrSaveWhere("authority": key, "authorityName": value, "plugin": plugin.getProperties()?.title)
						RoleGroupRole.create adminGroup, role
					}
				}
			}

			UserRoleGroup.create adminUser, adminGroup
			
			RoleGroupRole.create authenticatedGroup, Role.findByAuthority("ROLE_UPDATE_PROFILE")
			UserRoleGroup.create authenticatedUser, authenticatedGroup


        } catch(e) {
            println e
        }

    }
    def destroy = {
    }
}
