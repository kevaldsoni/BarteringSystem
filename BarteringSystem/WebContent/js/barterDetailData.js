/**
 * 
 */

$(document).ready(function(){
	
	fetchBarteringPosts("All");
	
	$("#sendBarterRequest").click(function(){
		
		$("#sendBarterRequest").html('Processing Request');
		$('#sendBarterRequest').attr('disabled',true);
		$('#barterRequestModal').modal('hide');
	  var secReqId = $('#secReqId').html();
       
      var primReqId = $('#barterOfferPostId').val();
       
      var dataString = "primReqId="+primReqId+"&secReqId="+secReqId;
      
      
       $.ajax({
   		type 	 : "POST",
   		url 	 : "/barter/ajax/tradeDetail.jsp",
   		data	 : dataString,
   		cache 	 : false,
   		async    : false,
   		complete : function(html){
   			var response = html.responseText;
   			response = response.replace(/^\s+|\s+$/g,'');
   			if(response!=null && response != ''){
   				//document.getElementById("barter_post_results").innerHTML = response;
   				
   				
   					
	    		}
   			$("#sendBarterRequest").html('Send Request');
   			$('#sendBarterRequest').attr('disabled',false);
   			
   			$('#barterConfirmationModal').modal();
   		}
		});
       return false;
    });
	
	
	
	
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
	
	$("#barterRequestModal").modal();
	
	$('#secReqId').html(barterPostId);
	//jQuery("#tree ul li").removeClass("selected");
    //jQuery(el).closest('li').addClass("selected");
	
}