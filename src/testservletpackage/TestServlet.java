package testservletpackage;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import org.apache.log4j.Logger;

import test.TestBean;
import test.TestUtility;

import javax.servlet.annotation.WebServlet;
/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger log=Logger.getLogger(TestServlet.class.getName());
	
	private TestUtility testUtility = new TestUtility();

    public TestUtility getTestUtility() {
		return testUtility;
	}


	public void setTestUtility(TestUtility testUtility) {
		this.testUtility = testUtility;
	}


	/**
     * Default constructor. 
     */
    public TestServlet() {
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
		log.info("Entering TestServlet : Method doPost");
		TestBean tBean = new TestBean();
	
		String name=request.getParameter("name");
		name="abc";
		String phone=request.getParameter("phone");
		phone="000000000";
		String email=request.getParameter("email");
		String message=request.getParameter("password");
	
		log.info("Name ::"+name+ " Phone ::"+phone+" Email ::"+email+" message :: "+message);
		
		tBean.setPhone(phone);
		tBean.setName(name);
		tBean.setEmail(email);
		tBean.setMessage(message);
		//getTestUtility().storeUserDetails(tBean);
		request.setAttribute("message","Account Created Successfully");
		request.setAttribute("userBean",tBean);
		
		RequestDispatcher view = request.getRequestDispatcher("/pages/login/login.jsp");
        view.forward(request, response);
	}

}
