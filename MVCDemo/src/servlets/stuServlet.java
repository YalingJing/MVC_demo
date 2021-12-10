package servlets;

import entity.Student;
import service.stuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "com.servlets.stuServlet",urlPatterns = "/list")
public class stuServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter p = response.getWriter();
        if(request.getSession().getAttribute("user")==null){
            p.print("<h1 align='center'>未登陆，不能访问，请登陆后访问</h1>"+"<br>");
            p.print("<p align='center'>3s后将跳转到登陆页面</p>");
            response.setHeader("Refresh", "3,URl=http://localhost:8080/MVCDemo/login.html");
        }
        else{
            stuService service = new stuService();
            ArrayList<Student> list = service.getStuList();
            request.setAttribute("list",list);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }

    }
}
