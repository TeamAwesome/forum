function PlotGraphs (){
	var numberOfQuestions1;
	var numberOfQuestions2;
	var numberOfQuestions3;
	var count = 1;
	
	this.setQuestionsGraphFor3Months =
	function (numQuestionsMon1, numQuestionsMon2, numQuestionsMon3, lenTime){
		numberOfQuestions1 = numQuestionsMon1;
		numberOfQuestions2 = numQuestionsMon2;
		numberOfQuestions3 = numQuestionsMon3;

		if (lenTime == '3'){
		    lengthOfTime = '4';
		}
        if (lenTime == '6'){
            lengthOfTime = '8';
        }
        if (lenTime == '9'){
            lengthOfTime = '12';
        }
        if (lenTime == '12'){
            lengthOfTime = '12';
        }
	};

	this.plot = function(){
        $("#chartdiv").jqplot('chartdiv',[[[1, numberOfQuestions1],[2, numberOfQuestions2],[3, numberOfQuestions3]]],
            {
                title: 'Number of Questions',
                axesDefaults: {
                    tickRenderer: $.jqplot.CanvasAxisTickRenderer ,
                    tickOptions:
                    {
                        angle: -60,
                        fontSize: '10pt'
                    }
                },
                axes: {
                    xaxis: {
                        renderer: $.jqplot.CategoryAxisRenderer,
                        min:'0',
                        max:lengthOfTime
                    },
                    yaxis: {
                        renderer: $.jqplot.CategoryAxisRenderer,
                        min:'0',
                        max:'60'
                    }
                }
            }
        );

        $("#chartdiv2").jqplot('chartdiv2', [[[80, 10],[50, 5],[70, 10]]],
            {
                title: 'Number of Answers',axesDefaults: {
                    tickRenderer: $.jqplot.CanvasAxisTickRenderer,
                    tickOptions:
                    {
                        angle: -60,
                        fontSize: '10pt'
                    }
                },
                axes: {
                    xaxis:
                    {
                        renderer: $.jqplot.CategoryAxisRenderer,
                        min:'0',
                        max:'100'
                    },
                    yaxis:
                    {
                        renderer: $.jqplot.CategoryAxisRenderer,
                        min:'0',
                        max:'12'
                    }
                }
            }
        );
    };
}