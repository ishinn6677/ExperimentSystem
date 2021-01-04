package main.Java.controller;

import main.Java.entity.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 * @author ：
 * @date ：Created in 2021年1月2日10:05:10
 * @description ： 学生上传实验报告
 */
@WebServlet(name = "ModifyExReportServlet",urlPatterns = "/ModifyExReportServlet")
public class ModifyExReportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        Login login=(Login)session.getAttribute("user_info");
        String student_id=login.getId();
        String student_name=login.getName();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
