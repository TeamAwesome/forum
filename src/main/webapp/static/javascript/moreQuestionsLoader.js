
function Question(id, title, createdAt, description, userName, likes, dislikes, flags) {
    this.id = id;
    this.title = title;
    this.createdAt = createdAt;
    this.description = description;
    this.userName = userName;
    this.likes = likes;
    this.dislikes = dislikes;
    this.flags = flags;
    this.url = "/forum/question/view/"+id;
}

function QuestionsViewModel() {
    var page = 1;
    var pageSize = 10;
    var currentSearch = "";

    this.questions = ko.observableArray();

    var self = this;
    var loadQuestions = function(url, resetPagination, identifier) {
        currentSearch = url;
        if (resetPagination) {
            page = 1;
            pageSize = 10;
        }
        if(identifier === "home")
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
         else{
         $.post(url,{"pageNum": page.toString(), "pageSize": pageSize.toString()}, function(data) {
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
    }

    this.loadLatestQuestions = function() {
        loadQuestions("/forum/question/search/latest", true,"home");
    }
    this.loadQuestionsByTag = function(tagValue) {
        loadQuestions("/forum/question/search/tag/" + tagValue, true,"tag");
    }
    this.loadMoreQuestion = function() {
        loadQuestions(currentSearch, false, "home");
    }
}

var questions = new QuestionsViewModel();
ko.applyBindings(questions);
if(window.location.pathname === "/forum/")
    questions.loadLatestQuestions();
else
{
    var pathNameOfSearch = window.location.pathname.split('/');
    questions.loadQuestionsByTag(pathNameOfSearch[pathNameOfSearch.length - 1]);
}
function stripHtmlSpaces(html) {
    var space = /&nbsp;/g;
    var text2 = html.replace(space,'');
    return text2;
}