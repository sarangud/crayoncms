<!-- Header -->
<div id="header">

    <!-- Inner -->
    <div class="inner">
        <header>
            <h1>Hi. You're looking at CrayonCMS.</h1>
            <p>A (free) responsive site template by <a href="http://html5up.net">HTML5 UP</a>.
                     Built on <strong>skel</strong> and released under the <a href="http://html5up.net/license">CCA</a> license.</p>
        </header>
    </div>

    <!-- Nav -->
    <nav id="nav">
        <ul>
            <li><a href="/">Home</a></li>
            <li>
                <a href="#">Dropdown</a>
                <ul>
                    <li><a href="#">Lorem ipsum dolor</a></li>
                    <li><a href="#">Magna phasellus</a></li>
                    <li><a href="#">Etiam dolore nisl</a></li>
                    <li>
                        <a href="#">And a submenu &hellip;</a>
                        <ul>
                            <li><a href="#">Lorem ipsum dolor</a></li>
                            <li><a href="#">Phasellus consequat</a></li>
                            <li><a href="#">Magna phasellus</a></li>
                            <li><a href="#">Etiam dolore nisl</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Veroeros feugiat</a></li>
                </ul>
            </li>
            <li><a href="/right-sidebar">Right Sidebar</a></li>
            <li><a href="/about">About</a></li>
            <sec:ifNotLoggedIn>
                <li><g:link controller="login">Login</g:link></li>
            </sec:ifNotLoggedIn>
            <sec:ifLoggedIn>
                <li><g:link controller="page">Admin</g:link></li>
                <li><g:link controller="logout">Logout</g:link></li>
            </sec:ifLoggedIn>
        </ul>
    </nav>

</div>
