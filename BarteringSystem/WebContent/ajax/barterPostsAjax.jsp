<%@page import="user.BarterPostUtility" %>
<%@page import="beans.BarterPostPojo" %>
<%@page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	BarterPostUtility utilObj = new BarterPostUtility();
	String categoryValue = (String)request.getParameter("category");
	System.out.print("Category Obtained ::"+categoryValue);
	List<BarterPostPojo> barterPosts = utilObj.fetchBarteringPosts(categoryValue);
	for (BarterPostPojo obj : barterPosts){
		String imgName=null;
		if(obj.getItemImage()!=null)
			imgName = "/barter/uploadeddata/"+obj.getItemImage();
		else
			imgName = "/barter/uploadeddata/noimage.jpg";
	
	
	%>
	<div>

	  <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <div style="width:250px;height: 120px;">
                            <img src="<%=imgName%>">
                            </div>
                            <div class="caption">
                                <h4 style="color:#337ab7"><%=obj.getTitle()%></h4>
                                <p><%=obj.getItemOfferedDesc()%></p>
                            </div>
                            <div class="caption">
                            <strong>Looking For</strong> 
                            <p><%=obj.getExpectedItemDesc() %>
                            </div>
                            
                            <div class="ratings">
                                <p class="pull-right">User Rating</p>
                                <p>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                </p>
                                
                            </div>
                            <div class="col-sm-4 col-md-4 col-xs-4"><a class="btn btn-primary" onclick="setSelectedBarterPost('<%=obj.getReqId()%>');" href="javascript:void(0);">Barter Now!</a></div>
                        </div>
       </div>
               
               
       <%
	}
       %>
	
</div>