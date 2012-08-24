<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/app/static/jsquery/jquery.jqplot.css" />
<script language="javascript" type="text/javascript" src="/app/static/jsquery/jquery.js"></script>
<script language="javascript" type="text/javascript" src="/app/static/jsquery/jquery.min.js"></script>
<script language="javascript" type="text/javascript" src="/app/static/jsquery/jquery.jqplot.min.js"></script>
<script language="javascript" type="text/javascript" src="/app/static/jsquery/jqplot.canvasAxisLabelRenderer.js"></script>
<script language="javascript" type="text/javascript" src="/app/static/jsquery/jqplot.canvasTextRenderer.min.js"></script>
<script language="javascript" type="text/javascript" src="/app/static/javascript/graphsForAdminDashboard.js"></script>

 <script>
     function plot(input){
         $('#chartdiv div').html('');

         plotGraphs.setQuestionsGraphFor3Months(20,30,40,input.options[input.selectedIndex].value);
         plotGraphs.plot();
      }

 </script>
    <title>Welcome</title>
</head>

<body class="admin">
<div class="title">

    <span>Welcome to the Admin Dashboard</span>

    <span align="centre"> <input type="submit"  name="View-flagged-users" value="View flagged users">
    <input type="submit"  name="Logout" value="Logout">
    </span>
    <span><br> <br>
    FILTER:
    <form name="month" action="<c:url value="/adminDashboard"/>" method="post">
        <select id="month" onChange="plot(this)">

         <option value=3 selected> 3 Months ago</option>
         <option value=6> 6 Months ago</option>
         <option value=9> 9 Months ago</option>
         <option value=12> 1 year ago</option>
         </select>
     </form>

     <br> <br>
    Statistics
    <table>
    <td><div id="chartdiv" style="height:300px;width:300px; "></div></td>
    <td width=50></td>
    <td><div id="chartdiv2" style="height:300px;width:300px; "></div></td>
    </div>
      </table>
 </Span>
</div>
</body>
<script>

        var plotGraphs = new PlotGraphs();
        plotGraphs.setQuestionsGraphFor3Months(${month1},30,40,3);
        plotGraphs.plot();


</script>

</html>
