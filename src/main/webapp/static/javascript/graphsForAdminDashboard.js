function PlotGraphs (){
    this.lengthOfTime;
    this.numberOfQuestions = new Array();
    this.maximumNumberOfQuestions = 30;

	this.setQuestionsGraphFor90Days = function(numberOfQuestionsJson){
	    this.lengthOfTime = numberOfQuestionsJson.length;
        for(i=0;i<this.lengthOfTime-1;i++){
            this.numberOfQuestions.push(numberOfQuestionsJson[i]);
            if(this.maximumNumberOfQuestions < numberOfQuestionsJson[i])
            this.maximumNumberOfQuestions = numberOfQuestionsJson[i];
        }
	};


	this.plot = function(){
        $("#chartdiv").jqplot('chartdiv',[this.numberOfQuestions],
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
                        min:this.lengthOfTime,
                        max:'0'
                    },
                    yaxis: {
                        renderer: $.jqplot.CategoryAxisRenderer,
                        min:'0',
                        max:(this.maximumNumberOfQuestions+10).toString()
                    }
                }
            }
        );
    };
}