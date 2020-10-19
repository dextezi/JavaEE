import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
@WebFilter(urlPatterns = { "/first" })
public class filter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {   }

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chainObj) throws IOException, ServletException {

		String value = "";
		if(req.getParameter("time") == null){
			Calendar c = new GregorianCalendar();
			int t = c.get(Calendar.HOUR_OF_DAY);
			if (t>5 && t<22) {
				value =  "<style type=\"text/css\">\n" +
						"    body {background: #ffcc00;}\n" +
						"  </style></head><body><img src=\"images/solnce.png\" \n" +
						"  width=\"57\" height=\"57\" alt=\"lorem\">";
			}
			else {
				value = "<style type=\"text/css\">\n" +
						"    body {background: #0093d3;}\n" +
						"  </style></head><body><img src=\"images/luna.png\" \n" +
						"  width=\"57\" height=\"57\" alt=\"lorem\">";
			}
		}
		else {
			String add_time = req.getParameter("time");
			int time = Integer.parseInt(add_time);
			Calendar c = new GregorianCalendar();
			c.add(Calendar.HOUR_OF_DAY, time);
			int t = c.get(Calendar.HOUR_OF_DAY);
			if (t > 5 && t < 22) {
				value = "<style type=\"text/css\">\n" +
						"    body {background: #ffcc00;}\n" +
						"  </style></head><body><img src=\"images/solnce.png\" \n" +
						"  width=\"57\" height=\"57\" alt=\"lorem\">";
			} else {
				value = "<style type=\"text/css\">\n" +
						"    body {background: #0093d3;}\n" +
						"  </style></head><body><img src=\"images/luna.png\" \n" +
						"  width=\"57\" height=\"57\" alt=\"lorem\">";
			}
		}
		req.setAttribute("style", value);
		chainObj.doFilter(req, resp);
	}

	public void destroy() { }
}