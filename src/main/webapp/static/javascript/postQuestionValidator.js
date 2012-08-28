$("#titleValidationMessage").text("100 Characters Remaining");
$("#descriptionValidationMessage").text("500 Characters Remaining");

var createYUIEditor = function() {
    var descriptionEditorConfig = {
      height: '300px',
      width: '600px',
      dompath: false,
      focusAtStart: false
    };

    return new YAHOO.widget.SimpleEditor('descriptionEditor', descriptionEditorConfig);
 }

questionDescriptionEditor = createYUIEditor();
questionDescriptionEditor.render();

function descriptionText() {
    var stripHTML = /<\S[^><]*>/g;
    var html = questionDescriptionEditor.saveHTML();
    var description = html.replace(stripHTML, '');

    return description;
}

function validateDescription() {
    var maxLimit = 500;
    var remainingChars = (maxLimit - descriptionText().length);
    if(remainingChars < 0) {
        $("#descriptionValidationMessage").text("Description should be less than 500 characters.");
        return false;
    } else {
        $("#descriptionValidationMessage").text(remainingChars+" characters Remaining");
        return true;
    }
}

questionDescriptionEditor.subscribe('editorKeyPress', validateDescription);
questionDescriptionEditor.subscribe('editorKeyUp',validateDescription);
questionDescriptionEditor.subscribe('editorKeyDown',validateDescription);

function validateTitle() {
    var validator = new Validation();
    var titleValidationMessage = validator.checkNumberOfRemainingCharactersInTheTitle($("#questionTitle").val());
    $("#titleValidationMessage").text(titleValidationMessage);
    return true;
}

$('#questionTitle').keyup(validateTitle);
$('#questionTitle').keydown(validateTitle);
$('#questionTitle').keypress(validateTitle);

function handleSubmit(e){
    return validateDescription() && validateTitle();
 }

$('#questionForm').submit(handleSubmit);