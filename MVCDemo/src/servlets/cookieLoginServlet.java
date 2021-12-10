package servlets;

import entity.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet(name = "cookieLoginServlet",urlPatterns = "/cookieLogin")
public class cookieLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String userInfo, userName = "", userPwd = "";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user_cookie")) {
                    userInfo = cookie.getValue();
                    String[] user = URLDecoder.decode(userInfo,"utf-8").split(",");
                    userName = user[0];
                    userPwd = user[1];
                    break;
                }
            }
            if (userName.equals("13890794742") && userPwd.equals("201931061165jing")) {
                User user = new User();
                user.setUsername(userName);
                user.setPassword(userPwd);
                HttpSession session=request.getSession();
                session.setAttribute("user",user);
                response.sendRedirect("list");
            } else {
                response.sendRedirect("login.html");
            }
        } else {
            response.sendRedirect("login.html");
        }
    }
}
