package main.Java.controller;
import main.Java.entity.Experiment;
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
 * @description ： 显示某一实验的实验简介
 */
@WebServlet(name = "ExperimentIntroductionServlet",urlPatterns = "/ExperimentIntroductionServlet")
public class ExperimentIntroductionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        //todo  确定id
        int id=Integer.parseInt(request.getParameter("id"));
        ExperimentService es=new ExperimentService();
        Experiment  experiment= es.getExperimentById(id);
        String experiment_introduction=experiment.getEx_content();
        response.getWriter().write(experiment_introduction);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        //todo  确定id
        int id=Integer.parseInt(request.getParameter("id"));
        ExperimentService es=new ExperimentService();
        Experiment  experiment= es.getExperimentById(id);
        String experiment_introduction=experiment.getEx_content();
        response.getWriter().write(experiment_introduction);
    }
}
