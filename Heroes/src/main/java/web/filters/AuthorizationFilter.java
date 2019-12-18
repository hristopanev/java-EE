package web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({"/views/home.jsf",
        "/views/delete-hero.jsf",
        "/views/details-hero.jsf",
        "/views/create-hero.jsf"})
public class AuthorizationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String userId = (String) ((HttpServletRequest) servletRequest).getSession().getAttribute("user-id");

        if (userId == null) {
            ((HttpServletResponse) servletResponse).sendRedirect("/views/login.jsf");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
