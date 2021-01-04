package main.Java.controller;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import main.Java.entity.Login;
import main.Java.service.LoginService;
/**
 * @author ：
 * @date ：Created in  2020年12月27日19:54:29
 * @description ： 修改个人信息
 */

@WebServlet(name = "ModifyInfServlet",urlPatterns = "/ModifyInfServlet")
public class ModifyInfServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        LoginService ls=new LoginService();
        Login user=(Login) session.getAttribute("user_info");
        String address=request.getParameter("address");
        String sex=request.getParameter("sex");
        String birthday=request.getParameter("birthday");
        boolean result;
        user.setAddress(address);
        user.setBirthday(birthday);
        user.setSex(sex);
        result=ls.updateInfo(user);
        //service
        if(result){
            response.getWriter().write("success");
        }else {
            response.getWriter().write("fail");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
