    var YUIHandler = function() {
        //Setup some private variables
        var Dom = YAHOO.util.Dom,
        Event = YAHOO.util.Event;

        //The SimpleEditor config
        var myConfig = {
            height: '300px',
            width: '600px',
            dompath: true,
            focusAtStart: false
        };

        //Now let's load the SimpleEditor..
        var myEditor = new YAHOO.widget.SimpleEditor('editor', myConfig);
        return myEditor;
    };

    var myEditor = YUIHandler();
    myEditor.render();

    var track = function(){
        var stripHTML = /<\S[^><]*>/g;
        var maxLimit = 500;

        //Get the HTML from the Editor, assuming myEditor is your Editor reference
        var html = myEditor.saveHTML();

        //Remove the HTML tags from the returned string
        var text = html.replace(stripHTML, '');

        //alert(text);
        var remainingChars = (maxLimit-text.length);
        if(remainingChars < 500){
            $("#descriptionNumberRemainingMessage").text(remainingChars+" Characters Remaining");
        }else{
            $("#descriptionValidationMessage").text("");
        }

        return text;
    }

    myEditor.subscribe('editorKeyPress',track);
    myEditor.subscribe('editorKeyUp',track);
    myEditor.subscribe('editorKeyDown',track);

    $('#questionTitle').keyup(function() {
        var title = $("#questionTitle").val();
        var validator = new Validation();
        var titleNumberRemainingMessage = validator.checkNumberOfRemainingCharactersInTheTitle($("#questionTitle").val());
        $("#titleNumberRemainingMessage").text(titleNumberRemainingMessage);

        if(validator.checkTitle(title)){
            $("#titleValidationMessage").text("");
        }
    });

    $('#submitButton').click(function(){
        var validator = new Validation();
        var title = $("#questionTitle").val();
        var description = track();

        if(validator.checkTitle(title) && validator.checkDescription(description)){
            $("#questionForm").submit();
        } else if(!validator.checkTitle(title) && !validator.checkDescription(description)){
            $("#titleValidationMessage").text("* A Question must have a title.");
            $("#descriptionValidationMessage").text("* A Question must have a description.");
        } else if(!validator.checkTitle(title)){
            $("#titleValidationMessage").text("* A Question must have a title.");
        } else {
            $("#descriptionValidationMessage").text("* A Question must have a description.");
        }
    });
