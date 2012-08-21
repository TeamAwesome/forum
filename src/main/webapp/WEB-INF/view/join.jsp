<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Join us</title>
     <script type="text/javascript" src="/javascript/source/joinValidations.js"></script>
</head>
<body class="home">
<div class="title">
    <span>Join us!</span>
</div>

<form action="./showprofile" method="post" >
<div class="username">
    <span>Username:</span> <input type="text" name="username" />
</div>

<div class="password">
    <span>Password:</span> <input type="password" class="password" />
</div>

<div class="confirmPassword">
    <span>Confirm Password:</span> <input type="password" class="confirmPassword" />
</div>

<div class="name">
    <span>Name:</span> <input type="text" name="name" />
</div>

<div class="emailAddress">
    <span>Email Address:</span> <input type="text" class="emailAddress" />
</div>

<div class="phoneNumber">
    <span>Phone Number:</span> <input type="text" class="phoneNumber" />
</div>

<div class="originCountry">
    <span>Country of Origin:</span> <input type="text" class="originCountry" />
</div>

<div class="gender">
    <span>Gender:</span>
    <input type="radio" name="sex" value="male" /> Male
    <input type="radio" name="sex" value="female" /> Female
</div>

<div class="age">
    <span>Age:</span>
    <input type="radio" name="age" value="< 25"/> < 25
    <input type="radio" name="age" value="25 - 35" /> 25 - 35
    <input type="radio" name="age" value="35 - 50" /> 35 - 50
    <input type="radio" name="age" value="50 - 70" /> 50 - 70
    <input type="radio" name="age" value="> 70" /> > 70

</div>

<div class="interests">
    <span>Interests:</span>
    <input type="checkbox" name="interests" value="Food" /> Food
    <input type="checkbox" name="interests" value="Travel" /> Travel
    <input type="checkbox" name="interests" value="Religious sites" /> Religious sites
    <input type="checkbox" name="interests" value="Fashion" /> Fashion
    <input type="checkbox" name="interests" value="Arts" /> Arts
    <input type="checkbox" name="interests" value="Music" /> Music
</div>

<div class="knowledge">
    <span>Knowledge Areas:</span>
    <input type="checkbox" name="knowledge" value="Food" /> Food
    <input type="checkbox" name="knowledge" value="Travel" /> Travel
    <input type="checkbox" name="knowledge" value="Religious sites" /> Religious sites
    <input type="checkbox" name="knowledge" value="Fashion" /> Fashion
    <input type="checkbox" name="knowledge" value="Arts" /> Arts
    <input type="checkbox" name="knowledge" value="Music" /> Music
</div>

<div class="privacy">
     <input type="checkbox" name="privacySettings" value="privacy" /> Privacy Settings
</div>

By submitting this form, you are agreeing to our <a href="/">Terms and Conditions</a>.

<div class="signUp">
     <input type="submit" name="signUp" value="Sign Up" />
</div>
</form>

</body>

</html>
