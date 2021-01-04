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
 * @date ：Created in 2021年1月1日21:58:38
 * @description ： 某个实验的详细信息
 */
@WebServlet(name = "ExperimentInfoServlet",urlPatterns = "/ExperimentInfoServlet")
public class ExperimentInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        ExperimentService es=new ExperimentService();
        int ex_id=(int)session.getAttribute("id");
        Experiment experiment= es.getExperimentById(ex_id);
        request.setAttribute("experiment",experiment);
        //todo 某一实验信息json的详细项 修改 change_experiment.jsp
        request.getRequestDispatcher("change_experiment.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
