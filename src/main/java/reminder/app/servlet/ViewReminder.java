package reminder.app.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reminder.app.db.DatabaseConnection;

@WebServlet("/view")
public class ViewReminder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			 Connection con=DatabaseConnection.getConnectivity();
			 String query="select * from rem1";
			 Statement stmt=con.createStatement();
			 ResultSet rs=stmt.executeQuery(query);
			 String str ="";
			 
			while(rs.next()) {
				str =rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4);
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)); 
			}
			
			response.sendRedirect("index.jsp?test="+str);
		 }catch(Exception e) {
			 
		 }
	}
	
}