package servlet;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UpdateUserService;
import value.UsersValue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import dao.UsersDAO;
import database.ConnectionManager;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String nextPage = UpdateUserService.execute(request);
			
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String nextPage = UpdateUserService.execute(request);
		
		if (checkParameters(request)) {
			nextPage = "/UpdateUserConfirmServlet";
		} else {
			HttpSession session = request.getSession(true);
			session.setAttribute("errorMessage", "入力値が正しくありません");
		}
			
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

	private boolean checkParameters(HttpServletRequest request) {
		if(checkNullOrEmpth(request.getParameter("password1"))) {
			return false;
		}
		if(checkNullOrEmpth(request.getParameter("password2"))) {
			return false;
		}
		if(checkNullOrEmpth(request.getParameter("name"))) {
			return false;
		}
		if(checkNullOrEmpth(request.getParameter("address"))) {
			return false;
		}
		if(request.getParameter("password1").equals(request.getParameter("password2")) == false) {
			return false;
		}
		return true;
	}
	
	private boolean checkNullOrEmpth(String value) {
		return value == null || value.equals("");
	}
}
