package fdmc.web.servlet;

import fdmc.util.HtmlReader;

import javax.inject.Inject;
import javax.persistence.Index;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class IndexServlet extends HttpServlet {

    private final static String INDEX_HTML_FILE_PATH = "D:\\Project\\Java\\Java Web\\Java Web Development Basics\\Fluffy Duffy Munchkin Cats\\src\\main\\resources\\views\\index.html";

    private final HtmlReader htmlReader;

    @Inject
    public IndexServlet(HtmlReader htmlReader) {
        this.htmlReader = htmlReader;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter writer = resp.getWriter();

    writer.println(this.htmlReader.readHtmlFile(INDEX_HTML_FILE_PATH));

    }
}
