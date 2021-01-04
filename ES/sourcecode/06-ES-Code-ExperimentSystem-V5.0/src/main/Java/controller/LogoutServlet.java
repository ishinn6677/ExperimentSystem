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
 * @description ： 退出登录
 */

@WebServlet(name = "LogoutServlet",urlPatterns = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        //关闭会话
        response.sendRedirect("login.html");
        //request.getRequestDispatcher("login.html").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        //关闭会话
        response.sendRedirect("login.html");
        //request.getRequestDispatcher("login.html").forward(request,response);
    }
}
