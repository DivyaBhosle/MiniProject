import com.lti.*;

import java.io.IOException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AddchiefDao")
public class AddchiefDao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddchiefDao() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//HttpSession session=request.getSession();
		int cid=Integer.parseInt(request.getParameter("cid"));
		String cname=request.getParameter("cname");
		String quali=request.getParameter("quali");
		String state=request.getParameter("state");
		String enddate=request.getParameter("enddate");
		String party=request.getParameter("party");
		
		CM u=new CM();
		u.setCid(cid);
		u.setCname(cname);
		u.setQuali(quali);
		u.setState(state);
		u.setEnddate(enddate);
		u.setParty(party);
		
		AddChiefController userDao=new AddChiefController();
		String result=userDao.addChief(u);
		
		if(result.equals(Results.SUCCESS))
		{
			System.out.println("Added successfully");
		}
	}

}
