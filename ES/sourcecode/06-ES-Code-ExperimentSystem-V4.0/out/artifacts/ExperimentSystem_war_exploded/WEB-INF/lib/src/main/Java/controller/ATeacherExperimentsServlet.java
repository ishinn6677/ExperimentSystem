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
import java.util.List;
import java.util.Vector;

/**
 * @author ：
 * @date ：Created in 2020/12/17 17:07
 * @description ： 某个实验老师的所有实验
 */
@WebServlet(name = "ATeacherExperimentsServlet",urlPatterns = "/ATeacherExperimentsServlet")
public class ATeacherExperimentsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        Login user=(Login)session.getAttribute("user_info");
        System.out.println(user.toString());
        String id=user.getId();
        ExperimentService es=new ExperimentService();
        //全部Experiment
        List<Experiment> experiment=es.findAll();
        int count1=experiment.size();
        Vector<Experiment> experimentList = new Vector<Experiment>();
        System.out.println("id:"+id);
        //前端需要获取到的course
        for (int j = 0; j <count1; j++) {
            if(experiment.get(j).getEx_teacher_id().equals(id))
            experimentList.add(experiment.get(j));
            System.out.println(experiment.get(j).toString());
        }
        int count=experimentList.size();
        // TODO: 2020/12/28 选取某一实验的学生个数
        request.setAttribute("count",count);
        request.setAttribute("experimentList",experimentList);
        request.getRequestDispatcher("change_experiment.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        Login user=(Login)session.getAttribute("user_info");
        String id=user.getId();
        ExperimentService es=new ExperimentService();
        //全部Experiment
        List<Experiment> experiment=es.findAll();
        int count1=experiment.size();
        Vector<Experiment> experimentList = new Vector<Experiment>();
        System.out.println("id:"+id);
        //前端需要获取到的course
        for (int j = 0; j <count1; j++) {
            if(experiment.get(j).getEx_teacher_id().equals(id))
                experimentList.add(experiment.get(j));
        }
        int count=experimentList.size();
        request.setAttribute("count",count);
        request.setAttribute("experimentList",experimentList);
        request.getRequestDispatcher("chang_experiment.jsp").forward(request,response);
    }
}
