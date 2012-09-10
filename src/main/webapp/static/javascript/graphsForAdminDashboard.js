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
                title: 'Number of Questions v/s Days Ago',
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
                        label: "Days Ago",
                        labelRenderer: $.jqplot.CanvasAxisLabelRenderer,
                        min:this.lengthOfTime,
                        max:'0'
                    },
                    yaxis: {
                        label : "Number Of Questions Posted",
                        labelRenderer: $.jqplot.CanvasAxisLabelRenderer,
                        min:'0',
                        max:this.maximumNumberOfQuestions+10
                    }
                },
                highlighter: {
                 show: true,
                 sizeAdjust: 7.5
                },
                cursor: {
                  show: false
                }
            }
        );
    };
}