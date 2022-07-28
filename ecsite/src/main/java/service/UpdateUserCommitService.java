package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.UsersDAO;
import database.ConnectionManager;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import value.UsersValue;

public class UpdateUserCommitService {
	public static String execute(HttpServletRequest request) {
		String nextPage = "/WEB-INF/jsp/update_user_commit.jsp";
		HttpSession session = request.getSession(true);
		session.removeAttribute("errorMessage");
		
		String inputUserId = (String)request.getParameter("userId");
		String inputPassword = (String)request.getParameter("password");
		String inputName = (String)request.getParameter("name");
		String inputAddress = (String)request.getParameter("address");
		
		ConnectionManager cm = new ConnectionManager();
		try(Connection con = cm.getConnection()){
			if(con != null) {
				UsersDAO ud = new UsersDAO(con);
				
				ud.updateUsers(inputUserId, inputPassword, inputName, inputAddress);
				
				request.setAttribute("userId", inputUserId);
				request.setAttribute("password", inputPassword);
				request.setAttribute("name", inputName);
				request.setAttribute("address", inputAddress);
			} else {
				session.setAttribute("errorMessage", "データベースに接続できません。");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", "データベースに接続できません。");
		} catch (SQLException e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", "データベースに接続できません。");
		}
		
		return nextPage;
	}
}
