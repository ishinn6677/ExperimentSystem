package main.Java.controller;
import main.Java.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DelCourseServlet",urlPatterns = "/DelCourseServlet")
public class DelCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        CourseService cs=new CourseService();
        String str=request.getParameter("id");
        if(str==null){
            System.out.println("null of  request.getparameter(id)");
            response.getWriter().write("false");
        }else{
            int id=Integer.parseInt(request.getParameter(str));
            boolean result=false;
            result= cs.delCourseById(id);
            if(result){
                response.getWriter().write("success");
            }else{
                response.getWriter().write("false");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        CourseService cs=new CourseService();
        //service 获取idmax +1
        int id=Integer.parseInt(request.getParameter("id"));
        boolean result=false;
        result= cs.delCourseById(id);
        if(result){
            response.getWriter().write("success");
        }else{
            response.getWriter().write("false");
        }
    }
}
