function Advice(description){
    var MAX_DESCRIPTION_LENGTH = 1000;

    this.description = stripHTML(description);
    this.description = stripHtmlSpaces(this.description);
    var scriptlessDescription = stripSpaces(this.description);

    that = this;
    this.messages = {'description':null};

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
        return validateDescription();
    }

    this.updateMessages = function() {

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


Advice.constructor.prototype.MAX_DESCRIPTION_LENGTH = 1000;
