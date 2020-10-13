import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(description = "Сервлет с куки", urlPatterns = { "/Servlet2" })
public class Servlet2 extends HttpServlet {
	Date date;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String username = request.getParameter("username");
       if ((username == null) || (username.length() == 0)) {
    	   return;
       }

       int count = 0;
       String greetingString;
       Cookie cookie = null;
 	   Cookie[] cookies = request.getCookies();
  	   if(cookies != null) {
  		   for (int i = 0; i < cookies.length; i++) {
   			   if (cookies[i].getName().equals(username)) {
   				   cookie = cookies[i];
   				   count = Integer.parseInt(cookie.getValue());
   				   //break;
   			   }
           }
       }
   	   if (cookie == null||count==0) {
   		   greetingString = "С началом!";
   		   date = new Date();
   		   cookie = new Cookie(username, "1");
   	   } else {
		   greetingString = "Вы у нас были " + count + " раз(а)!\n" + date;
		   date = new Date();
		   cookie = new Cookie(username, Integer.valueOf(++count).toString());
       }
   	   cookie.setPath(request.getContextPath());
   	   cookie.setMaxAge(10*60);
   	   response.addCookie(cookie);
       PrintWriter out = response.getWriter();
   	   out.println("Привет, " + username );
       out.println(greetingString);
       out.close();
	}
}
