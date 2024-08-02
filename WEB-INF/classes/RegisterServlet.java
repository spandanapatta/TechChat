import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class RegisterServlet extends HttpServlet{
public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
res.setContentType("text/html");
PrintWriter out = res.getWriter();
String username = req.getParameter("username");
String password = req.getParameter("password");
String branch= req.getParameter("branch");
String regno= req.getParameter("regnumber");
String phn = req.getParameter("phone");
try{
Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/usersdb?useSSL=false&allowPublicKeyRetrieval=true","root","spandana123");
String q = "insert into svecw_table(username, password, branch, regno,phn) values(?,?,?,?,?)";
PreparedStatement stm = con.prepareStatement(q);
stm.setString(1, username);
stm.setString(2, password);
stm.setString(3, branch);
stm.setString(4, regno);
stm.setString(5,phn);
int x = stm.executeUpdate();
System.out.println("Data upadated sucessfully...." + x);
if(x > 0){
res.sendRedirect("LoginForm.html");
}
else{
out.println("<html>Register Not successful</html>");
}
con.close();}
catch(Exception e){
out.print(e);
}}}