/*
dojo.addOnLoad(
	function(){
		dojo.query(".ajaxLink").forEach(function(element) {
	        Spring.addDecoration(new Spring.ElementDecoration({
	            elementId: element.id,
	            event: 'onclick',
				params: { fragments: 'content' }
	        }));
	    });
	}
);
*/
/*
dojo.addOnLoad(
	function(){
		dojo.query('.ajaxLink').forEach(function(node, index, arr){
			Spring.addDecoration(new Spring.AjaxEventDecoration({
				elementId: node,
				event: "onclick",
				params: { fragments: "content" }
			}));
		});
	}
);
*
/*
$(document).ready(function(){
	$(".ajaxLink").each(function(element) {
    	Spring.addDecoration(new Spring.AjaxEventDecoration({
			elementId: element.id,
			event: "onclick"
		}));
	});
});
*/