import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebFilter(urlPatterns = { "/first" })
public class Contenttypefilter implements Filter  {

    protected FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if(res.getHeader("Content-Language") == null) {
            res.setHeader("Content-Language", "en");
        }

        if(!res.getHeader("Content-Language").equals("ru")) {
            res.setContentType("text/html");
            res.setCharacterEncoding("UTF-8");
            PrintWriter writer = res.getWriter();
            writer.println("<form action=\"first\" method=\"POST\">\n" +
                    "    Страница на английском языке, хотите перевести?<br>\n" +
                    "    <input type=\"submit\" value=\"Да\" />\n" +
                    "</form>\n");
        }
        chain.doFilter(req,res);
    }


}
