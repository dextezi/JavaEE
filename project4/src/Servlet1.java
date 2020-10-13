import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(
		description = "Сервлет для логина",
		name = "Servlet1",
		urlPatterns = { 
				"/Servlet1", 
				"/index.htm", 
				"/index.html"
		})
public class Servlet1 extends HttpServlet {
	@Override
    public void service(
        HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
	       response.setContentType("text/html");
	       response.setCharacterEncoding("windows-1251");
	       response.setBufferSize(8192);

	       PrintWriter out = response.getWriter();

	        out.println(
	                "<html lang=\"ru-RU\">"
	                + "<head><title>Добро пожаловать</title></head>");
	        out.println(
	                "<body  bgcolor=\"#ffffff\">"
	                + "<form method=\"get\""
	                + "action=\"http://localhost:8080"
	                + getServletContext().getContextPath() + "/Servlet2\">"
	                + "<h2>Привет, как Ваше имя?</h2>"
	                + "<input title=\"Меня зовут:  \" type=\"text\" name=\"username\" size=\"25\"/>"
	                + "<p></p>" + "<input type=\"submit\" value=\"Submit\"/>"
	                + "<input type=\"reset\" value=\"Reset\"/>" + "</form>");
	        out.println("</body></html>");
	        out.close();


	}

}
