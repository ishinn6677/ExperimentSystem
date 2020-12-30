package main.Java.controller;

import main.Java.entity.Login;
import main.Java.service.LoginService;

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
 * @description ： 更改密码
 */

@WebServlet(name = "ModifyPasswordServlet",urlPatterns = "/ModifyPasswordServlet")
public class ModifyPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        LoginService ls=new LoginService();
        Login user=(Login) session.getAttribute("user_info");
        String pwd= user.getPwd();
        String newPassword=request.getParameter("newPassword");
        String password=request.getParameter("password");
        if(password.equals(pwd)){
            if(ls.updatePwdById(user.getId(), newPassword)){
                response.getWriter().write("success");
            }else{
                response.getWriter().write("fail");
            }
        }else{
            response.getWriter().write("fail");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
