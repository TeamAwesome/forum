$(this).load(function(){
    $("#titleValidationMessage").text(Question.MAX_TITLE_LENGTH + " characters remaining");
    $("#descriptionValidationMessage").text(Question.MAX_DESCRIPTION_LENGTH + " characters remaining");
});

var createYUIEditor = function() {
    var descriptionEditorConfig = {
      height: '300px',
      width: '600px',
      toolbar: {
      draggable: false,
      buttonType: 'advanced',
      buttons: [
          { group: 'fontstyle', label: 'Font Name and Size',
              buttons: [
                  { type: 'select', label: 'Arial', value: 'fontname', disabled: true,
                      menu: [
                          { text: 'Arial', checked: true },
                          { text: 'Arial Black' },
                          { text: 'Comic Sans MS' },
                          { text: 'Courier New' },
                          { text: 'Lucida Console' },
                          { text: 'Tahoma' },
                          { text: 'Times New Roman' },
                          { text: 'Trebuchet MS' },
                          { text: 'Verdana' }
                      ]
                  },
                  { type: 'spin', label: '13', value: 'fontsize', range: [ 9, 75 ], disabled: true }
              ]
          },
          { type: 'separator' },
          { group: 'textstyle', label: 'Font Style',
              buttons: [
                  { type: 'push', label: 'Bold CTRL + SHIFT + B', value: 'bold' },
                  { type: 'push', label: 'Italic CTRL + SHIFT + I', value: 'italic' },
                  { type: 'push', label: 'Underline CTRL + SHIFT + U', value: 'underline' },
                  { type: 'separator' },
                  { type: 'push', label: 'Subscript', value: 'subscript', disabled: true },
                  { type: 'push', label: 'Superscript', value: 'superscript', disabled: true },
                  { type: 'separator' },
                  { type: 'color', label: 'Font Color', value: 'forecolor', disabled: true },
                  { type: 'color', label: 'Background Color', value: 'backcolor', disabled: true },
                  { type: 'separator' },
                  { type: 'push', label: 'Remove Formatting', value: 'removeformat', disabled: true },
                  { type: 'push', label: 'Show/Hide Hidden Elements', value: 'hiddenelements' }
              ]
          },
          { type: 'separator' },
          { group: 'alignment', label: 'Alignment',
              buttons: [
                  { type: 'push', label: 'Align Left CTRL + SHIFT + [', value: 'justifyleft' },
                  { type: 'push', label: 'Align Center CTRL + SHIFT + |', value: 'justifycenter' },
                  { type: 'push', label: 'Align Right CTRL + SHIFT + ]', value: 'justifyright' },
                  { type: 'push', label: 'Justify', value: 'justifyfull' }
              ]
          },
          { type: 'separator' },
          { group: 'parastyle', label: 'Paragraph Style',
              buttons: [
              { type: 'select', label: 'Normal', value: 'heading', disabled: true,
                  menu: [
                      { text: 'Normal', value: 'none', checked: true },
                      { text: 'Header 1', value: 'h1' },
                      { text: 'Header 2', value: 'h2' },
                      { text: 'Header 3', value: 'h3' },
                      { text: 'Header 4', value: 'h4' },
                      { text: 'Header 5', value: 'h5' },
                      { text: 'Header 6', value: 'h6' }
                  ]
              }
              ]
          },
          { type: 'separator' },
          { group: 'indentlist', label: 'Indenting and Lists',
              buttons: [
                  { type: 'push', label: 'Indent', value: 'indent', disabled: true },
                  { type: 'push', label: 'Outdent', value: 'outdent', disabled: true },
                  { type: 'push', label: 'Create an Unordered List', value: 'insertunorderedlist' },
                  { type: 'push', label: 'Create an Ordered List', value: 'insertorderedlist' }
              ]
          },
          { type: 'separator' },
          { group: 'insertitem', label: 'Insert Item',
              buttons: [
                  { type: 'push', label: 'HTML Link CTRL + SHIFT + L', value: 'createlink', disabled: true },
              ]
          }
      ],

     }
    };

    return new YAHOO.widget.Editor('descriptionEditor', descriptionEditorConfig);
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

//$('#questionTitle').keyup(update);
$('#questionTitle').keydown(update);
$('#questionTitle').keypress(update);

$('#questionForm').submit(validate);