//package web.filters;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter({
//        "/views/create-post.jsf",
//        "/views/delete-post.jsf",
//        "/views/details-post.jsf",
//        "/views/details-user.jsf",
//        "/views/edit-post.jsf",
//        "/views/home.jsf",
//        "/views/profile.jsf",
//        "/views/user-posts-count.jsf",
//        "/views/user-posts.jsf",
//        "/views/user-list.jsf",
//})
//public class GuestUserFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        String userId = (String) ((HttpServletRequest) servletRequest).getSession().getAttribute("user-id");
//
//        if (userId == null) {
//            ((HttpServletResponse) servletResponse).sendRedirect("/views/login.jsf");
//            return;
//        }
//
//        filterChain.doFilter(servletRequest, servletResponse);
//
//
//    }
//}
