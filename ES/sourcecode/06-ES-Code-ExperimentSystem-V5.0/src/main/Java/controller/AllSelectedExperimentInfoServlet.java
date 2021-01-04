package main.Java.controller;

import main.Java.entity.Experiment;
import main.Java.entity.Login;
import main.Java.entity.MyExperiment;
import main.Java.entity.SelectEx;
import main.Java.service.ExperimentService;
import main.Java.service.MyExperimentService;
import main.Java.service.SelectExService;

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
 * @date ：Created in 2021年1月1日21:42:51
 * @description ： 学生所有选择的实验的信息
 */
@WebServlet(name = "AllSelectedExperimentInfoServlet",urlPatterns = "/AllSelectedExperimentInfoServlet")
public class AllSelectedExperimentInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        Login login=(Login) session.getAttribute("user_info");
        String std_id=login.getId();
        ExperimentService es=new ExperimentService();
        //全部course
        MyExperimentService myExperimentService = new MyExperimentService();
        Vector<MyExperiment> myExperiments = myExperimentService.getMyExperimentByStuId(std_id);
        for(MyExperiment myExperiment:myExperiments){
            System.out.println(myExperiment.toString());
        }
        int count=myExperiments.size();
        request.setAttribute("count",count);
        request.setAttribute("experimentList",myExperiments);
        request.getRequestDispatcher("change_experiment.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        Login login=(Login) session.getAttribute("user_info");
        String std_id=login.getId();
        ExperimentService es=new ExperimentService();
        //全部course
        MyExperimentService myExperimentService = new MyExperimentService();
        List<MyExperiment> myExperiments = myExperimentService.getMyExperimentByStuId(std_id);
        for(MyExperiment myExperiment:myExperiments){
            System.out.println(myExperiment.toString());
        }
        int count=myExperiments.size();
        request.setAttribute("count",count);
        request.setAttribute("experimentList",myExperiments);
        request.getRequestDispatcher("change_experiment.jsp").forward(request,response);
    }
}
