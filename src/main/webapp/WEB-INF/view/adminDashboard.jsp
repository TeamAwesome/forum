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
    <script language="javascript" type="text/javascript" src='<c:url value="/static/jsquery/jqplot.highlighter.min.js" />'></script>
    <script src='http://connect.facebook.net/en_US/all.js'></script>
    <script src="<c:url value="/static/javascript/shareToSocialMedia.js"/>"></script>
    <script src="<c:url value="/static/javascript/knockout-2.1.0.js"/>"></script>
</head>


<body>

<div id="container">
    <div id="header">
        <%@ include file="registerHeader.jsp" %>
    </div>
    <div id="content">
        <div id ="leftPane" >
            <span>Welcome to the Admin Dashboard, ${username}</span> </br></br>

            <span>
                </br></br>
                Statistics
                <div id="chartdiv" style="height:300px;width:400px; "></div>
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
