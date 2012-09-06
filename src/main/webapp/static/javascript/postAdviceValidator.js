$(this).load(function(){
    $("#descriptionValidationMessage").text(Advice.MAX_DESCRIPTION_LENGTH + " characters remaining");
});

var createYUIEditor = function() {
    var descriptionEditorConfig = {
      height: '280px',
      width: '580px'
    };

    return new YAHOO.widget.Editor('descriptionEditor', descriptionEditorConfig);
 }

var adviceDescriptionEditor = createYUIEditor();
adviceDescriptionEditor.render();

function update() {
    var advice = new Advice(adviceDescriptionEditor.saveHTML());
    advice.updateMessages();
    $("#descriptionValidationMessage").text(advice.messages['description']);
}

function validate() {
    var advice = new Advice(adviceDescriptionEditor.saveHTML());
    var isValid = advice.isValid();
    $("#descriptionValidationMessage").text(advice.messages['description']);

    return isValid;
}

adviceDescriptionEditor.subscribe('editorKeyPress', update);
adviceDescriptionEditor.subscribe('editorKeyUp',update);
adviceDescriptionEditor.subscribe('editorKeyDown',update);

$('#adviceDescription').keydown(update);
$('#adviceDescription').keypress(update);

$('#adviceForm').submit(validate);