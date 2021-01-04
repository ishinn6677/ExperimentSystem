package main.Java.controller;
import main.Java.entity.Experiment;
import main.Java.entity.Login;
import main.Java.entity.SelectEx;
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
 * @description ： 一个实验的所有学生的成绩
 */
@WebServlet(name = "AExperimentScoreServlet",urlPatterns = "/AExperimentScoreServlet")
public class AExperimentScoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        Login login=(Login)session.getAttribute("user_info");
        int ex_id=Integer.parseInt(request.getParameter("exid"));
        SelectExService ss=new SelectExService();
        List<SelectEx>  selectEx= ss.getSeExsByExId(ex_id);
        Vector<SelectEx> selectExList = new Vector<SelectEx>();
        int count=selectEx.size();
        for (int j = count-1; j >= 0; j--) {
            System.out.println("dopost"+selectEx.get(j).toString());
            selectExList.add(selectEx.get(j));
        }
        count=selectExList.size();
        request.setAttribute("count",count);
        request.setAttribute("selectExList",selectExList);
        for(SelectEx selectEx1:selectExList){
            System.out.println(selectEx1);
        }

        request.getRequestDispatcher("changeScore.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        Login login=(Login)session.getAttribute("user_info");
        int ex_id=Integer.parseInt(request.getParameter("exid"));
        SelectExService ss=new SelectExService();
        List<SelectEx>  selectEx= ss.getSeExsByExId(ex_id);
        Vector<SelectEx> selectExList = new Vector<SelectEx>();
        int count=selectEx.size();
        for (int j = count-1; j >= 0; j--) {
            System.out.println("dopost"+selectEx.get(j).toString());
            selectExList.add(selectEx.get(j));
        }
        count=selectExList.size();
        request.setAttribute("count",count);
        request.setAttribute("selectExList",selectExList);
        request.getRequestDispatcher("changeScore.jsp").forward(request,response);
    }
}
