

function Question(id, title, createdAt, description, userId) {
    var self = this;
    self.id = id;
    self.title = title;
    self.createdAt = createdAt;
    self.description = description;
    self.userId = userId;
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
                     new Question(question.id, question.title, question.createdAt, question.description, question.userId)
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

