$(document).ready(function() {
    $.getJSON("/forum/tags", function(jsonData, textStatus){
        $("#wordcloud").jQCloud(jsonData);
    });
});
