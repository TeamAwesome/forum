<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
    <title>Login</title>
</head>

<body onload='document.loginForm.Username.focus();'>

    <form name="loginForm" action="login" method = "POST">
        <div style="color:red; text-align:center" id="messagetobedisplayed">
            ${messageToBeDisplayed}
        </div>
        <table align="left">
            <tr>
                <td>
                    <table style="margin-left:50">
                        <tr>
                            <td>Username:<FONT color="red">
                            <div style="color:red; text-align:center" id="usernameError">
                               ${usernameError}
                            </div>
                        </tr>

                        <tr>
                            <td><input path="username" type = "text" name = "username" /></td>
                        </tr>

                        <tr>
                            <td>Password:<FONT color="red">
                            <div style="color:red; text-align:center" id="passwordError">
                               ${passwordError}
                            </div>
                        </tr>
                        <tr>
                            <td><input path="password" type ="password" name = "password" /></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Submit" name = "submit"/></td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
