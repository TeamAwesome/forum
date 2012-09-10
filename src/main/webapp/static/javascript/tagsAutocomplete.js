 $(document).ready(function() {

		function split( val ) {
			return val.split( /,\s*/ );
		}

		function extractLast( term ) {
			return split( term ).pop();
		}

		$("#questionTags")
			// don't navigate away from the field on tab when selecting an item
			.bind( "keydown", function( event ) {
				if ( event.keyCode === $.ui.keyCode.TAB &&
						$( this ).data( "autocomplete" ).menu.active ) {
					event.preventDefault();
				}
			})
			.autocomplete({
				minLength: 2,
				source: function( request, response ) {
					// delegate back to autocomplete, but extract the last  term
					$.getJSON("https://localhost:8443/forum/postQuestion/getTagsByTerm/"+extractLast($('#questionTags').val()), {}, response);
                        },
				focus: function() {
					// prevent value inserted on focus
					return false;
				},
				select: function( event, ui ) {
					var terms = split( this.value );
					// remove the current input
					terms.pop();
					// add the selected item
					terms.push( ui.item.value );
					// add placeholder to get the comma-and-space at the end
					terms.push( "" );
					this.value = terms.join( ", " );
					return false;
				}
			});
	});


















//
//	 $(document).ready(function() {
//    //		var availableTags = [
//    //			"Bangalore",
//    //			"Food",
//    //			"People",
//    //			"Movies",
//    //			"Hindi",
//    //			"Places",
//    //			"Accommodation",
//    //			"Rickshaw",
//    //			"Rupees",
//    //			"Masala",
//    //			"Spicy Ice cream",
//    //			"Shopping",
//    //			"Hotel",
//    //			"Mall",
//    //			"Clubbing",
//    //			"Travel",
//    //			"Metro",
//    //			"Koramangala",
//    //			"Cricket",
//    //			"Hockey",
//    //			"Taxi",
//    //			"Airport"
//    //		];
//            var availableTags;
//    		function split( val ) {
//    			return val.split( /,\s*/ );
//    		}
//
//    		function extractLast( term ) {
//    			return split( term ).pop();
//    		}
//    var success = function(){
//                            $.ajax({
//                              type: 'GET',
//                              url: 'http://localhost:8080/forum/static/testJson',
//                              success: function(data){this.availableTags=data;},
//                              dataType: 'text'
//                            });
//                            return this.availableTags;
//    }
//    		$("#questionTags")
//    			// don't navigate away from the field on tab when selecting an item
//    			.bind( "keydown", function( event ) {
//    				if ( event.keyCode === $.ui.keyCode.TAB &&
//    						$( this ).data( "autocomplete" ).menu.active ) {
//    					event.preventDefault();
//    				}
//    			})
//    			.autocomplete({
//    				minLength: 2,
//    				source: success,
//    				focus: function() {
//    					// prevent value inserted on focus
//    					return false;
//    				},
//    				select: function( event, ui ) {
//    					var terms = split( this.value );
//    					// remove the current input
//    					terms.pop();
//    					// add the selected item
//    					terms.push( ui.item.value );
//    					// add placeholder to get the comma-and-space at the end
//    					terms.push( "" );
//    					this.value = terms.join( ", " );
//    					return false;
//    				}
//    			});
//    	});
//
//    //$(function() {
//    //		function log( message ) {
//    //			$( "<div/>" ).text( message ).prependTo( "#log" );
//    //			$( "#log" ).scrollTop( 0 );
//    //		}
//    //
//    //		$( "#questionTags" ).autocomplete({
//    //			source: availableTags,
//    //			minLength: 2,
//    //			select: function( event, ui ) {
//    //				log( ui.item ?
//    //					"Selected: " + ui.item.value + " aka " + ui.item.id :
//    //					"Nothing selected, input was " + this.value );
//    //			}
//    //		});
//    //	});
//    //	});
//
//
////
//    function( request, response ) {
//    				$.ajax({
//    					url: "http://localhost:8080/forum/static/testJson",
//    					success: function( data ) {
//    						response( $.map( data.geonames, function( item ) {
//    							return data;
//    						}));
//    					}
//    				});
//    			}