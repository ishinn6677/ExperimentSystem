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
 * @description ： 判断是否选过实验，没选实验判断选择是否成功
 */
@WebServlet(name = "IfChooseExperimentServlet",urlPatterns = "/IfChooseExperimentServlet")
public class IfChooseExperimentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        Login login=(Login)session.getAttribute("user_info");
        String student_id=login.getId();
        int ex_id=Integer.parseInt(request.getParameter("id"));
        SelectExService se=new SelectExService();
        boolean ifchoose=false;
        boolean result=false;
        //result=se.addSelectEx();
        ifchoose=se.isExistOfSelect(ex_id,student_id);      //todo 判断是否存在选实验记录
        if(ifchoose){
            response.getWriter().write("YES");
        }else {
            //没选过
            String student_name=login.getName();
            ExperimentService es=new ExperimentService();
            Experiment experiment=es.getExperimentById(ex_id);
            String experiemnt_name=experiment.getEx_name();
            int max_id=se.getMaxId()+1;
            SelectEx selectex=new SelectEx(max_id,ex_id,experiemnt_name,student_id,student_name,null,-1);
            result= se.addSelectEx(selectex);
            if(result){
                response.getWriter().write("SUCCESS");
            }else {
                response.getWriter().write("FAILED");
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
