package servlets;

import entity.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet(name = "loginServlet",urlPatterns = "/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("check_code");
        String saveCode = (String) request.getSession().getAttribute("check_code");
        PrintWriter p = response.getWriter();
        //假设正确的用户名是13890794742
        // 密码是201931061165jing
        if(("13890794742").equals(username)&&("201931061165jing").equals(password)&&checkCode.equals(saveCode)){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            //设置cookie
            Cookie cookie = new Cookie("user_cookie", URLEncoder.encode(username+","+password,"utf-8"));
            cookie.setMaxAge(7*24*60);
            response.addCookie(cookie);
            HttpSession session=request.getSession();
            session.setAttribute("user",user);
            request.getRequestDispatcher("list").forward(request,response);
        }
        else if(checkCode.equals(saveCode)){
            p.print("<h1 align='center'>用户名或者密码错误，登陆失败</h1>"+"<br>");
            p.print("<p align='center'>3s后将重新回到登陆页面</p>");
            response.setHeader("Refresh", "3,URl=http://localhost:8080/MVCDemo/login.html");
        }
        else{
            p.print("<h1 align='center'>验证码错误，登陆失败</h1>"+"<br>");
            p.print("<p align='center'>3s后将重新回到登陆页面</p>");
            response.setHeader("Refresh", "3,URl=http://localhost:8080/MVCDemo/login.html");
        }
    }
}
