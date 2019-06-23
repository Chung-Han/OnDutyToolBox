package idv.autumn.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DataServlet")
public class DataServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1307807837442895696L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		String driverUrl = "oracle.jdbc.OracleDriver";
		String connString = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "HR";
		String password = "HR";
		String sql = "select * from employees t";
		*/
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		String driverUrl = request.getParameter("driverUrl");
		String connString = request.getParameter("connString");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sql = request.getParameter("sql");

		ArrayList<DataInfo> list = DataSets.getDataInfo(driverUrl, connString, username, password, sql);
		String json = DataSets.dataJson(list);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.close();
	}
}