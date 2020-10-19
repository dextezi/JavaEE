import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String exc = request.getParameter("exchange");
        String am = request.getParameter("amount");
        double excn = Double.parseDouble(exc);
        double amn = Double.parseDouble(am);
        double result = excn*amn;
        //String res = String.valueOf(result);

        try {
            if (amn > 100.0) {
                writer.println("<p><font size=\"5\" color=\"red\"><b>Result: " + result + "</b></font></p>");
            }
            else {
                writer.println("<p><font size=\"5\">Result: " + result + "</font></p>");
            }
        } finally {
            writer.close();
        }
    }
}