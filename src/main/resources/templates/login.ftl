<#assign charset="UTF-8">
<#assign title="Example">
<#assign content>
This is content
</#assign>
<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <meta charset="${charset}">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        </head>
    <body>
        <div class="main-content">
            <h3>Login Form</h3>
            <form action="/login" method="POST">

                <input type="text" name="username" placeholder="Username" /><br />
                <input type="password" name="password" placeholder="Password" /><br />
                <button type="submit">Login</button> <br />
                </form>
            </div>
        </body>
    </html>
