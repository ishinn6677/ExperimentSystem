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
import java.util.List;
import java.util.Vector;
@WebServlet(name = "QueryCourseServlet" ,urlPatterns = "/QueryCourseServlet")
public class QueryCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        CourseService cs=new CourseService();
        int page=Integer.parseInt(request.getParameter("page"));
        int limit=Integer.parseInt(request.getParameter("limit"));
        System.out.println(page+" "+" "+limit);
        //全部course
        List<Course> course=cs.findAll();
        int count=course.size();
        Vector<Course> courseList = new Vector<Course>();
        //前端需要获取到的course
        for (int j = count-(page-1)*limit; j > count-(page)*limit; j--) {
            System.out.println("dopost"+course.get(j).toString());
            courseList.add(course.get(j));
        }
        request.setAttribute("count",count);
        request.setAttribute("courseList",courseList);
        request.getRequestDispatcher("change.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        CourseService cs=new CourseService();
        int page;
        int limit;
        page=Integer.parseInt(request.getParameter("page"));
        limit=Integer.parseInt(request.getParameter("limit"));
        System.out.println(page+" "+" "+limit);
        //全部course
        List<Course> course=cs.findAll();
        int count=course.size();
        Vector<Course> courseList = new Vector<Course>();
        //前端需要获取到的course
        for (int j = count-(page-1)*limit-1; j > count-(page)*limit&&j>=0; j--) {
            courseList.add(course.get(j));
            System.out.println("get:"+course.get(j).toString());
        }
        request.setAttribute("count",count);
        request.setAttribute("courseList",courseList);
        request.getRequestDispatcher("change.jsp").forward(request,response);

    }
}
