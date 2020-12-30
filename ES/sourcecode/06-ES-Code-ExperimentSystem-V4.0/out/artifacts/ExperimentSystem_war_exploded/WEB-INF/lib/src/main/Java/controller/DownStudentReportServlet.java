package main.Java.controller;

import com.mysql.cj.Session;
import main.Java.entity.SelectEx;
import main.Java.service.SelectExService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/*
 * @author ：
 * @date ：Created in 2020/12/17 17:07
 * @description ： 下载学生实验报告
 */
@WebServlet(name = "DownStudentReportServlet",urlPatterns = "/DownStudentReportServlet")
public class DownStudentReportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        int sid=Integer.parseInt(request.getParameter("id"));
        int id=(int)session.getAttribute("id");
        System.out.println("sid"+sid);
        System.out.println("id"+id);
        SelectExService ss=new SelectExService();
        SelectEx selectex =ss.getSelectExById(id);
        System.out.println("expweiment_student_reportpath:"+selectex.toString());
        String path=selectex.getReport();
        response.getWriter().write(path);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        int sid=Integer.parseInt(request.getParameter("id"));
        int id=(int)session.getAttribute("id");
        System.out.println("sid"+sid);
        System.out.println("id"+id);
        SelectExService ss=new SelectExService();
        SelectEx selectex =ss.getSelectExById(id);
        System.out.println("expweiment_student_reportpath:"+selectex.toString());
        String path=selectex.getReport();
        response.getWriter().write("UploadContent\\第九章补充练习题.pdf");
    }
}
