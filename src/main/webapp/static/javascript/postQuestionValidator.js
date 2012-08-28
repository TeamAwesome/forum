$(this).load(function(){
    $("#titleValidationMessage").text(Question.MAX_TITLE_LENGTH + " characters remaining");
    $("#descriptionValidationMessage").text(Question.MAX_DESCRIPTION_LENGTH + " characters remaining");
});

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

function update() {
    var question = new Question($("#questionTitle").val(), questionDescriptionEditor.saveHTML());
    question.updateMessages();
    $("#titleValidationMessage").text(question.messages['title']);
    $("#descriptionValidationMessage").text(question.messages['description']);
}

function validate() {
    var question = new Question($("#questionTitle").val(),questionDescriptionEditor.saveHTML());
    var isValid = question.isValid();
    $("#titleValidationMessage").text(question.messages['title']);
    $("#descriptionValidationMessage").text(question.messages['description']);

    return isValid;
}

questionDescriptionEditor.subscribe('editorKeyPress', update);
questionDescriptionEditor.subscribe('editorKeyUp',update);
questionDescriptionEditor.subscribe('editorKeyDown',update);

$('#questionTitle').keyup(update);
$('#questionTitle').keydown(update);
$('#questionTitle').keypress(update);

$('#questionForm').submit(validate);