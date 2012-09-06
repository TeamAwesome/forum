
function Question(id, title, createdAt, description, userName, likes, dislikes, flags) {
    var self = this;
    self.id = id;
    self.title = title;
    self.createdAt = createdAt;
    self.description = description;
    self.userName = userName;
    self.likes = likes;
    self.dislikes = dislikes;
    self.flags = flags;
    self.url = window.location.href + "question/view/"+id;
}

function QuestionsViewModel() {
    var self = this;
    var page = 1;
    var pageSize = 10;

    self.questions = ko.observableArray();

    var loadQuestion = function() {
         $.post("./", {"pageNum": page.toString(), "pageSize": pageSize.toString()}, function(data) {
            $.each(data, function (index, question) {

                self.questions.push(
                     new Question(question.id, question.title, question.createdAt, stripHtmlSpaces(question.description), question.user.username, question.likes, question.dislikes, question.flags)
                     );
            });
            page +=1;
         },"json");
    }

    loadQuestion();

    self.loadMoreQuestion = function() {
        loadQuestion();
    }
}

ko.applyBindings(new QuestionsViewModel());

function stripHtmlSpaces(html) {
    var space = /&nbsp;/g;
    var text2 = html.replace(space,'');
    return text2;
}