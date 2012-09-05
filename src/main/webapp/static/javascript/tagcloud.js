function TagCloud(){
    var word_list;

    var createSampleData=function(){
        this.word_list = [
                           {text: "Lorem", weight: 11, link:"fjdkjkl"},
                           {text: "Home", weight: 15, link: "http://localhost:8080/forum/", title: "Tags"},
                           {text: "Color", weight: 6},
                           {text: "Sit", weight: 7},
                           {text: "Amet", weight: 5},
                           {text: "books", weight: 5},
                           {text: "climate", weight: 50},
                           {text: "places", weight: 79},
                           {text: "food", weight: 200},
                           {text: "bangalore", weight: 0},
                           {text: "java", weight: 2}
                        ];

         insertTagCloudData(this.word_list);

    }

     var insertTagCloudData=function(temp_list){
            word_list= temp_list;
     }
     var createTagCloud=function(){
            $(document).ready(function() {
               $("#wordcloud").jQCloud(word_list);
            });
     }
     createSampleData();
     createTagCloud();

     var getFirstSpan=function(){
         return document.getElementById("wordcloud_word_0");
     }
}
TagCloud();
