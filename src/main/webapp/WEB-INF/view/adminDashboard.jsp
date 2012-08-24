<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/app/static/jsquery/jquery.jqplot.css" />
<script language="javascript" type="text/javascript" src="/app/static/jsquery/jquery.js"></script>
<script language="javascript" type="text/javascript" src="/app/static/jsquery/jquery.min.js"></script>
<script language="javascript" type="text/javascript" src="/app/static/jsquery/jquery.jqplot.min.js"></script>
<script language="javascript" type="text/javascript" src="/app/static/jsquery/jqplot.canvasAxisLabelRenderer.js"></script>
<script language="javascript" type="text/javascript" src="/app/static/jsquery/jqplot.canvasTextRenderer.min.js"></script>

 <script type= "text/javascript">
    function Chart() {
        this.
        this.plot = function(data) {

        }
    }
     $(document).ready(function(){

     $("#chartdiv").jqplot('chartdiv',  [[[80, 10],[50,5]]],{title: 'Number of Questions',axesDefaults: {
                                                                                      tickRenderer: $.jqplot.CanvasAxisTickRenderer ,
                                                                                       tickOptions: {
                                                                                         angle: -60,
                                                                                         fontSize: '10pt'
                                                                                       }
                                                                                      },axes: {
                                                                                           xaxis: {
                                                                                             renderer: $.jqplot.CategoryAxisRenderer,
                                                                                              min:'0',
                                                                                              max:'100'
                                                                                           },
                                                                                      yaxis: {
                                                                                           renderer: $.jqplot.CategoryAxisRenderer,
                                                                                            min:'0',
                                                                                            max:'12'
                                                                                         }
                                                                                       }} );
     $("#chartdiv2").jqplot('chartdiv2', [[[80, 10],[50,5],[70,10]]],{title: 'Number of Questions',axesDefaults: {
                                                                                       tickRenderer: $.jqplot.CanvasAxisTickRenderer ,
                                                                                       tickOptions: {
                                                                                       angle: -60,
                                                                                       fontSize: '10pt'
                                                                                       }
                                                                                        },axes: {
                                                                                         xaxis: {
                                                                                         renderer: $.jqplot.CategoryAxisRenderer,
                                                                                          min:'0',
                                                                                           max:'100'
                                                                                           },
                                                                                           yaxis: {
                                                                                          renderer: $.jqplot.CategoryAxisRenderer,
                                                                                           min:'0',
                                                                                          max:'12'
                                                                                         }
                                                                                        }});
                                                                                      });
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
    <select>

     <option value=3> 3 Months ago</option>
     <option value=6> 6 Months ago</option>
     <option value=9> 9 Months ago</option>
     <option value=12> 1 year ago</option>
     </select> <br> <br>
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
</html>
