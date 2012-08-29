function Question(title, description){
    var MAX_TITLE_LENGTH = 100;
    var MAX_DESCRIPTION_LENGTH = 500;
    this.title = stripSpaces(title);
    var scriptlessTitle = stripHTML(this.title);
    this.description = stripHTML(description);
    //alert(this.description);
    this.description = stripSpaces(this.description);
    this.messages = {'title':null,'description':null};

    var that = this;

    var validateTitle = function() {
        if (that.title == ""){
            that.messages['title'] = 'Title is empty.';
            return false;
        }
//        else if(that.title != that.scriptlessTitle){
//            that.messages['title'] = 'Title Cannot Have Scripts or HTML elements.'
//            return false;
//        }

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
    var div = document.createElement("div");
    div.innerHTML = text;
    return div.textContent || div.innerText;
}

function stripSpaces(html) {
    var stripspace = /^\s+|\s+$/g;
    var text = html.replace(stripspace, '');
    return text;
}


Question.constructor.prototype.MAX_TITLE_LENGTH = 100;
Question.constructor.prototype.MAX_DESCRIPTION_LENGTH = 500;
