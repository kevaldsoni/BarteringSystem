/**
 * 
 */

$(document).ready(function(){
	
	fetchBarteringPosts("All");
});


function fetchBarteringPosts(categoryValue){
	var dataString="category="+categoryValue;
	
$.ajax({
    		type 	 : "POST",
    		url 	 : "/barter/ajax/barterPostsAjax.jsp",
    		data	 : dataString,
    		cache 	 : false,
    		async    : false,
    		complete : function(html){
    			var response = html.responseText;
    			response = response.replace(/^\s+|\s+$/g,'');
    			if(response!=null && response != ''){
    				document.getElementById("barter_post_results").innerHTML = response;
    
	    		}		
    		}
		});

}

function setSelectedBarterPost(barterPostId){
	alert(barterPostId);
	//jQuery("#tree ul li").removeClass("selected");
    //jQuery(el).closest('li').addClass("selected");
	
}