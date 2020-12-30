package main.Java.controller;

import main.Java.entity.Experiment;
import main.Java.entity.Login;
import main.Java.service.ExperimentService;

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

@WebServlet(name = "UploadExperimentServlet",urlPatterns = "/UploadExperimentServlet")
public class UploadExperimentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("").forward(request,response);
        }
        //用户已经登录
        ExperimentService es=new ExperimentService();
        //实验编号
        int id=100,year,term;
        //实验名 实验简介 截止日期 机房
        String Ex_name,Ex_content,deadline,Room,upload;
        //实验老师id,实验老师姓名
        String Ex_teacher_id,Ex_teacher_name;
        //实验简介
        Ex_content=request.getParameter("experimentIntroduction");
        System.out.println("实验简介:"+Ex_content);
        Ex_name=request.getParameter("experimentName");
        System.out.println("实验名:"+Ex_name);

        deadline=request.getParameter("experimentDdl");
        System.out.println("实验截止日期:"+deadline);
        Room=request.getParameter("experimentAddress");
        System.out.println("实验地址:"+Room);
        term=Integer.parseInt(request.getParameter("experimentTerm"));
        System.out.println("实验学期:"+term);
        year=Integer.parseInt(request.getParameter("experimentYear"));
        System.out.println("实验年份:"+year);
        upload = request.getParameter("file");
        System.out.println("实验文件地址:"+upload);
        //获取实验老师信息
        Login login=(Login)session.getAttribute("user_info");
        System.out.println("实验老师信息:"+login.toString());
        Ex_teacher_id=login.getId();
        Ex_teacher_name=login.getName();
        Experiment experiment=new Experiment(id,Ex_name,Ex_teacher_id,Ex_teacher_name,Ex_content,deadline,Room,term,year,upload);
        System.out.println(experiment.toString());
        boolean ifSuccess= es.addExperiment(experiment);
        if(ifSuccess==true){
            response.getWriter().write("success");
        }else{
            response.getWriter().write("false");
        }
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
        int id=100,year,term;
        //实验名 实验内容 截止日期 机房
        String Ex_name,Ex_content,deadline,Room,upload;
        //实验老师id,实验老师姓名
        String Ex_teacher_id,Ex_teacher_name;
        Ex_content=request.getParameter("Ex_content");
        Ex_name=request.getParameter("Ex_name");
        deadline=request.getParameter("deadline");
        Room=request.getParameter("Room");
        term=Integer.parseInt(request.getParameter("term"));
        year=Integer.parseInt(request.getParameter("year"));
        upload = request.getParameter("upload");
        //获取实验老师信息
        Login login=new Login();
        login=(Login)session.getAttribute("user_info");
        Ex_teacher_id=login.getId();
        Ex_teacher_name=login.getName();
        Experiment experiment=new Experiment(id,Ex_name,Ex_teacher_id,Ex_teacher_name,Ex_content,deadline,Room,term,year,upload);
        boolean ifSuccess= es.addExperiment(experiment);
        if(ifSuccess==true){
            response.getWriter().write("success");
        }else{
            response.getWriter().write("false");
        }
    }
}

