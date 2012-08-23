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
    $("#descriptionValidationMessage").text(remainingChars+" Characters Remaining");
    return text;
    }
myEditor.subscribe('editorKeyPress',track);
myEditor.subscribe('editorKeyUp',track);
myEditor.subscribe('editorKeyDown',track);

$('#questionTitle').keyup(function() {
            var validator = new Validation();
            var titleValidationMessage = validator.checkIfTitleIsEmpty($("#questionTitle").val());
            var titleValidationMessage = validator.checkNumberOfRemainingCharactersInTheTitle($("#questionTitle").val());
            $("#titleValidationMessage").text(titleValidationMessage);
        });

$('#submitButton').click(function(){
            var validator = new Validation();
            var title = $("#questionTitle").val();
            //alert("submit");
            var description = track();

            if(validator.checkTitleAndDescription(title, description)){
                  $("#questionForm").submit();
            } else{
                  $("#validationMessage").text("Title or description is empty or too more characters.");
                 }
            });
$("#titleValidationMessage").text("100 Characters Remaining");
$("#descriptionValidationMessage").text("500 Characters Remaining");
