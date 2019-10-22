//package web.filters;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter({
//        "/views/user-posts-count.jsf",
//        "/views/user-posts.jsf",
//        "/views/user-list.jsf",
//})
//public class AuthorizationAdminFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        String userRole = (String) ((HttpServletRequest) servletRequest).getSession().getAttribute("role");
//
//        if (!userRole.equals("Admin")) {
//            ((HttpServletResponse) servletResponse).sendRedirect("/views/home.jsf");
//            return;
//        }
//
//        filterChain.doFilter(servletRequest, servletResponse);
//
//
//    }
//}
