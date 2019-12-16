package cookbook.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({
        "/views/index.jsf",
        "/views/login.jsf",
        "/"
})
public class LoggedInUserFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String userId = (String) ((HttpServletRequest) servletRequest).getSession().getAttribute("user-id");

        if (userId != null) {
            ((HttpServletResponse) servletResponse).sendRedirect("/views/home.jsf");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);


    }
}
