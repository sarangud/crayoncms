<!DOCTYPE HTML>
<html>
    <g:render template="/templates/meta" />
    <body class="right-sidebar">
        <div id="page-wrapper">

            <g:render template="/templates/header" />

            <!-- Main -->
            <div class="wrapper style1">

                <div class="container">
                    <div class="row 200%">
                        <div class="8u 12u(mobile)" id="content">
                            <article id="main">
                                ${page.content.encodeAsRaw()}
                            </article>
                        </div>
                        <div class="4u 12u(mobile)" id="sidebar">
                            <hr class="first" />
                            <section>
                                <header>
                                    <h3><a href="#">Accumsan sed penatibus</a></h3>
                                </header>
                                <p>
                                    Dolor sed fringilla nibh nulla convallis tique ante proin sociis accumsan lobortis. Auctor etiam
                                    porttitor phasellus tempus cubilia ultrices tempor sagittis  tellus ante diam nec penatibus dolor cras
                                    magna tempus feugiat veroeros.
                                </p>
                                <footer>
                                    <a href="#" class="button">Learn More</a>
                                </footer>
                            </section>
                            <hr />
                            <section>
                                <header>
                                    <h3><a href="#">Sed lorem etiam consequat</a></h3>
                                </header>
                                <p>
                                    Tempus cubilia ultrices tempor sagittis. Nisl fermentum consequat integer interdum.
                                </p>
                                <div class="row 50%">
                                    <div class="4u">
                                        <a href="#" class="image fit"><asset:image src="pic10.jpg" alt="" /></a>
                                    </div>
                                    <div class="8u">
                                        <h4>Nibh sed cubilia</h4>
                                        <p>
                                            Amet nullam fringilla nibh nulla convallis tique ante proin.
                                        </p>
                                    </div>
                                </div>
                                <div class="row 50%">
                                    <div class="4u">
                                        <a href="#" class="image fit"><asset:image src="pic11.jpg" alt="" /></a>
                                    </div>
                                    <div class="8u">
                                        <h4>Proin sed adipiscing</h4>
                                        <p>
                                            Amet nullam fringilla nibh nulla convallis tique ante proin.
                                        </p>
                                    </div>
                                </div>
                                <div class="row 50%">
                                    <div class="4u">
                                        <a href="#" class="image fit"><asset:image src="pic12.jpg" alt="" /></a>
                                    </div>
                                    <div class="8u">
                                        <h4>Lorem feugiat magna</h4>
                                        <p>
                                            Amet nullam fringilla nibh nulla convallis tique ante proin.
                                        </p>
                                    </div>
                                </div>
                                <div class="row 50%">
                                    <div class="4u">
                                        <a href="#" class="image fit"><asset:image src="pic13.jpg" alt="" /></a>
                                    </div>
                                    <div class="8u">
                                        <h4>Sed tempus fringilla</h4>
                                        <p>
                                            Amet nullam fringilla nibh nulla convallis tique ante proin.
                                        </p>
                                    </div>
                                </div>
                                <div class="row 50%">
                                    <div class="4u">
                                        <a href="#" class="image fit"><asset:image src="pic14.jpg" alt="" /></a>
                                    </div>
                                    <div class="8u">
                                        <h4>Malesuada fermentum</h4>
                                        <p>
                                            Amet nullam fringilla nibh nulla convallis tique ante proin.
                                        </p>
                                    </div>
                                </div>
                                <footer>
                                    <a href="#" class="button">Magna Adipiscing</a>
                                </footer>
                            </section>
                        </div>
                    </div>
                </div>

            </div>

            <g:render template="/templates/footer" />
        </div>

        <g:render template="/templates/scripts" />
    </body>
</html>