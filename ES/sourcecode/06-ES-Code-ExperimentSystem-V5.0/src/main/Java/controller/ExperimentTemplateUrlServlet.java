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
 * @date ：Created in 2021年1月1日21:42:51
 * @description ： 下载实验模板的地址
 */
@WebServlet(name = "ExperimentTemplateUrlServlet",urlPatterns = "/ExperimentTemplateUrlServlet")
public class ExperimentTemplateUrlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        int ex_id= Integer.parseInt(request.getParameter("id"));
        ExperimentService es=new ExperimentService();
        Experiment experiment=es.getExperimentById(ex_id);
        String url=experiment.getUpload();
        response.getWriter().write(url);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
