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
import java.util.List;
import java.util.Vector;

/**
 * @author ：
 * @date ：Created in 2021年1月1日21:42:51
 * @description ： 所有实验的信息
 */
@WebServlet(name = "AllExperimentInfoServlet",urlPatterns = "/AllExperimentInfoServlet")
public class AllExperimentInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        ExperimentService es=new ExperimentService();
        int page=Integer.parseInt(request.getParameter("page"));
        int limit=Integer.parseInt(request.getParameter("limit"));
        System.out.println(page+" "+" "+limit);
        //全部course
        List<Experiment> experiment=es.findAll();
        int count=experiment.size();
        Vector<Experiment> experimentList = new Vector<Experiment>();
        //前端需要获取到的course
        for (int j = count-(page-1)*limit; j >= count-(page)*limit; j--) {
            System.out.println("dopost"+experiment.get(j).toString());
            experimentList.add(experiment.get(j));
        }
        count=experimentList.size();
        request.setAttribute("count",count);
        request.setAttribute("experimentList",experimentList);
        request.getRequestDispatcher("chang_experiment.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        ExperimentService es=new ExperimentService();
        int page=Integer.parseInt(request.getParameter("page"));
        int limit=Integer.parseInt(request.getParameter("limit"));
        System.out.println(page+" "+" "+limit);
        //全部course
        List<Experiment> experiment=es.findAll();
        int count=experiment.size();
        Vector<Experiment> experimentList = new Vector<Experiment>();
        //前端需要获取到的course
        for (int j = count-(page-1)*limit-1; j >= count-(page)*limit&&j>=0; j--) {
            System.out.println("dopost"+experiment.get(j).toString());
            experimentList.add(experiment.get(j));
        }
        count=experimentList.size();
        request.setAttribute("count",count);
        request.setAttribute("experimentList",experimentList);
        request.getRequestDispatcher("chang_experiment.jsp").forward(request,response);
    }
}
