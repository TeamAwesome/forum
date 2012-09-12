$(document).ready(function() {
    $.getJSON("/forum/tags", function(jsonData, textStatus){
        var words = tagCloudConvert(jsonData);
        $("#wordcloud").jQCloud(words);
    });
    $("#wordcloud a").click(function(event) {
        event.preventDefault();
        console.log($(this).text());
    });
});


