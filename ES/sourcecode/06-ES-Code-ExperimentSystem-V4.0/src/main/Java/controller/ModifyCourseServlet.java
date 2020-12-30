package main.Java.controller;

import main.Java.entity.Course;
import main.Java.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 * @author ：
 * @date ：Created in  2020年12月27日19:54:29
 * @description ： 修改课程信息
 */

public class ModifyCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        String courseName=request.getParameter("courseName");
        String teather=request.getParameter("teather");
        String classroom=request.getParameter("classroom");
        int year=Integer.parseInt(request.getParameter("year"));
        int term=Integer.parseInt(request.getParameter("term"));
        int beginWeek=Integer.parseInt(request.getParameter("beginWeek"));
        int endWeek=Integer.parseInt(request.getParameter("endWeek"));
        int weekDay=Integer.parseInt(request.getParameter("weekDay"));
        int dayOrder=Integer.parseInt(request.getParameter("dayOrder"));
        CourseService cs=new CourseService();
        int id=Integer.parseInt(request.getParameter("id"));
        Course course=new Course(id,year,term,beginWeek,endWeek,weekDay,dayOrder,courseName,teather,classroom);
        //修改课程在service
        boolean result= cs.addCourse(course);

        if(result){
            response.getWriter().write("success");
        }else{
            response.getWriter().write("fail");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
