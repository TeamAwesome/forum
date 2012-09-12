var tagCloudConvert = function(tagObjects){
    var words = [];
    for(var i = 0; i < tagObjects.length; i++){
        words[i] = {
            text: tagObjects[i].value,
            weight: tagObjects[i].count,
            link: "./question/search/tag/" + tagObjects[i].value
        };
    }
    return words;
};