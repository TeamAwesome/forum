<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
   <link type="text/css" rel="stylesheet" href="<c:url value="/static/css/main.css"/>">
   <title>Login</title>
</head>
<body>
 <div class="title">
     <span>Login </span>
 </div>
  <form method="post">
      <p>
        <label for="username" accesskey="U">Enter your <span class="mnemonic">U</span>sername:</label>
        <input id="username" type="text" name="username" size="20" />
      </p>
      <p>
        <label for="password" accesskey="P">Enter your <span class="mnemonic">P</span>assword:</label>
        <input id="password" type="password" name="password" size="20" />
      </p>
      <p>
        <input type="submit" value="Submit" name="submit">
      </p>
  </form>
</body>
</html>