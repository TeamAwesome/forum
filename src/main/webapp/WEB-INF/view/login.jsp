<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
    <title>Login</title>
</head>

<body onload='document.loginForm.Username.focus();'>
    <div id="container">
        <form name="loginForm" action="${pageContext.request.contextPath}/j_spring_security_check" method = "POST" autocomplete="off">
            <div style="color:red; text-align:center" id="messagetobedisplayed">
                ${messageToBeDisplayed}
            </div>
            <table align="left">
                <tr>
                    <td>
                        <table style="margin-left:50">
                            <tr>
                                 <div id="noticeMessage">
                                        ${noticeMessage}
                                 </div>
                            </tr>
                            <tr>
                                  <td>Username:<FONT color="red">
                                  </td>
                            </tr>

                            <tr>
                                <td><input path="username" type = "text" name="j_username" autocomplete="off" /></td>
                                    <div style="color:red; text-align:center" id="usernameError">
                                        ${usernameError}
                                    </div>
                                </td>

                            </tr>

                            <tr>
                                <td>Password:<FONT color="red">
                                <div style="color:red; text-align:center" id="passwordError">
                                   ${passwordError}
                                </div>
                            </tr>
                            <tr>
                                <td><input path="password" type ="password" name = "j_password" /></td>
                            </tr>
                            <tr>
                                <td><input type="submit" value="Submit" name = "submit"/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
