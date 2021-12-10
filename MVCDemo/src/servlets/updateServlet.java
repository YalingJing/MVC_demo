package servlets;

import entity.Student;
import service.editService;
import service.updateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateServlet",urlPatterns = "/update")
public class updateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ret = 0;
        int id = Integer.parseInt(request.getParameter("id"));
        String sno = request.getParameter("stuno");
        String name = request.getParameter("stuname");
        Student s = new Student();
        s.setId(id);
        s.setSno(sno);
        s.setName(name);
        updateService updateservice = new updateService();
        try {
            ret = updateservice.updateStu(s);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(ret > 0){
            request.getRequestDispatcher("list").forward(request,response);
        }
    }
}
