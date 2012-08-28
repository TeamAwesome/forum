function Question(title, description){
    var MAX_TITLE_LENGTH = 100;
    var MAX_DESCRIPTION_LENGTH = 500;
    this.title = title;
    this.description = stripHTML(description);
    this.messages = {'title':null,'description':null};

    var that = this;

    var validateTitle = function() {
        if (that.title == ""){
            that.messages['title'] = 'Title is empty.';
            return false;
        }

        return true;
    }

    var validateDescription = function() {
        if (that.description == ""){
            that.messages['description'] = 'Description is empty.';
            return false;
        } else if (that.description.length > MAX_DESCRIPTION_LENGTH) {
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

        var lengthOfDescription = this.description.length;
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

Question.constructor.prototype.MAX_TITLE_LENGTH = 100;
Question.constructor.prototype.MAX_DESCRIPTION_LENGTH = 500;
