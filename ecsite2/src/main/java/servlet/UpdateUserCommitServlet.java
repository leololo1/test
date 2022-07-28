package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import value.UsersValue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import dao.UsersDAO;
import database.ConnectionManager;

/**
 * Servlet implementation class UpdateUserCommitServlet
 */
@WebServlet("/UpdateUserCommitServlet")
public class UpdateUserCommitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserCommitServlet() {
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
		String nextPage = "/WEB-INF/jsp/update_user.jsp";
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset = UTF-8");
		
		String inputUserId = (String)request.getParameter("userId");
		String inputPassword = (String)request.getParameter("password1");
		String inputName = (String)request.getParameter("name");
		String inputAddress = (String)request.getParameter("address");
		
		ConnectionManager cm = new ConnectionManager();
		try(Connection con = cm.getConnection()){
			UsersDAO ud = new UsersDAO(con);
			
			ud.updateUsers(inputUserId, inputPassword, inputName, inputAddress);
			
			request.setAttribute("userId", inputUserId);
			request.setAttribute("password", inputPassword);
			request.setAttribute("name", inputName);
			request.setAttribute("address", inputAddress);
			
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
