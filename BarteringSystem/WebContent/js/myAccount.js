/**
 * 
 */

$(document).ready(function(){
	
	

})	


function showMyBarterPosts(){
	
	
	 $.ajax({
	   		type 	 : "POST",
	   		url 	 : "/barter/ajax/myBarterPostsAjax.jsp",
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

function showMyTradeHistory(){
	
	
	$.ajax({
   		type 	 : "POST",
   		url 	 : "/barter/ajax/showTradeHistory.jsp",
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

function showBarterRequest(){
	
	$.ajax({
   		type 	 : "POST",
   		url 	 : "/barter/ajax/showCurrentBarterRequest.jsp",
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

function editMyPofile(){
	
	$.ajax({
   		type 	 : "POST",
   		url 	 : "/barter/ajax/editProfileAjax.jsp",
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