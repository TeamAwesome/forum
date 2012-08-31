 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<link rel="stylesheet" type="text/css" href='<c:url value="/static/css/style.css"/>'>

<head>
    <title>Join us</title>

</head>

 <div id="container">
    <div id="header">
        <%@ include file="registerHeader.jsp" %>
    </div>

    <div id="content">
        <div id ="leftPane" >
        <form:form method="post" action="join" commandName="user">
        <h2>User Registration</h2>
            <table>
                <tr>
                    <td>Username:</td>
                </tr>

                <tr>
                    <td><form:input path="username" id="username"/> <form:errors
                    path="username" class="errorMsg" id="usernameMsg"/></td>
                </tr>

                <tr>
                    <td>Password:</td>
                </tr>

                <tr>
                    <td><form:password path="password" id="password"/> <form:errors path="password" class="errorMsg" id="passwordMsg"/></td>
                </tr>

                <tr>
                    <td>Name:</td>
                </tr>

                <tr>
                    <td><form:input path="name" id="name"/><form:errors
                path="name" class="errorMsg" id="nameMsg"/></td>
                </tr>

                <tr>
                    <td>Email:</td>
                </tr>

                <tr>
                    <td><form:input path="email" id="email"/><form:errors
                path="email" class="errorMsg" id="emailMsg"/></td>
                </tr>
                <tr>
                    <td>Phone Number:</td>
                </tr>

                <tr>
                    <td><form:input path="phoneNumber" id="phoneNumber"/><form:errors
                path="phoneNumber" class="errorMsg" id="phoneNumberMsg"/></td>
                </tr>

                <tr>
                    <td>Country of Origin:</td>
                </tr>
                <tr>
                    <td><form:select path="country" id="country">
                        <form:option value="" selected="selected">Select Country</form:option>
                        <form:options items="${countries}" itemValue="countryId" itemLabel="countryName" />

                    </form:select></td><td>
                    <form:errors
                path="country" class="errorMsg" id="countryMsg"/></td>
                </tr>

                <tr>
                    <td>Gender:</td>
                </tr>
                <tr>
                    <td>
                        <form:radiobutton path="gender" value="M" label="Male" id="genderMale"/>
                        <form:radiobutton path="gender" value="F" label="Female" id="genderFemale"/>
                    </td>
                    <td><form:errors path="gender" class="errorMsg" id="genderMsg"/></td>
                </tr>
                <tr>
                    <td>Age: </td>
                </tr>
                <tr>
                    <td>
                        <form:radiobutton path="ageRange" value="1" label="< 25" id="ageRangeLessThan25" />
                        <form:radiobutton path="ageRange" value="2" label="25 - 35" id="ageRange25To35" />
                        <form:radiobutton path="ageRange" value="3" label="35 - 50" id="ageRange35To50" />
                        <form:radiobutton path="ageRange" value="4" label="50 - 70" id="ageRange50To70" />
                        <form:radiobutton path="ageRange" value="5" label="> 70" id="ageRangeGreaterThan70" />
                    </td>
                    <td><form:errors path="ageRange" class="errorMsg" id="ageRangeMsg"/></td>
                </tr>

                <tr>
                    <td>Interests:</td>
                </tr>
                <tr>
                    <td>
                        <form:checkbox path="interests" value="1" label="Food" id="interestFood" />
                        <form:checkbox path="interests" value="2" label="Travel" id="interestTravel" />
                        <form:checkbox path="interests" value="3" label="Religious sites" id="interestReligiousSites" />
                        <form:checkbox path="interests" value="4" label="Fashion" id="interestFashion" />
                        <form:checkbox path="interests" value="5" label="Arts" id="interestArts" />
                        <form:checkbox path="interests" value="6" label="Music" id="interestMusic" />
                    </td>
                    <td><form:errors path="interests" class="errorMsg" id="interestsMessage"/></td>
                </tr>


                <tr>
                    <td>Knowledge Areas:</td>
                </tr>
                <tr>
                    <td>
                        <form:checkbox path="knowledge" value="1" label="Food" id="knowledgeFood" />
                        <form:checkbox path="knowledge" value="2" label="Travel" id="knowledgeTravel" />
                        <form:checkbox path="knowledge" value="3" label="Religious sites" id="knowledgeReligiousSites" />
                        <form:checkbox path="knowledge" value="4" label="Fashion" id="knowledgeFashion" />
                        <form:checkbox path="knowledge" value="5" label="Arts" id="knowledgeArts" />
                        <form:checkbox path="knowledge" value="6" label="Music" id="knowledgeMusic" />
                    </td>
                </tr>

                <tr id="privacy">
                    <td><form:checkbox path="privacy" value="1" label="Privacy Settings" /></td>
                </tr>

               <tr>
                    <td> By submitting this form, you are agreeing to our <a name="tos" href="terms">Terms and Conditions</a>. </td>
               </tr>



                <tr>
                    <td><input id="register" type="submit" value="Register" /></td>
                </tr>



            </table>
            </form:form>
            </div>

     </div>



</div>
</body>
</html>
