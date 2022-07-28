package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.UsersDAO;
import database.ConnectionManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import value.UsersValue;

public class UpdateUserConfirmService {
	public static String execute(HttpServletRequest request) {
		String nextPage = "/WEB-INF/jsp/update_user_confirm.jsp";
		HttpSession session = request.getSession(true);
		session.removeAttribute("errorMessage");
		
		String inputUserId = (String)request.getParameter("userId");
		String inputPassword = (String)request.getParameter("password1");
		String inputName = (String)request.getParameter("name");
		String inputAddress = (String)request.getParameter("address");
		
		request.setAttribute("userId", inputUserId);
		request.setAttribute("password", inputPassword);
		request.setAttribute("name", inputName);
		request.setAttribute("address", inputAddress);
		
		return nextPage;
	}
}
