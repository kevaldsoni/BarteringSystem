<%@page import="user.BarterPostUtility" %>
<%@page import="user.UserUtility" %>
<%@page import="user.TradeUtility" %>
<%@page import="beans.TradePojo" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Date" %>
<%@page import="java.text.DateFormat" %>
<%@page import="java.text.SimpleDateFormat" %>
<%
	BarterPostUtility utilObj = new BarterPostUtility();
	UserUtility userObj = new  UserUtility();
	TradeUtility  tradeObj = new TradeUtility();
	String sessionEmail = null;
	
	List<TradePojo> myTradeHistory = null;
	if(request.getSession().getAttribute("email")!=null){
		sessionEmail=(String)session.getAttribute("email");
		myTradeHistory = tradeObj.fetchTradeHistory(sessionEmail);
	
	}else{
		System.out.print("User not logged in");
	}
	
	
	
	%>
<div class="table-responsive"> 
  <h4>My Trade History</h4>         
  <table class="table">
    <thead>
      <tr>
        <th>Trade #</th>
        <th>Request Status</th>
        <th>Status Time</th>
        <th>Co Trader Name</th>
        <th>Co Trader Rating</th>
      </tr>
    </thead>
    <tbody>
      <%
      
      for (TradePojo trade : myTradeHistory){
      
      %>
      
      <tr>
        <td><%=trade.getTradeId() %></td>
        <td><%=trade.getRequestStatus()%></td>
        <%
        
       DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
 	   //get current date time with Date()
 	   Date date = trade.getTradeStatusTime();
 	   String time = dateFormat.format(date);
 	 
        %>
        <td><%=time %></td>
        
        <%
        
        int secUserId = utilObj.fetchUserIdFromReqId(trade.getSecReqId());
        String name =  userObj.fetchNamefromUserId(secUserId);
        %>
        <td><%=name %></td>
        <td>
        <% if("Barter-Finalised".equalsIgnoreCase(trade.getRequestStatus())){ %>	
       		<select class="form-control input-small" name="rateUser">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select>
            <a id="rateUser" class="btn btn-info" onclick="rateUser(<%=trade.getTradeId()%>);" href="javascript:void(0);"><i class="icon-hand-right"></i>Rate User</a>
       <%
       }else{
    	   %>
    	   <div class="ratings">
    	    <%
        		for (int i=1;i<=trade.getSecUserRating();i++){ 
        	%>
              <span class="glyphicon glyphicon-star"></span>
         	<% } %>
         </div>
        </td>
        
        <%
        
        }
        
        %>
      </tr>
       <%
        
        }
        
        %>
      
    </tbody>
  </table>
  </div>