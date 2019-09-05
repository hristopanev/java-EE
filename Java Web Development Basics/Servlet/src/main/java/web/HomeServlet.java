package web;

import services.ViewsProvider;
import viewmodels.HomeViewModel;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constants.ViewConstants.VIEW_MODEL_ATTRIBUTE_NAME;

@WebServlet("/")
public class HomeServlet extends HttpServlet {

//    private final ViewsProvider viewsProvider;
//
//    @Inject
//    public HomeServlet(ViewsProvider viewsProvider) {
//        this.viewsProvider = viewsProvider;
//    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getAttribute("currentDate");
        String name = "Gosho";
        int age = 12;

        req.setAttribute(VIEW_MODEL_ATTRIBUTE_NAME, new HomeViewModel(name, age));

        req.getRequestDispatcher("home.jsp")
                .forward(req, resp);
    }
}
