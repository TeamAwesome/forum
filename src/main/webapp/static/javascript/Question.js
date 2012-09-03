function Question(title, description){
    var MAX_TITLE_LENGTH = 100;
    var MAX_DESCRIPTION_LENGTH = 500;

    this.title = stripSpaces(title);
    var spacelessTitle = stripSpaces(title);
    var scriptlessTitle = stripHTML(this.title);
    scriptlessTitle = stripHtmlSpaces(scriptlessTitle);

    this.description = stripHTML(description);
    this.description = stripHtmlSpaces(this.description);
    var scriptlessDescription = stripSpaces(this.description);


    this.messages = {'title':null,'description':null};

    var that = this;

    var validateTitle = function() {
        if(spacelessTitle != scriptlessTitle){
            that.messages['title'] = 'Title Cannot Have Scripts or HTML elements.'
            return false;
        }
       else if (spacelessTitle == ""){
            that.messages['title'] = 'Title is empty.';
            return false;
        }

        return true;
    }

    var validateDescription = function() {
        if (scriptlessDescription.length > MAX_DESCRIPTION_LENGTH) {
            that.messages['description'] = "Description should be less than "+MAX_DESCRIPTION_LENGTH+" characters.";
            return false;
        }
        else if (scriptlessDescription == ""){
            that.messages['description'] = 'Description is empty.';
            return false;
        }
        return true;
    }

    this.isValid = function(){
        this.updateMessages();
        return validateTitle() && validateDescription();
    }

    this.updateMessages = function() {
        var lengthOfTitle = this.title.length;
        if(lengthOfTitle <= MAX_TITLE_LENGTH){
            this.messages['title'] = (MAX_TITLE_LENGTH-lengthOfTitle) +" characters remaining."
        }

        var lengthOfDescription = scriptlessDescription.length;

        if(lengthOfDescription <= MAX_DESCRIPTION_LENGTH){
            this.messages['description'] = (MAX_DESCRIPTION_LENGTH-lengthOfDescription) +" characters remaining.";
        } else{
            this.messages['description'] = "Description should be less than "+MAX_DESCRIPTION_LENGTH+" characters.";
        }
    }
}

function stripHTML(html) {
     var stripHTML = /<\S[^><]*>/g;
     var text = html.replace(stripHTML, '');
     return text;
}

function stripSpaces(html) {
    var stripspace = /^\s+|\s+$/g;
    var text1 = html.replace(stripspace, '');
    return text1;
}

function stripHtmlSpaces(html) {
    var space = /&nbsp;/g;
    var text2 = html.replace(space,'');
    return text2;
}


Question.constructor.prototype.MAX_TITLE_LENGTH = 100;
Question.constructor.prototype.MAX_DESCRIPTION_LENGTH = 500;
