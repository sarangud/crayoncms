import com.crayoncms.Page
import com.crayoncms.enums.PageStatus

class CrayonPageBootStrap {
	
    def init = { servletContext ->
        
		try {
			
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

        } catch(e) {
            println e
        }

    }
    def destroy = {
    }
}
