import com.crayoncms.Menu
import com.crayoncms.MenuGroup
import com.crayoncms.enums.MenuType

class CrayonMenuBootStrap {
	
    def init = { servletContext ->
        
		try {
			
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
