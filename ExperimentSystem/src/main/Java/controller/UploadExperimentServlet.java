package controller;

import entity.Experiment;
import entity.Login;
import service.ExperimentService;

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
 * @description ： 教师上传实验内容
 */

@WebServlet(name = "UploadExperimentServlet")
public class UploadExperimentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("").forward(request,response);
        }
        //用户已经登录
        ExperimentService es=new ExperimentService();
        //实验编号
        int id=100;
        //实验名 实验内容 截止日期 机房
        String Ex_name,Ex_content,deadline,Room;
        //实验老师id,实验老师姓名
        String Ex_teacher_id,Ex_teacher_name;
        Ex_content=request.getParameter("Ex_content");
        Ex_name=request.getParameter("Ex_name");
        deadline=request.getParameter("deadline");
        Room=request.getParameter("Room");
        //获取实验老师信息
        Login login=new Login();
        login=(Login)session.getAttribute("user_info");
        Ex_teacher_id=login.getId();
        Ex_teacher_name=login.getName();
        Experiment experiment=new Experiment(id,Ex_name,Ex_teacher_id,Ex_teacher_name,Ex_content,deadline,Room);
        boolean ifSuccess= es.addExperiment(experiment);
        if(ifSuccess==true){
            request.getRequestDispatcher("").forward(request,response);
        }else{
            request.getRequestDispatcher("").forward(request,response);
        }
    }
}

