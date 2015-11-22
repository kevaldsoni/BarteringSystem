<%
	
	String name	= (String)request.getParameter("name");
	String phone	= (String)request.getParameter("phone");
	String email	= (String)request.getParameter("email");
	String message	= (String)request.getParameter("message");
	String flag;
	if(true){
		//request.setAttribute("result", "true");
		flag="keval";
	}else{
		//request.setAttribute("result", "false");
	}
	
	out.print(flag);
%>
