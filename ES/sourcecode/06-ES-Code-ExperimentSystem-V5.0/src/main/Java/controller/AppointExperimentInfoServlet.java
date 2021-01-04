package main.Java.controller;
import main.Java.entity.Appoint;
import main.Java.entity.Login;
import main.Java.service.AppointService;
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
 * @date ：Created in 2021年1月1日21:09:25
 * @description ： 某个学生预约的所有实验的信息
 */
@WebServlet(name = "AppointExperimentInfoServlet",urlPatterns = "/AppointExperimentInfoServlet")
public class AppointExperimentInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        Login login=(Login)session.getAttribute("user_info");
        String student_id=login.getId();
        AppointService as=new AppointService();
        List<Appoint> appoint=as.findAll();
        int count=appoint.size();
        Vector<Appoint> appointList = new Vector<Appoint>();
        for (int j = count; j>=0; j--) {
            if(appoint.get(j)!=null&&appoint.get(j).getStu_id().equals(student_id)){
                System.out.println("dopost"+appoint.get(j).toString());
                appointList.add(appoint.get(j));
            }
        }
        count=appointList.size();
        request.setAttribute("count",count);
        request.setAttribute("appointList",appointList);
        request.getRequestDispatcher("change_student_appoint_info.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        Login login=(Login)session.getAttribute("user_info");
        String student_id=login.getId();
        AppointService as=new AppointService();
        List<Appoint> appoint=as.findAll();
        int count=appoint.size();
        Vector<Appoint> appointList = new Vector<Appoint>();
        for (int j = count-1; j>=0; j--) {
            if(appoint.get(j)!=null&&appoint.get(j).getStu_id().equals(student_id)){
                System.out.println("dopost"+appoint.get(j).toString());
                appointList.add(appoint.get(j));
            }
        }
        count=appointList.size();
        request.setAttribute("count",count);
        request.setAttribute("appointList",appointList);
        request.getRequestDispatcher("change_student_appoint_info.jsp").forward(request,response);
    }
}
