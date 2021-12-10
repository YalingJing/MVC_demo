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

@WebServlet(name = "editServlet",urlPatterns = "/edit")
public class editServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ret = 0;
        //获取参数
        String id = request.getParameter("id");
        //调用获取单个学生的方法
        editService service = new editService();
        Student stu = service.getStuById(id);
        request.setAttribute("stu",stu);
        request.getRequestDispatcher("edit.jsp").forward(request,response);

    }
}
