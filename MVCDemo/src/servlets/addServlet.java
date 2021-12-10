package servlets;


import entity.Student;
import service.addService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addServlet",urlPatterns = "/add")
public class addServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student stu=new Student();
        stu.setSno(request.getParameter("stuno"));
        stu.setName(request.getParameter("stuname"));

        addService service=new addService();
        int ret=service.insertStu(stu);
        System.out.println(ret);
        if(ret>0) {
            request.getRequestDispatcher("list").forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
