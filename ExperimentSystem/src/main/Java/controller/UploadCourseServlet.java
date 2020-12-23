package controller;

import entity.Course;
import service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UploadCourseServlet")
public class UploadCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("html/login.html").forward(request,response);
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
        //service 获取idmax +1
        int id=100;
        Course course=new Course(id,year,term,beginWeek,endWeek,weekDay,dayOrder,courseName,teather,classroom);
        boolean result= cs.addCourse(course);
        if(result){

        }else{

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
