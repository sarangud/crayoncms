<!DOCTYPE HTML>
<html>
    <g:render template="/templates/meta" />
    <body class="no-sidebar">
        <div id="page-wrapper">

            <g:render template="/templates/header" />

            <!-- Main -->
            <div class="wrapper style1">

                <div class="container">
                    <article id="main" class="special">
                        ${page.content.encodeAsRaw()}
                    </article>
                </div>

            </div>

            <g:render template="/templates/footer" />

        </div>

        <g:render template="/templates/scripts" />
    </body>
</html>