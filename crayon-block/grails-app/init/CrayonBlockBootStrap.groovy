import com.crayoncms.Block

class CrayonBlockBootStrap {
	
    def init = { servletContext ->
        
		try {
	
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
			
        } catch(e) {
            println e
        }

    }
    def destroy = {
    }
}
