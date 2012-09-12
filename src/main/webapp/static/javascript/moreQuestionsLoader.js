
function Question(id, title, createdAt, description, userName, likes, dislikes, flags) {
    this.id = id;
    this.title = title;
    this.createdAt = createdAt;
    this.description = description;
    this.userName = userName;
    this.likes = likes;
    this.dislikes = dislikes;
    this.flags = flags;
    this.url = window.location.href + "question/view/"+id;
}

function QuestionsViewModel() {
    var page = 1;
    var pageSize = 10;
    var currentSearch = "";

    this.questions = ko.observableArray();

    var self = this;
    var loadQuestions = function(url, resetPagination) {
        currentSearch = url;
        if (resetPagination) {
            page = 1;
            pageSize = 10;
        }
         $.post(url, {"pageNum": page.toString(), "pageSize": pageSize.toString()}, function(data) {
            $.each(data, function (index, question) {
                self.questions.push(new Question(
                    question.id,
                    question.title,
                    question.createdAt,
                    stripHtmlSpaces(question.description),
                    question.user.username,
                    question.likes,
                    question.dislikes,
                    question.flags));
            });
            page +=1;
         },"json");
    }

    this.loadLatestQuestions = function() {
        loadQuestions("./question/search/latest", true);
    }
    this.loadQuestionsByTag = function(tagValue) {
        loadQuestions("./question/search/tag/" + tagValue, true);
    }
    this.loadMoreQuestion = function() {
        loadQuestions(currentSearch, false);
    }
}

var questions = new QuestionsViewModel();
ko.applyBindings(questions);
questions.loadLatestQuestions();

function stripHtmlSpaces(html) {
    var space = /&nbsp;/g;
    var text2 = html.replace(space,'');
    return text2;
}