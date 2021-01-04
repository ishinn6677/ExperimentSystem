package main.Java.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 * @author ：
 * @date ：Created in  2020年12月27日19:54:29
 * @description ： 切换实验session
 */
@WebServlet(name = "SwitchExperimentSessionServlet",urlPatterns = "/SwitchExperimentSessionServlet")
public class SwitchExperimentSessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        String ex_id=request.getParameter("id");
        String flag;
        if(ex_id!=null){
            flag="success";
            System.out.println("ex_id:"+ex_id);
            session.setAttribute("id",ex_id);
        }else {
            flag="false";
        }
        response.getWriter().write(flag);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
