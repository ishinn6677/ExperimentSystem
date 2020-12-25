package main.Java.controller;
import main.Java.entity.Course;
import main.Java.service.CourseService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UploadCourseServlet",urlPatterns = "/UploadCourseServlet")
public class UploadCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        String flag=request.getParameter("flag");
        String courseName=request.getParameter("courseName");
        String teacher=request.getParameter("teacher");
        String classroom=request.getParameter("classroom");
        int year=Integer.parseInt(request.getParameter("year"));
        int term=Integer.parseInt(request.getParameter("term"));
        int beginWeek=Integer.parseInt(request.getParameter("beginWeek"));
        int endWeek=Integer.parseInt(request.getParameter("endWeek"));
        int weekDay=Integer.parseInt(request.getParameter("weekDay"));
        int dayOrder=Integer.parseInt(request.getParameter("dayOrder"));
        if(flag.equals("addCourse")){
            CourseService cs=new CourseService();
            //service 获取idmax +1
            int id=cs.getMaxId()+1;
            Course course=new Course(id,year,term,beginWeek,endWeek,weekDay,dayOrder,courseName,teacher,classroom);
            boolean result= cs.addCourse(course);
            if(result){
                response.getWriter().write("success");
            }else{
                response.getWriter().write("false");
            }
        }else if(flag.equals("editCourse")){
            int id=Integer.parseInt(request.getParameter("id"));
            CourseService cs=new CourseService();
            //service 获取修改课程
            Course course=new Course(id,year,term,beginWeek,endWeek,weekDay,dayOrder,courseName,teacher,classroom);
            boolean result0=cs.delCourseById(id);
            boolean result= cs.addCourse(course);
            if(result&&result0){
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
        int id=cs.getMaxId()+1;
        Course course=new Course(id,year,term,beginWeek,endWeek,weekDay,dayOrder,courseName,teather,classroom);
        boolean result= cs.addCourse(course);
        if(result){

        }else{

        }
    }
}
