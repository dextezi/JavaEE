import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class first extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Content-Language", "en");
        PrintWriter writer = response.getWriter();
        String style = (String) request.getAttribute("style");
        writer.print("<html lang =\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>English page</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p>A posteriori, the gravitational paradox ambivalently understands an intelligible sign. According to famous philosophers, tertium non datur.\n" +
                "    Therefore, this law of the outside world creates. Doubt reflects the natural law except\n" +
                "    undefined. Contemplation is unpredictable. Contemplation is unpredictable. The axiom of syllogism, by definition, is an ambiguous subject of activity.\n" +
                "    The axiom of syllogism, by definition, is an ambiguous subject of activity. Structuralism is abstract. Structuralism is abstract. The axiom of syllogism, by definition\n" +
                "    Along with this sense of peace, he decisively controls the unforeseen gravitational paradox.\n" +
                "    The deductive method is decisively a baboonism. The deductive method is decisively a baboonism. Naturally, automation discredits the subject of activity.\n" +
                "    Intelligence naturally understands intelligence</p>\n" +
                "</body>\n" +
                "</html>");

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getContextPath() + "/rus.html";
        response.sendRedirect(path);
    }
}