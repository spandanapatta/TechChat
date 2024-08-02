import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.sql.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
public class LoginServlet extends HttpServlet{
public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
res.setContentType("text/html");
PrintWriter out = res.getWriter();
String uname = req.getParameter("username");
String upassword = req.getParameter("password");
try{
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usersdb?useSSL=false&allowPublicKeyRetrieval=true","root","spandana123");
Statement stm = con.createStatement();
ResultSet rs = stm.executeQuery("select * from svecw_table where username='"+uname+"'and password='"+upassword+"'");
if(rs.next()){
res.sendRedirect("index.html");
}
else{
out.print("<center><h1>Username or password are wrong...</h1></center>");
}
con.close();
}catch(Exception e){
System.out.println(e.getMessage());
}
}
}