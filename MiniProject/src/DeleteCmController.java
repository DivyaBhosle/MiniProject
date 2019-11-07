import java.util.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.*;
@WebServlet("/DeleteCmController")
public class DeleteCmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteCmController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String statename=request.getParameter("statename");
		
		CM u=new CM();
		u.setState(statename);
		
		
		DeleteDao userDao=new DeleteDao();
		String result=userDao.deleteChief(u);
		
		if(result.equals(Results.SUCCESS))
		{
			
			System.out.println("Deleted CM");
			
	    }
	}
}
