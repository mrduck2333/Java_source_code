package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.ExpressDao;
import dao.UserDao;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao=new UserDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object attribute= request.getParameter("method");
		String method = "";
		if(attribute != null){
			method = attribute.toString();
		}
		if("LoginAct".equals(method)){
			 
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			   	UserDao dao = new UserDao();
			   	User user=dao.findUser(username);
			   	if(user==null){
			   		request.setAttribute("error", "<script> alert('用户不存在!')</script>");
			   		request.getRequestDispatcher("login.jsp").forward(request, response);
				}else if(!user.getPassword().equals(password)){
					request.setAttribute("error", "<script> alert('密码错误!')</script>");
			   		request.getRequestDispatcher("login.jsp").forward(request, response);
					
				}else {
					HttpSession session=request.getSession();
					
					session.setAttribute("username", user.getUsername());
					//request.getRequestDispatcher("").forward(request, response);
					response.sendRedirect("ExpressServlet?method=ExpressListAct");
				}
			   	return;
		}
		//显示数据
		if("UserListAct".equals(method)){
			try {
				UserList(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		//删除user操作
		if("DelUserAct".equals(method)){
			int id=Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			boolean b=dao.delete(id);
			System.out.println(id);
			if(b==true) {
				try {
					UserList(request,response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("success.jsp");
			}
			return;
		}
		
		if("LoginOutAct".equals(method)){
			request.getSession().invalidate();
			response.sendRedirect("index.jsp");	
			return;
		}
		
		//根据id查询
		if("FindByIdAct".equals(method)){
			int id=Integer.parseInt(request.getParameter("id"));
			System.out.println(id+"ad");
			User user=dao.FindById(id);
			request.setAttribute("list", user);
			request.getRequestDispatcher("updateUser.jsp").forward(request, response);
			return;
		}
		
		if("UpdateUserAct".equals(method)){
			int id=Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			String usename=request.getParameter("username");
			String password=request.getParameter("password");
			UserDao dao=new UserDao();
			User user=new User();
			user.setUsername(usename);
			user.setPassword(password);
			boolean b=dao.update(user, id);
			if(b==true){
				request.setAttribute("message", "<script> alert('更改成功!')</script>");
				try {
					UserList(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				response.sendRedirect("register.jsp");
			}
			return;
		}
	}

	private void UserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int pageNo = 1;	
		List<User> lists=new ArrayList<User>();
		String pageno=request.getParameter("pageNos");
		System.out.println(pageno);
		if(pageno != null){
		pageNo=Integer.parseInt(pageno);
		}else {
			pageNo=1;
		}
		lists=dao.listUser(pageNo);
		int recordCount=dao.getPage();
		request.setAttribute("recordCount", recordCount);
		request.setAttribute("list", lists);
		request.setAttribute("pageNos", pageNo);
        request.getRequestDispatcher("userlist.jsp").forward(request,response);
		
		
	}

}
