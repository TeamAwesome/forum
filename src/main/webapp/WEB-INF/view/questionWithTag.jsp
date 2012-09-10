<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<link rel="stylesheet" type="text/css" href='<c:url value="/static/css/style.css"/>'/>

<head>
    <title>${tagName}</title>
</head>

<body>
 <div id="container" >
        <div id="header">
            <%@ include file="registerHeader.jsp" %>
        </div>
    <div id="content">
        <div id ="leftPane" >
            <div id="activityWallTitle">
                <h1>Questions with Tag - ${tagName}</h1>
            </div>
            <div id="activityQuestions" >
                <br /><br />
            </div>
        </div>

        <%@ include file="rightPane.jsp" %>
    </div>
</div>
</body>
</html>

