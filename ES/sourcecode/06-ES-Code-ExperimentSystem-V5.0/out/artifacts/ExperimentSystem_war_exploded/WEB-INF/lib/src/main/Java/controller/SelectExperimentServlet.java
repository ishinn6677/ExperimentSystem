package main.Java.controller;
import main.Java.entity.Experiment;
import main.Java.entity.Login;
import main.Java.entity.SelectEx;
import main.Java.service.ExperimentService;
import main.Java.service.SelectExService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 * @author ：
 * @date ：Created in 2021年1月2日00:06:24
 * @description ： 选择实验
 */
@WebServlet(name = "SelectExperimentServlet",urlPatterns = "/SelectExperimentServlet")
public class SelectExperimentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        Login login=(Login)session.getAttribute("user_info");
        String student_name=login.getName();
        String student_id=login.getId();
        int ex_id=Integer.parseInt(request.getParameter("id"));
        ExperimentService es=new ExperimentService();
        Experiment experiment=es.getExperimentById(ex_id);
        String experiemnt_name=experiment.getEx_name();
        SelectExService se=new SelectExService();
        int max_id=se.getMaxId();
        SelectEx selectex=new SelectEx(max_id,ex_id,experiemnt_name,student_id,student_name,"null",0);
        boolean result= se.addSelectEx(selectex);
        if(result){
            response.getWriter().write("");
        }else {
            response.getWriter().write("");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
