<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
    <title>Join us</title>
        <link rel="stylesheet" type="text/css" href="/app/static/CLEditor1_3_0/jquery.cleditor.css" />
            <script type="text/javascript" src="/app/static/jsquery/jquery.min.js"></script>


</head>
<body class="home">

<h2>User Registration</h2>
<form:form method="post" action="submitInfo" commandName="user">

    <table>
        <tr>
        	<td>Username:</td>
        </tr>

        <tr>
        	<td><form:input path="username" /> <form:errors
        	path="username" class="errorMsg" /></td>
        </tr>

        <tr>
        	<td>Password:</td>
        </tr>

        <tr>	
        	<td><form:password path="password" /> <form:errors path="password" class="errorMsg" /></td>
        </tr>

        <tr>
       		<td>Name:</td>
        </tr>

        <tr>	
       		<td><form:input path="name" /><form:errors
        path="name" class="errorMsg" /></td>
        </tr>
        
        <tr>
       		<td>Email:</td>
        </tr>

        <tr>	
       		<td><form:input path="email" /><form:errors
        path="email" class="errorMsg" /></td>
        </tr>
        <tr>
       		<td>Phone Number:</td>
        </tr>

        <tr>	
       		<td><form:input path="phoneNumber" /><form:errors
        path="phoneNumber" class="errorMsg" /></td>
        </tr>
        
        <tr>
       		<td>Country of Origin:</td>
       	</tr>
        <tr>
       		<td><form:select path="country">
            	<form:option value="" selected="selected">Select Country</form:option>
                <form:options items="${countries}" itemValue="countryId" itemLabel="countryName" />

            </form:select></td><td>
            <form:errors
        path="country" class="errorMsg" /></td>
        </tr>
        
        <tr>
        	<td>Gender:</td>
        </tr>
        <tr>
        	<td>
            	<form:radiobutton path="gender" value="M" label="Male" />
				<form:radiobutton path="gender" value="F" label="Female" />
            </td>
        </tr>
        <tr>
            <td>Age: </td>
        </tr>
        <tr>
        	<td>
            	<form:radiobutton path="age" value="0" label="> 25" />
                <form:radiobutton path="age" value="25" label="25 - 35" />
                <form:radiobutton path="age" value="35" label="35 - 50" />
                <form:radiobutton path="age" value="50" label="50 - 70" />
                <form:radiobutton path="age" value="70" label="< 70" />
            </td>
        </tr>
        
        <tr>
            <td>Interests:</td>
        </tr>
        <tr>
            <td>
            	<form:checkbox path="interests" value="Food" label="Food" />
                <form:checkbox path="interests" value="Travel" label="Travel" />
                <form:checkbox path="interests" value="Religious sites" label="Religious sites" />
                <form:checkbox path="interests" value="Fashion" label="Fashion" />
                <form:checkbox path="interests" value="Arts" label="Arts" />
                <form:checkbox path="interests" value="Music" label="Music" />
            </td>
        </tr>
        
        
        <tr>
            <td>Knowledge Areas:</td>
        </tr>
        <tr>
            <td>
            	<form:checkbox path="knowledge" value="Food" label="Food" />
                <form:checkbox path="knowledge" value="Travel" label="Travel" />
                <form:checkbox path="knowledge" value="Religious sites" label="Religious sites" />
                <form:checkbox path="knowledge" value="Fashion" label="Fashion" />
                <form:checkbox path="knowledge" value="Arts" label="Arts" />
                <form:checkbox path="knowledge" value="Music" label="Music" />
            </td>
        </tr>
        
        <tr id="privacy">
        	<td><form:checkbox path="privacy" value="1" label="Privacy Settings" /></td>
        </tr>
        
       <tr>
       		<td> By submitting this form, you are agreeing to our <a name="tos" href="/forum/terms">Terms and Conditions</a>. </td>
       </tr>

        
        
        <tr>
        	<td><input type="submit" value="Register" /></td>
        </tr>
        
        

    </table>

</form:form>

</body>
</html>
