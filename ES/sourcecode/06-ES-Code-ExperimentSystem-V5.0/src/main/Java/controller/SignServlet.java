package main.Java.controller;
import main.Java.entity.Appoint;
import main.Java.entity.Login;
import main.Java.entity.Sign;
import main.Java.service.AppointService;
import main.Java.service.SignService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * @author ：
 * @date ：Created in 2021年1月1日21:42:51
 * @description ： 学生在某实验上签到
 */
@WebServlet(name = "SignServlet",urlPatterns = "/SignServlet")
public class SignServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "UTF-8" );
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.getRequestDispatcher("login.html").forward(request,response);
        }
        Login login=(Login)session.getAttribute("user_info");
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String date = localDate.format(dateTimeFormatter);
        System.out.println(date);//2020-01-11
        String stu_id=login.getId();
        String stu_name=login.getName();
        String ex_name=null;
        int appointmentId=Integer.parseInt(request.getParameter("appointmentId"));
        AppointService appointService=new AppointService();
        Appoint appoint= appointService.getAppointById(appointmentId);
        int ex_id=appoint.getEx_id();
        ex_name=appoint.getEx_name();
        int sign_id=0;
        SignService ss=new SignService();
        sign_id=ss.getMaxId()+1;
        Sign sign=new Sign(sign_id,ex_name,ex_id,date,stu_id,stu_name);

        SignService signService=new SignService();
        //是否存在签到记录signService.
        Boolean issign=false;
        issign=signService.isExistOfSignByExIdAndStuId(ex_id,stu_id);
        if(issign){
            response.getWriter().write("haveSign");
        }else {
            boolean result=ss.addSign(sign);
            if(result){
                response.getWriter().write("success");
            }else {
                response.getWriter().write("false");
            }
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
