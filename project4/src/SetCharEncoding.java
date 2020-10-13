import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
@WebFilter(
		description = "устанавливает кодировку",
		servletNames = {"Servlet1","Servlet2"},
		initParams = { 
				@WebInitParam(name = "def-encoding", value = "windows-1251", description = "default encoding")
		})
public class SetCharEncoding implements Filter {
	protected String enc;
	protected FilterConfig fc;

    public SetCharEncoding() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String encoding = request.getCharacterEncoding();
		encoding = (encoding == ""||encoding==null)? enc: encoding;
		response.setCharacterEncoding(encoding);

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		fc = fConfig;
		enc = fc.getInitParameter("def-encoding"); 
	}
}
