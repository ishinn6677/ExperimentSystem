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
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        boolean isExist=false;
        HttpSession session = request.getSession();
        //学工号，密码，验证码
        String id,pwd;
        id=request.getParameter("userName");
        pwd=request.getParameter("password");
        //在session封装当前用户的状态
        Login login;
        LoginService ls=new LoginService();
        //判断是否正确
        if(ls.getPwdById(id).equals(pwd)){
            isExist=true;
            System.out.println("yes");
        }
        System.out.println("过来了");
        if(isExist==true){
            login=ls.getUsrById(id);
            session.setAttribute("user_info",login);
            //学生
            if(login.getIdentify().equals("student"));
            {
                response.getWriter().write("student");
            }
            //机房老师
            if(login.getIdentify().equals("lab_teacher"))
            {
                response.getWriter().write("lab_teacher");
            }
            //实验老师
            if(login.getIdentify().equals("experiment_teacher"))
            {
                response.getWriter().write("experiment_teacher");
            }
            //教务处
            if(login.getIdentify().equals("academic_admin"))
            {
                response.getWriter().write("academic_admin");
            }

        }
        else{
            response.getWriter().write("flase");
            System.out.println("no");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}



