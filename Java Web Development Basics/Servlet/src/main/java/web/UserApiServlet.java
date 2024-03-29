package web;

import entities.User;
import services.JsonParser;
import services.UsersService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/users")
public class UserApiServlet extends HttpServlet {

    private final UsersService usersService;
    private final JsonParser jsonParser;

    @Inject
    public UserApiServlet(UsersService usersService, JsonParser jsonParser) {
        this.usersService = usersService;
        this.jsonParser = jsonParser;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = usersService.getAllUsers();
        String usersJson = jsonParser.toJson(users);
        resp.getWriter()
                .write(usersJson);
    }
}
