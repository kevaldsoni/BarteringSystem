package servlets;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import beans.BarterPostPojo;
import testservletpackage.TestServlet;
import user.BarterPostUtility;
import user.UserUtility;

/**
 * Servlet implementation class NewBarterServlet
 */
@WebServlet("/NewBarterServlet")
@MultipartConfig
public class NewBarterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String DATA_DIRECTORY = "D:\\EclipseWorkspace\\BarteringSystem\\WebContent\\uploadeddata";
    private static final int MAX_MEMORY_SIZE = 1024 * 1024 * 2;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024;
    
    private static Logger log=Logger.getLogger(TestServlet.class.getName());
    
    private BarterPostUtility barterPostObj = new BarterPostUtility();
    private UserUtility userUtility = new UserUtility(); 
    
    
    public UserUtility getUserUtility() {
		return userUtility;
	}

	public void setUserUtility(UserUtility userUtility) {
		this.userUtility = userUtility;
	}

	public BarterPostUtility getBarterPostObj() {
		return barterPostObj;
	}

	public void setBarterPostObj(BarterPostUtility barterPostObj) {
		this.barterPostObj = barterPostObj;
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public NewBarterServlet() {
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
		
		log.info("In New Barter Servlet :: doPost Method");
		
		String title=request.getParameter("title");
		String offeringProductCategory=request.getParameter("offeringProductCategory");
		String myOffer=request.getParameter("myOffer");
		String expectedProductCategory=request.getParameter("expectedProductCategory");
		String askOffer=request.getParameter("askOffer");
		String contactDetail=request.getParameter("contactDetail");
		
		log.info("title :: "+title+" category offer ::"+offeringProductCategory+" myoffer :: "+myOffer+" expected cate ::"+expectedProductCategory+" askOffer :: "+askOffer+" contact :: "+contactDetail);
		BarterPostPojo barterPostPojo = new BarterPostPojo();
		
		barterPostPojo.setTitle(title);
		int offeringProductCategoryValue = Integer.parseInt(offeringProductCategory);
		barterPostPojo.setOfferingCatId(offeringProductCategoryValue);
		barterPostPojo.setItemOfferedDesc(myOffer);
		int expectedProductCategoryValue = Integer.parseInt(expectedProductCategory);
		barterPostPojo.setExpectedCatId(expectedProductCategoryValue);
		barterPostPojo.setExpectedItemDesc(askOffer);
		barterPostPojo.setTradeContact(contactDetail);
		
		String emailLoggedIn = (String)request.getSession().getAttribute("email");
		if(emailLoggedIn!=null && emailLoggedIn.length()>0){
			log.info("Email ::"+emailLoggedIn);
			int id = getUserUtility().fetchUserIdFromEmail(emailLoggedIn);
			barterPostPojo.setUserId(id);
		}	
		else
			log.info("email not found in session");
		//int userId = getUserUtility().fetchUserId(emailLoggedIn);
		
		
		
		
			
        //Code to upload Files
		// Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (!isMultipart) {
            return;
        }
        
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(MAX_MEMORY_SIZE);
        String uploadFolder =  DATA_DIRECTORY;
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(MAX_REQUEST_SIZE);

        try {
            // Parse the request
            /**List items = upload.parseRequest(request);
            log.info("No of files in list :: "+items.size());
            Iterator iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (!item.isFormField()) {
                    String fileName = new File(item.getName()).getName();
                    barterPostPojo.setItemImage(fileName);
                    String filePath = uploadFolder + File.separator + fileName;
                    File uploadedFile = new File(filePath);
                    System.out.println(filePath);
                    // saves the file to upload directory
                    item.write(uploadedFile);
                }
            }*/
            
        	if(ServletFileUpload.isMultipartContent(request)){
        		log.info("multipart request found");
        		List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
        		log.info("List of files :: "+multiparts.size());
        		for(FileItem item : multiparts){
        		     if(!item.isFormField()){
        		      String name = new File(item.getName()).getName();
        		      barterPostPojo.setItemImage(name);
        		      item.write( new File(DATA_DIRECTORY+ File.separator + name));
        		     }
        		}
        		     }else{
        			log.info("multipart request not found");
        		}

        	
        	
            int requestId = 0 ;
    		if(barterPostPojo!=null)
    			requestId = getBarterPostObj().addNewBarterPost(barterPostPojo);
    		
           
    		String returnUrl="/pages/newBarterForm.jsp";
			request.setAttribute("message","Barter Post updated successfully");
			RequestDispatcher view = request.getRequestDispatcher(returnUrl);
	        view.forward(request, response);
    		
            /**getServletContext().getRequestDispatcher("/barter/pages/newBarterForm.jsp").forward(
                    request, response);
             */
        } catch (FileUploadException ex) {
            throw new ServletException(ex);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
	}

}
