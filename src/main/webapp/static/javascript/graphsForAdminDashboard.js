 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
