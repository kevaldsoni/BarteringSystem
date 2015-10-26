package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import test.TestBean;
import testservletpackage.TestServlet;
import user.UserUtility;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	private static Logger log=Logger.getLogger(TestServlet.class.getName());
	
	UserUtility util = new UserUtility();
       
    public UserUtility getUtil() {
		return util;
	}

	public void setUtil(UserUtility util) {
		this.util = util;
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		log.info("Entering LoginServlet : Method doPost");
		String returnUrl =null;
		String email=request.getParameter("email");
		String password=request.getParameter("password");

		log.info("Email ::"+email+ " Password ::"+password);
		
		boolean userAuthenticated = getUtil().validateUser(email, password);
		if(userAuthenticated){
			HttpSession session = request.getSession();
            session.setAttribute("user", email);
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30*60);
			returnUrl="/pages/login/login.jsp";
		}else{
			returnUrl="/pages/login/login.jsp";
			request.setAttribute("message","Account Created Successfully");
		}
		RequestDispatcher view = request.getRequestDispatcher(returnUrl);
        view.forward(request, response);
		
	}

}
