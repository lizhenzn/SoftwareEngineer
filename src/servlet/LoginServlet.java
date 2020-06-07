package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import net.sf.json.JSONObject;
import util.JDBCUtil;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.setHeader("200", {"Content-Type":'text/plain','charset':'utf-8','Access-Control-Allow-Origin':'*','Access-Control-Allow-Methods':'PUT,POST,GET,DELETE,OPTIONS'});
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Origin","*");
		response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");
		System.out.print("ÇëÇó£º"+request.getQueryString());
		String userID=request.getParameter("usercode");
		String password=request.getParameter("userpwd");
		System.out.println(userID+password);
		String sql="select *from User where id=? and password=?";
		response.setCharacterEncoding("UTF-8");
		Connection conn=JDBCUtil.getLocalConnection();
		try {
			if (conn != null) {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, userID);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				JSONObject result = new JSONObject();
				if (rs.next()) {
					System.out.println("µÇÂ½³É¹¦");
					String username = rs.getString("name");
					result.put("name", username);
					result.put("isTrue", 1);
					System.out.println(result);
					response.getWriter().print(result);
				} else {
					System.out.println("µÇÂ½Ê§°Ü");
					result.put("isTrue", 0);
					response.getWriter().print(result);
					System.out.println(result);
				}
			} else {
				JSONObject result = new JSONObject();
				result.put("isTrue", 0);
				response.getWriter().print(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JSONObject result = new JSONObject();
			result.put("isTrue", 0);
			response.getWriter().print(result);
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
