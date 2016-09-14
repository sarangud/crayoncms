import com.crayoncms.Role
import com.crayoncms.User
import com.crayoncms.UserRole
import com.crayoncms.Page
import com.crayoncms.Block
import com.crayoncms.MenuGroup
import com.crayoncms.Menu
import com.crayoncms.enums.MenuType
import com.crayoncms.enums.PageStatus

class BootStrap {

    def init = { servletContext ->
        try {
            def adminRole = new Role(authority: 'ROLE_ADMIN', authorityName: 'Administrator').save()
            def editorRole = new Role(authority: 'ROLE_AUTHENTICATED', authorityName: 'Authenticated').save()
            def userRole = new Role(authority: 'ROLE_ANONYMOUS', authorityName: 'Anonymous').save()

            def adminUser = new User(username: 'admin', password: 'iamjoker').save()
            UserRole.create adminUser, adminRole

            def editorUser = new User(username: "authenticated", password: "iamjoker").save()
            UserRole.create editorUser, editorRole

            def normalUser = new User(username: "anonymous", password: "iamjoker").save()
            UserRole.create normalUser, userRole

            new Page(
                    name: "Home", slug: "home", status: PageStatus.PUBLISHED, layout: "home",
                    description: "home page", keywords: "Grails, CMS, Crayon",
                    content: "This is home page", access: "Public"
            ).save()

            new Page(
                    name: "About", slug: "about", status: PageStatus.PUBLISHED, layout: "no-sidebar",
                    description: "about page", keywords: "Grails, CMS, Crayon",
                    content: '''<header>
    <h2><a href="#">No Sidebar</a></h2>
    <p>
        Morbi convallis lectus malesuada sed fermentum dolore amet
    </p>
</header>
<a href="#" class="image featured"><img src="/assets/pic06.jpg" alt="" /></a>
<p>
    Commodo id natoque malesuada sollicitudin elit suscipit. Curae suspendisse mauris posuere accumsan massa
    posuere lacus convallis tellus interdum. Amet nullam fringilla nibh nulla convallis ut venenatis purus
    lobortis. Auctor etiam porttitor phasellus tempus cubilia ultrices tempor sagittis. Nisl fermentum
    consequat integer interdum integer purus sapien. Nibh eleifend nulla nascetur pharetra commodo mi augue
    interdum tellus. Ornare cursus augue feugiat sodales velit lorem. Semper elementum ullamcorper lacinia
    natoque aenean scelerisque vel lacinia mollis quam sodales congue.
</p>
<section>
    <header>
        <h3>Ultrices tempor sagittis nisl</h3>
    </header>
    <p>
        Nascetur volutpat nibh ullamcorper vivamus at purus. Cursus ultrices porttitor sollicitudin imperdiet
        at pretium tellus in euismod a integer sodales neque. Nibh quis dui quis mattis eget imperdiet venenatis
        feugiat. Neque primis ligula cum erat aenean tristique luctus risus ipsum praesent iaculis. Fermentum elit
        fringilla consequat dis arcu. Pellentesque mus tempor vitae pretium sodales porttitor lacus. Phasellus
        egestas odio nisl duis sociis purus faucibus morbi. Eget massa mus etiam sociis pharetra magna.
    </p>
    <p>
        Eleifend auctor turpis magnis sed porta nisl pretium. Aenean suspendisse nulla eget sed etiam parturient
        orci cursus nibh. Quisque eu nec neque felis laoreet diam morbi egestas. Dignissim cras rutrum consectetur
        ut penatibus fermentum nibh erat malesuada varius.
    </p>
</section>
<section>
    <header>
        <h3>Augue euismod feugiat tempus</h3>
    </header>
    <p>
        Pretium tellus in euismod a integer sodales neque. Nibh quis dui quis mattis eget imperdiet venenatis
        feugiat. Neque primis ligula cum erat aenean tristique luctus risus ipsum praesent iaculis. Fermentum elit
        ut nunc urna volutpat donec cubilia commodo risus morbi. Lobortis vestibulum velit malesuada ante
        egestas odio nisl duis sociis purus faucibus morbi. Eget massa mus etiam sociis pharetra magna.
    </p>
</section>''', access: "Public"
            ).save()

            new Page(
                    name: "Right Sidebar", slug: "right-sidebar", status: PageStatus.PUBLISHED,
                    layout: "right-sidebar",
                    description: "right sidebar page", keywords: "Grails, CMS, Crayon",
                    content: '''<header>
    <h2><a href="#">Right Sidebar</a></h2>
    <p>
        Morbi convallis lectus malesuada sed fermentum dolore amet
    </p>
</header>
<a href="#" class="image featured"><img src="/assets/pic06.jpg" alt=""></a>
<p>
    Commodo id natoque malesuada sollicitudin elit suscipit. Curae suspendisse mauris posuere accumsan massa
    posuere lacus convallis tellus interdum. Amet nullam fringilla nibh nulla convallis ut venenatis purus
    lobortis. Auctor etiam porttitor phasellus tempus cubilia ultrices tempor sagittis. Nisl fermentum
    consequat integer interdum integer purus sapien. Nibh eleifend nulla nascetur pharetra commodo mi augue
    interdum tellus. Ornare cursus augue feugiat sodales velit lorem. Semper elementum ullamcorper lacinia
    natoque aenean scelerisque vel lacinia mollis quam sodales congue.
</p>
<section>
    <header>
        <h3>Ultrices tempor sagittis nisl</h3>
    </header>
    <p>
        Nascetur volutpat nibh ullamcorper vivamus at purus. Cursus ultrices porttitor sollicitudin imperdiet
        at pretium tellus in euismod a integer sodales neque. Nibh quis dui quis mattis eget imperdiet venenatis
        feugiat. Neque primis ligula cum erat aenean tristique luctus risus ipsum praesent iaculis. Fermentum elit
        fringilla consequat dis arcu. Pellentesque mus tempor vitae pretium sodales porttitor lacus. Phasellus
        egestas odio nisl duis sociis purus faucibus morbi. Eget massa mus etiam sociis pharetra magna.
    </p>
    <p>
        Eleifend auctor turpis magnis sed porta nisl pretium. Aenean suspendisse nulla eget sed etiam parturient
        orci cursus nibh. Quisque eu nec neque felis laoreet diam morbi egestas. Dignissim cras rutrum consectetur
        ut penatibus fermentum nibh erat malesuada varius.
    </p>
</section>
<section>
    <header>
        <h3>Augue euismod feugiat tempus</h3>
    </header>
    <p>
        Pretium tellus in euismod a integer sodales neque. Nibh quis dui quis mattis eget imperdiet venenatis
        feugiat. Neque primis ligula cum erat aenean tristique luctus risus ipsum praesent iaculis. Fermentum elit
        ut nunc urna volutpat donec cubilia commodo risus morbi. Lobortis vestibulum velit malesuada ante
        egestas odio nisl duis sociis purus faucibus morbi. Eget massa mus etiam sociis pharetra magna.
    </p>
</section>''', access: "Public"
            ).save()

            println Page.list()

            new Block(
                   name: "Tweets", slug: "tweets", content: '''
<section class="4u 12u(mobile)">
    <header>
        <h2 class="icon fa-twitter circled"><span class="label">Tweets</span></h2>
    </header>
    <ul class="divided">
        <li>
            <article class="tweet">
                Amet nullam fringilla nibh nulla convallis tique ante sociis accumsan.
                <span class="timestamp">5 minutes ago</span>
            </article>
        </li>
        <li>
            <article class="tweet">
                Hendrerit rutrum quisque.
                <span class="timestamp">30 minutes ago</span>
            </article>
        </li>
        <li>
            <article class="tweet">
                Curabitur donec nulla massa laoreet nibh. Lorem praesent montes.
                <span class="timestamp">3 hours ago</span>
            </article>
        </li>
        <li>
            <article class="tweet">
                Lacus natoque cras rhoncus curae dignissim ultricies. Convallis orci aliquet.
                <span class="timestamp">5 hours ago</span>
            </article>
        </li>
    </ul>
</section>'''
            ).save()

            new Block(
                    name: "Posts", "slug": "posts", content: '''
<section class="4u 12u(mobile)">
    <header>
        <h2 class="icon fa-file circled"><span class="label">Posts</span></h2>
    </header>
    <ul class="divided">
        <li>
            <article class="post stub">
                <header>
                    <h3><a href="#">Nisl fermentum integer</a></h3>
                </header>
                <span class="timestamp">3 hours ago</span>
            </article>
        </li>
        <li>
            <article class="post stub">
                <header>
                    <h3><a href="#">Phasellus portitor lorem</a></h3>
                </header>
                <span class="timestamp">6 hours ago</span>
            </article>
        </li>
        <li>
            <article class="post stub">
                <header>
                    <h3><a href="#">Magna tempus consequat</a></h3>
                </header>
                <span class="timestamp">Yesterday</span>
            </article>
        </li>
        <li>
            <article class="post stub">
                <header>
                    <h3><a href="#">Feugiat lorem ipsum</a></h3>
                </header>
                <span class="timestamp">2 days ago</span>
            </article>
        </li>
    </ul>
</section>'''
            ).save()

            new Block(
                    name: "Photos", slug: "photos", content:'''
<section class="4u 12u(mobile)">
    <header>
        <h2 class="icon fa-camera circled"><span class="label">Photos</span></h2>
    </header>
    <div class="row 25%">
        <div class="6u">
            <a href="#" class="image fit"><img src="/assets/pic10.jpg"></a>
        </div>
        <div class="6u$">
            <a href="#" class="image fit"><img src="/assets/pic11.jpg"></a>
        </div>
        <div class="6u">
            <a href="#" class="image fit"><img src="/assets/pic12.jpg"></a>
        </div>
        <div class="6u$">
            <a href="#" class="image fit"><img src="/assets/pic13.jpg"></a>
        </div>
        <div class="6u">
            <a href="#" class="image fit"><img src="/assets/pic14.jpg"></a>
        </div>
        <div class="6u$">
            <a href="#" class="image fit"><img src="/assets/pic15.jpg"></a>
        </div>
    </div>
</section>'''
            ).save()

            new Block(
                    name: "Banner", slug: "banner", content: '''<section id="banner">
  <header>
    <h2>Hi. You're looking at <strong>Helios</strong>.</h2>
    <p>
      A (free) responsive site template by <a href="http://html5up.net">HTML5 UP</a>.
      Built on <strong>skel</strong> and released under the <a href="http://html5up.net/license">CCA</a> license.
    </p>
  </header>
</section>'''
            ).save()
			
			def header = MenuGroup.findOrSaveWhere(name: "Header")
			def footer = MenuGroup.findOrSaveWhere(name: "Footer")
			
			Menu.findOrSaveWhere(name: "Home", menuType: MenuType.PAGE, menuTypeValue: "/home", menuGroup: header, 
				position: 1, parent:0, cssClass: "", access: "", targetBlank: false)
			Menu.findOrSaveWhere(name: "About", menuType: MenuType.PAGE, menuTypeValue: "/about", menuGroup: header, 
				position: 2, parent:0, cssClass: "", access: "", targetBlank: false)
			Menu.findOrSaveWhere(name: "Conact", menuType: MenuType.PAGE, menuTypeValue: "/contact", menuGroup: header, 
				position: 0, parent:2, cssClass: "", access: "", targetBlank: false)
			Menu.findOrSaveWhere(name: "Work", menuType: MenuType.PAGE, menuTypeValue: "/work", menuGroup: header, 
				position: 3, parent: 0, cssClass: "", access: "", targetBlank: false)

        } catch(e) {
            println e
        }

    }
    def destroy = {
    }
}
