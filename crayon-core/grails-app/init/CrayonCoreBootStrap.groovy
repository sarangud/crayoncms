import com.crayoncms.Menu
import com.crayoncms.MenuGroup
import com.crayoncms.Role
import com.crayoncms.RoleGroup
import com.crayoncms.RoleGroupRole
import com.crayoncms.User
import com.crayoncms.UserRoleGroup
import com.crayoncms.enums.MenuType

class CrayonCoreBootStrap {

	def pluginManager
	
    def init = { servletContext ->
        
		try {
			
			// By default, these 2 groups will exist
			def adminGroup = RoleGroup.findOrSaveWhere(name: "Administrator")
			def authenticatedGroup = RoleGroup.findOrSaveWhere(name: "Authenticated")
			
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

            def adminUser = new User(username: 'admin', password: 'iamjoker').save()
            def authenticatedUser = new User(username: "authenticated", password: "iamjoker").save()
			
			def coreRoles = [:]
			
			def userPluginRoles = [:] << ["ROLE_MANAGE_USERS": "Manage users", "ROLE_MANAGE_ROLEGROUPS": "Manage groups and roles"]
			
			def defAuthRoles = [:] << ["ROLE_UPDATE_PROFILE": "Manage own profile"]
			
			coreRoles << userPluginRoles << defAuthRoles
			coreRoles.each { key, value ->
				def role = Role.findOrSaveWhere("authority": key, "authorityName": value, "plugin": "Users")
				RoleGroupRole.create adminGroup, role
			}
			
			UserRoleGroup.create adminUser, adminGroup
			
			RoleGroupRole.create authenticatedGroup, Role.findByAuthority("ROLE_UPDATE_PROFILE")
			UserRoleGroup.create authenticatedUser, authenticatedGroup

            
           
			def header = MenuGroup.findOrSaveWhere(name: "Header")
			def footer = MenuGroup.findOrSaveWhere(name: "Footer")
			
			Menu.findOrSaveWhere(name: "Home", menuType: MenuType.PAGE, menuTypeValue: "/home", menuGroup: header, 
				position: 1, parent:0, cssClass: "", access: "", targetBlank: false)
			Menu.findOrSaveWhere(name: "Dropdown", menuType: MenuType.PAGE, menuTypeValue: "#", menuGroup: header, 
				position: 2, parent:0, cssClass: "", access: "", targetBlank: false)
			Menu.findOrSaveWhere(name: "Right Sidebar", menuType: MenuType.PAGE, menuTypeValue: "/right-sidebar", menuGroup: header, 
				position: 3, parent:0, cssClass: "", access: "", targetBlank: false)
			Menu.findOrSaveWhere(name: "About", menuType: MenuType.PAGE, menuTypeValue: "/about", menuGroup: header, 
				position: 4, parent: 0, cssClass: "", access: "", targetBlank: false)
			Menu.findOrSaveWhere(name: "Login", menuType: MenuType.PAGE, menuTypeValue: "/login", menuGroup: header,
				position: 5, parent: 0, cssClass: "", access: "", targetBlank: false)
			Menu.findOrSaveWhere(name: "Admin", menuType: MenuType.PAGE, menuTypeValue: "/page", menuGroup: header,
				position: 6, parent: 0, cssClass: "", access: "", targetBlank: false)
			Menu.findOrSaveWhere(name: "Logout", menuType: MenuType.PAGE, menuTypeValue: "/logout", menuGroup: header,
				position: 7, parent: 0, cssClass: "", access: "", targetBlank: false)
			
			Menu.findOrSaveWhere(name: "Lorem ipsum dolor", menuType: MenuType.PAGE, menuTypeValue: "#", menuGroup: header,
				position: 1, parent: 2, cssClass: "", access: "", targetBlank: false)
			Menu.findOrSaveWhere(name: "Magna phasellus", menuType: MenuType.PAGE, menuTypeValue: "#", menuGroup: header,
				position: 2, parent: 2, cssClass: "", access: "", targetBlank: false)
			Menu.findOrSaveWhere(name: "Etiam dolore nisl", menuType: MenuType.PAGE, menuTypeValue: "#", menuGroup: header,
				position: 3, parent: 2, cssClass: "", access: "", targetBlank: false)
			Menu.findOrSaveWhere(name: "And a submenu &hellip;", menuType: MenuType.PAGE, menuTypeValue: "#", menuGroup: header,
				position: 4, parent: 2, cssClass: "", access: "", targetBlank: false)
			Menu.findOrSaveWhere(name: "Veroeros feugiat", menuType: MenuType.PAGE, menuTypeValue: "#", menuGroup: header,
				position: 5, parent: 2, cssClass: "", access: "", targetBlank: false)
			
			Menu.findOrSaveWhere(name: "Lorem ipsum dolor", menuType: MenuType.PAGE, menuTypeValue: "#", menuGroup: header,
				position: 1, parent: 11, cssClass: "", access: "", targetBlank: false)
			Menu.findOrSaveWhere(name: "Magna phasellus", menuType: MenuType.PAGE, menuTypeValue: "#", menuGroup: header,
				position: 2, parent: 11, cssClass: "", access: "", targetBlank: false)
			Menu.findOrSaveWhere(name: "Phasellus consequat", menuType: MenuType.PAGE, menuTypeValue: "#", menuGroup: header,
				position: 3, parent: 11, cssClass: "", access: "", targetBlank: false)

        } catch(e) {
            println e
        }

    }
    def destroy = {
    }
}
