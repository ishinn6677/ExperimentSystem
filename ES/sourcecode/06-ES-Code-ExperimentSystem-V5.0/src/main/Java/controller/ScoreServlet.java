package main.Java.controller;

import main.Java.service.SelectExService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 * @author ：
 * @date ：Created in 2020年12月28日15:29:21
 * @description ： 评分
 */
@WebServlet(name = "ScoreServlet",urlPatterns = "/ScoreServlet")
public class ScoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        int id=(int)session.getAttribute("id");
        String stu_id=request.getParameter("id");
        int grade=Integer.parseInt(request.getParameter("score"));
        SelectExService ss=new SelectExService();
        boolean result= ss.setGrade(id,stu_id,grade);
        if(result==true){
            response.getWriter().write("success");
        }else {
            response.getWriter().write("false");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
