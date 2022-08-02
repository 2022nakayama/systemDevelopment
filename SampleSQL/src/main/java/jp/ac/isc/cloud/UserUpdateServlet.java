package jp.ac.isc.cloud;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		Connection users = null;
		try {
		request.setCharacterEncoding("utf-8");//←これを忘れると入力データが文字化けする
		users = DBConnection.openConnection();
		String id = request.getParameter("updateld");
		String name = request.getParameter("updateName");
		String picture = request.getParameter("insertPicture");
		Statement state = users.createStatement();
		if(!name.equals("")){
			state.executeUpdate("UPDATE user_table SET name ='" + name + "' WHERE id ='" + id + "'");//←この部分は1行で入力する
		}
		if(!picture.equals("")){
			state.executeUpdate("UPDATE user_table SET name ='" + picture + "' WHERE id ='" + id + "'");
			
		}
		
		DBConnection.closeConnection(users, state);
		response.sendRedirect("/select"); // UserSelectServletを呼び出す
		} catch (SQLException e) {
		e.printStackTrace();
		}
		}
		}


