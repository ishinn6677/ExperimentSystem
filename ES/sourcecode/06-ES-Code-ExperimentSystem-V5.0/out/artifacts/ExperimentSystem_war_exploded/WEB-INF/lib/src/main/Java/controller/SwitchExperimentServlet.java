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
 * @date ：Created in  2020年12月27日19:54:29
 * @description ： 切换实验
 */

@WebServlet(name = "SwitchExperimentServlet",urlPatterns = "/SwitchExperimentServlet")
public class SwitchExperimentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        String sid=request.getParameter("id");
        String flag;
        int id;
        if(sid!=null){
            id=Integer.parseInt(sid);
            flag="success";
        }else {
            id=0;
            flag="false";
        }

        session.setAttribute("id",id);
        ExperimentService es=new ExperimentService();
        Experiment experiment=es.getExperimentById(id);
        request.setAttribute("experiment",experiment);
        System.out.println("id"+id);
        System.out.println(experiment.toString());
        request.setAttribute("flag",flag);
        request.getRequestDispatcher("switch_current_experiment.jsp").forward(request,response);
        response.getWriter();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        String sid=request.getParameter("id");
        String flag;
        int id;
        if(sid!=null){
            id=Integer.parseInt(sid);
            flag="success";
        }else {
            id=0;
            flag="false";
        }

        session.setAttribute("id",id);
        System.out.println("id"+id);
        ExperimentService es=new ExperimentService();
        Experiment experiment=es.getExperimentById(id);
        request.setAttribute("experiment",experiment);
        System.out.println(experiment.toString());
        request.setAttribute("flag",flag);
        request.getRequestDispatcher("switch_current_experiment.jsp").forward(request,response);
    }
}
