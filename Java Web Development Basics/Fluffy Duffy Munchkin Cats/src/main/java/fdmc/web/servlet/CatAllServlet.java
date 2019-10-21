package fdmc.web.servlet;

import fdmc.domain.entities.Cat;
import fdmc.util.HtmlReader;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class CatAllServlet extends HttpServlet {

    private static final String ALL_CAT_HTML_PATH = "D:\\Project\\Java\\Java Web\\Java Web Development Basics\\Fluffy Duffy Munchkin Cats\\src\\main\\resources\\views\\cat-all.html";

    private final HtmlReader htmlReader;

    @Inject
    public CatAllServlet(HtmlReader htmlReader) {
        this.htmlReader = htmlReader;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String htmlFileContent = this.htmlReader.readHtmlFile(ALL_CAT_HTML_PATH);
        if (req.getSession().getAttribute("cats") != null) {
            StringBuilder sb = new StringBuilder();
            ((Map<String, Cat>) req.getSession()
                    .getAttribute("cats"))
                    .values()
                    .stream()
                    .forEach(cat -> {
                        sb.append(String.format("<a href=\"/cats/profile?catName=%s\">%s</a><br>", cat.getName(), cat.getName()))
                                .append(System.lineSeparator());
                    });

            htmlFileContent = htmlFileContent.replace("{{allCats}}", sb.toString().trim());
        } else
            htmlFileContent = htmlFileContent.replace("{{allCats}}", "There are no cats. <a href=\"/cats/create\">Create some</a>");

        resp.getWriter().println(htmlFileContent);
    }


}

