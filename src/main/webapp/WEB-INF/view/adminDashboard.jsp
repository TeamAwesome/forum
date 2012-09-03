<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href='<c:url value="/static/jsquery/jquery.jqplot.css" />' />
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/style.css"/>">
    <script language="javascript" type="text/javascript" src='<c:url value="/static/jsquery/jquery.js" />'></script>
    <script language="javascript" type="text/javascript" src='<c:url value="/static/jsquery/jquery.min.js" />'></script>
    <script language="javascript" type="text/javascript" src='<c:url value="/static/jsquery/jquery.jqplot.min.js" />'></script>
    <script language="javascript" type="text/javascript" src='<c:url value="/static/jsquery/jqplot.canvasAxisLabelRenderer.js" />'></script>
    <script language="javascript" type="text/javascript" src='<c:url value="/static/jsquery/jqplot.canvasTextRenderer.min.js" />'></script>
    <script language="javascript" type="text/javascript" src='<c:url value="/static/javascript/graphsForAdminDashboard.js" />'></script>
    <script src='http://connect.facebook.net/en_US/all.js'></script>
    <script src="<c:url value="/static/javascript/shareToSocialMedia.js"/>"></script>
    <script src="<c:url value="/static/javascript/knockout-2.1.0.js"/>"></script>
</head>


<body>

<div id="container">
    <div id="header">
        <%@ include file="registerHeader.jsp" %>
    </div>

        <div id="account">
                <a name="logout" id="logout" href="<c:url value='j_spring_security_logout' />">Logout</a>
         </div>
    </span>
    <span>

    <div id="content">
        <div id ="leftPane" >
            <span>Welcome to the Admin Dashboard</span> </br></br>

            <span align="centre">
                <input type="submit"  name="View-flagged-users" value="View flagged users">
            </span>

            <span>
                </br></br>
                Statistics

                <table>
                    <tr><td>Questions &nbsp &nbsp</td><td><div id="chartdiv" style="height:300px;width:400px; "></div></td></tr>
                    <tr><td></td><td align='center'>Days</td></tr>
                </table>
            </span>
        </div>

        <div id="rightPane">
            <%@ include file="rightPane.jsp" %>
        </div>
    </div>
</div>
</body>

<script>
    var plotGraphs = new PlotGraphs();
    plotGraphs.setQuestionsGraphFor90Days(${numberOfQuestions});
    plotGraphs.plot();
</script>

</html>
