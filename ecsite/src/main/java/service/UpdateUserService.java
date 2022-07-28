package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.UsersDAO;
import database.ConnectionManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import value.UsersValue;

public class UpdateUserService {
	public static String execute(HttpServletRequest request) {
		String nextPage = "/WEB-INF/jsp/update_user.jsp";
		HttpSession session = request.getSession(true);
		session.removeAttribute("errorMessage");
		
		String inputUserId = "aaa@nttcom.co.jp";
		
		ConnectionManager cm = new ConnectionManager();
		try(Connection con = cm.getConnection()){
			if(con != null) {
				UsersDAO ud = new UsersDAO(con);
				UsersValue uv = new UsersValue();
				
				uv = ud.findUsers(inputUserId);
				
				request.setAttribute("userId", uv.getUserId());
				request.setAttribute("name", uv.getName());
				request.setAttribute("address", uv.getAddress());
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
