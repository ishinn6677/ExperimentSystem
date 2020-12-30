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
 * @date ：Created in  2020年12月28日14:48:10
 * @description ： 返回实验老师姓名
 */
@WebServlet(name = "ExperimentNameServlet",urlPatterns = "/ExperimentNameServlet")
public class ExperimentNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        Login user=(Login) session.getAttribute("user_info");
        request.setAttribute("user",user);
        System.out.println(user.getName());
        response.getWriter().write(user.getName());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
