package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Express;
import dao.ExpressDao;

/**
 * Servlet implementation class ExpressServlet
 */
public class ExpressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ExpressDao dao=new ExpressDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpressServlet() {
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
		
		//显示数据
		if("ExpressListAct".equals(method)){
			try {
				ExpressList(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		//删除user操作
		if("DelExpressAct".equals(method)){
			int id=Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			boolean b=dao.deleteExpress(id);
			System.out.println(id);
			if(b==true) {
				try {
					ExpressList(request,response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("success.jsp");
			}
			return;
		}
		
	
		//根据id查询
		if("QueryByIdAct".equals(method)){
			int id=Integer.parseInt(request.getParameter("id"));
			System.out.println(id+"ad");
			Express express=dao.queryById(id);
			request.setAttribute("list", express);
			request.getRequestDispatcher("updateExpress.jsp").forward(request, response);
			return;
		}
		
		if("findByEnoAct".equals(method)){
			String eno=request.getParameter("eno");
			System.out.println(eno);
			List<Express> list=dao.findByEno(eno);
			request.setAttribute("list", list);
			request.getRequestDispatcher("listExpress.jsp").forward(request, response);
			return;
		}
		
		//根据id更改
		if("UpdateExpressAct".equals(method)){
			int id=Integer.parseInt(request.getParameter("id"));
			
		
			String eno=request.getParameter("eno");
			String carno=request.getParameter("carno");
			String goods=request.getParameter("goods");
			double price=Double.parseDouble(request.getParameter("price"));
			String isStartLocation=request.getParameter("isStartLocation");
			String isEndLocation=request.getParameter("isEndLocation");
			String expresser=request.getParameter("expresser");
			Date createTime=Date.valueOf(request.getParameter("createTime"));
			
			
			Express record=new Express();
			record.setEno(eno);
			record.setCarno(carno);
			record.setGoods(goods);
			record.setPrice(price);
			record.setIsStartLocation(isStartLocation);
			record.setIsEndLocation(isEndLocation);
			record.setCreateTime(createTime);
			
			record.setExpresser(expresser);
		
				
			
			boolean b=dao.update(record,id);
			if(b==true){
				request.setAttribute("message", "<script> alert('更改成功!')</script>");
				try {
					ExpressList(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				response.sendRedirect("updateExpress.jsp");
			}
			return;
		}
		
		if("AddExpressAct".equals(method)){
			
			
			String eno=request.getParameter("eno");
			String carno=request.getParameter("carno");
			String goods=request.getParameter("goods");
			double price=Double.parseDouble(request.getParameter("price"));
			String isStartLocation=request.getParameter("isStartLocation");
			String isEndLocation=request.getParameter("isEndLocation");
			String expresser=request.getParameter("expresser");
			Date createTime=Date.valueOf(request.getParameter("createTime"));
			
			
			Express record=new Express();
			record.setEno(eno);
			record.setCarno(carno);
			record.setGoods(goods);
			record.setPrice(price);
			record.setIsStartLocation(isStartLocation);
			record.setIsEndLocation(isEndLocation);
			record.setCreateTime(createTime);
			
			record.setExpresser(expresser);
		
				
			
			boolean b=dao.insert(record);
			if(b==true){
				request.setAttribute("message", "<script> alert('插入成功!')</script>");
				try {
					ExpressList(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				response.sendRedirect("updateExpress.jsp");
			}
			return;
		}
	}

	private void ExpressList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int pageNo = 1;	
		List<Express> lists=new ArrayList<Express>();
		String pageno=request.getParameter("pageNos");
		System.out.println(pageno);
		if(pageno != null){
		pageNo=Integer.parseInt(pageno);
		}else {
			pageNo=1;
		}
		lists=dao.ListExpress(pageNo);
		int recordCount=dao.getPage();
		
		
		//统计记录数
		ExpressDao dao2=new ExpressDao();
		int count=dao2.getCount();
		
		request.setAttribute("count", count);
		
		request.setAttribute("recordCount", recordCount);
		request.setAttribute("list", lists);
		request.setAttribute("pageNos", pageNo);
        request.getRequestDispatcher("expresslist.jsp").forward(request,response);
		
		
	}

}
