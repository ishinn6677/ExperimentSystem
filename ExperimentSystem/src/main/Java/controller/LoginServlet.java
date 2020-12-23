package controller;
import entity.Login;
import entity.User;
import service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author ：
 * @date ：Created in 2020/12/17 17:07
 * @description ： 登录
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        boolean isExist=false;
        HttpSession session = request.getSession();
        //学工号，密码，验证码
        String id,pwd;
        id=request.getParameter("username");
        pwd=request.getParameter("password");
        //在session封装当前用户的状态
        Login login=new Login();
        LoginService ls=new LoginService();
        //判断是否正确
        if(ls.getPwdById(id).equals(pwd)){
            isExist=true;
        }
        if(isExist==true){
            login=ls.getUsrById(id);
            session.setAttribute("user_info",login);
            request.getRequestDispatcher("success.jsp").forward(request,response);
        }
        else{
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}



